package LLD.parkingLot;

import java.time.Duration;
import java.time.LocalDateTime;

import static LLD.parkingLot.VehicleType.*;

public class HourlyFeeStrategy implements FeesStrategy{

    @Override
    public double calculateFee(Ticket ticket) {
       long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
       if (hours==0) hours =1;

       double ratePerHour;
       switch (ticket.getVehicle().getVehicleType()){
           case MOTORCYCLE:ratePerHour = 10.0;break;
           case CAR:ratePerHour=20.0;break;
           case TRUCK:ratePerHour=50.0;break;
           default:ratePerHour=15.0;
       }
       return hours*ratePerHour;
    }
}
