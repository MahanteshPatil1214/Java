package LLD.parkingLot;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private static final Object lock = new Object();

    private final String name;
    private final List<ParkingFloor> floors;
    private final Map<String,Ticket> activeTickets = new ConcurrentHashMap<>();
    private ParkingStrategy parkingStrategy;
    private FeesStrategy feesStrategy;
    private final AtomicInteger ticketCOunter = new AtomicInteger(1000);

    public ParkingLot(String name, List<ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;
        this.parkingStrategy = new FirstAvailableStrategy();
        this.feesStrategy = new HourlyFeeStrategy();
    }

    public static ParkingLot getInstance(String name,List<ParkingFloor> floors){
        if (instance == null){
            synchronized (lock){
                if (instance == null){
                    instance = new ParkingLot(name,floors);
                }
            }
        }
        return instance;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void setFeesStrategy(FeesStrategy feesStrategy) {
        this.feesStrategy = feesStrategy;
    }

    public synchronized Optional<Ticket> parkVehicle(Vehicle vehicle){
        Optional<ParkingSpot> availableSpot = parkingStrategy.findSpot(floors,vehicle);
        if(availableSpot.isPresent()){
            ParkingSpot spot = availableSpot.get();
            if(spot.parkVehicle(vehicle)){
                String ticketId ="TKT-" + ticketCOunter.getAndIncrement();
                Ticket ticket = new Ticket(ticketId,vehicle,spot);
                activeTickets.put(ticketId,ticket);
                System.out.println("[ENTRY SUCCESS] " + vehicle.getVehicleType() + " (" + vehicle.getLicensePlate() + " ) parked at spot " + spot.getSpotId() + " . Ticket: " +ticketId);
                return Optional.of(ticket);
            }
        }
        System.out.println("[Entry Failed ] No available spot for " +vehicle.getLicensePlate());
        return Optional.empty();
    }

    public double exitVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Invalid ticket ID: " + ticketId);
        }

        ParkingSpot spot = ticket.getSpot();
        spot.vacateVehicle();

        double fee = feesStrategy.calculateFee(ticket);
        System.out.println("[EXIT SUCCESS] Vehicle " + ticket.getVehicle().getLicensePlate()
                + " vacated spot " + spot.getSpotId() + ". Total Fee: $" + fee);
        return fee;
    }

    public void displayStatus() {
        for (ParkingFloor floor : floors) {
            floor.displayAvailability();
        }
    }
}
