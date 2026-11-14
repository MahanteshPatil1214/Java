package theorytopics;

public class WaterJug {

    private int waterQuantity=500;
    private WaterJug(){}
    private static WaterJug obj = null;

    public int getWaterQuantity(int quantity){
        waterQuantity -= quantity;
        return waterQuantity;
    }

    public static WaterJug getInstance(){
        if(obj == null){
            obj = new WaterJug();
        }
        return obj;
    }
}
