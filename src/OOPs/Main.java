package OOPs;

abstract class Vehicle{
    private String brand;
    private String model;

    private int odometer;

    Vehicle(String brand,String model){
        this.brand=brand;
        this.model=model;
        this.odometer=0;
    }

    public int getOdometer() {
        return odometer;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void drive(int miles){
        if(miles>0){
            this.odometer+=miles;
        }
    }

    public abstract String startEngine();
}

class Car extends Vehicle{

    private String fuelType;

    Car(String brand, String model,String fuelType) {
        super(brand, model);
        this.fuelType=fuelType;
    }

    @Override
    public String startEngine() {
        return getBrand() + " " + getModel() + " : Engine Started wth a roa Fuel :" + fuelType ;
    }
}

class ElectricCar extends Vehicle{
    private int batterCapacity;

    ElectricCar(String brand, String model,int batterCapacity) {
        super(brand, model);
        this.batterCapacity=batterCapacity;
    }

    @Override
    public String startEngine() {
        return getBrand() + " " + getModel() + " : Slient Ingestion wth a battery at :" + batterCapacity +"KWh" ;
    }
}

public class Main {
    public static void main(String args[]){
        Vehicle myCar = new Car("Toyota","Camry","Petrol");
        Vehicle myEv = new ElectricCar("Tesla","Model 3",75);
        System.out.println(myCar.startEngine());
        System.out.println(myEv.startEngine());

        myCar.drive(150);
        System.out.println("Mileage on my car :" + myCar.getOdometer() + " miles");
    }
}
