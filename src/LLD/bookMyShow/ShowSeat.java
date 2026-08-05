package LLD.bookMyShow;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class ShowSeat {
    private final Seat seat;
    private SeatStatus status;
    private LocalDateTime lockExpirationTime;
    private String lockedByUserId;
    private final ReentrantLock lock = new ReentrantLock(true);

    public ShowSeat(Seat seat) {
        this.seat = seat;
        this.status = SeatStatus.AVAILABLE;
    }

    public boolean lockSeat(String userId, int lockDurationInSeconds) {
        lock.lock();
        try {
            // Self-healing: Check if an existing lock expired!
            if (status == SeatStatus.TEMPORARILY_LOCKED && isLockExpired()) {
                releaseLockInternal();
            }

            if (status == SeatStatus.AVAILABLE) {
                this.status = SeatStatus.TEMPORARILY_LOCKED;
                this.lockedByUserId = userId;
                this.lockExpirationTime = LocalDateTime.now().plusSeconds(lockDurationInSeconds);
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    // Confirm booking after successful payment
    public boolean confirmBooking(String userId) {
        lock.lock();
        try {
            if (status == SeatStatus.TEMPORARILY_LOCKED && userId.equals(lockedByUserId) && !isLockExpired()) {
                this.status = SeatStatus.BOOKED;
                this.lockedByUserId = null;
                this.lockExpirationTime = null;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void releaseLock() {
        lock.lock();
        try {
            releaseLockInternal();
        } finally {
            lock.unlock();
        }
    }

    private void releaseLockInternal() {
        if (this.status == SeatStatus.TEMPORARILY_LOCKED) {
            this.status = SeatStatus.AVAILABLE;
            this.lockedByUserId = null;
            this.lockExpirationTime = null;
        }
    }

    public boolean isLockExpired() {
        return lockExpirationTime != null && LocalDateTime.now().isAfter(lockExpirationTime);
    }

    public SeatStatus getStatus() {
        lock.lock();
        try {
            if (status == SeatStatus.TEMPORARILY_LOCKED && isLockExpired()) {
                releaseLockInternal();
            }
            return status;
        } finally {
            lock.unlock();
        }
    }

    public Seat getSeat() {
        return seat;
    }

    public String getLockedByUserId() {
        return lockedByUserId;
    }
}
