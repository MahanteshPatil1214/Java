package theorytopics;

public class HumanBeing{
    public int walk(int distance ,int time){
        int speed = distance/time;
        return speed;
    }
}

class Athlete extends HumanBeing{
    @Override
    public int walk(int distance, int time) {
        int speed = distance/time;
        speed = speed*2;
        return speed;
    }
}
