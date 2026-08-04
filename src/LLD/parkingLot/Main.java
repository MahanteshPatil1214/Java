package LLD.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 1. Setup parking floor and spots
        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add(new ParkingSpot("F1-S1", SpotType.SMALL));
        floor1Spots.add(new ParkingSpot("F1-M1", SpotType.MEDIUM));
        floor1Spots.add(new ParkingSpot("F1-L1", SpotType.LARGE));

        ParkingFloor floor1 = new ParkingFloor(1, floor1Spots);
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor1);

        // 2. Initialize Parking Lot
        ParkingLot parkingLot = ParkingLot.getInstance("Central Park", floors);
        parkingLot.displayStatus();

        // 3. Simulate Concurrent Vehicles Entering simultaneously
        ExecutorService gateExecutor = Executors.newFixedThreadPool(4);

        System.out.println("\n=== SIMULATING CONCURRENT VEHICLE ENTRIES ===");

        Runnable task1 = () -> parkingLot.parkVehicle(new Car("KA-01-1234"));
        Runnable task2 = () -> parkingLot.parkVehicle(new Car("KA-01-5678")); // Only 1 Large/Medium spot left for second car!
        Runnable task3 = () -> parkingLot.parkVehicle(new MotorCycle("KA-02-9999"));
        Runnable task4 = () -> parkingLot.parkVehicle(new Truck("KA-03-7777"));

        gateExecutor.execute(task1);
        gateExecutor.execute(task2);
        gateExecutor.execute(task3);
        gateExecutor.execute(task4);

        gateExecutor.shutdown();
        gateExecutor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n=== PARKING LOT STATUS AFTER ENTRIES ===");
        parkingLot.displayStatus();
    }
}
