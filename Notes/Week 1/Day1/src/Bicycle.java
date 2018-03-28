public class Bicycle {

    public int speed = 0;
    public int gear = 1;
    public String color = "Red";
    public static String bikeShop = "RevaBikes";

    //constants are all caps
    public static final int MAX_SPEED = 25;


    //define methods to manipulate the fields (verb tense)

    public void changeSpeed(int speed){
        if (speed < MAX_SPEED) {
            this.speed = speed;
        }
    }

    public void applyBrakes() {
        this.speed = 0;
    }

    public void increaseGear(){
        this.gear++;
    }
    public void decreaseGear(){
        this.gear--;
    }

    public void systemReport(){
        System.out.println(this.speed);
        System.out.println(this.gear);
        System.out.println(this.color);
        System.out.println(this.bikeShop);
    }
    public static void main(String [] args){
        Bicycle bike = new Bicycle();
        bike.systemReport();
        bike.changeSpeed(30);
        bike.systemReport();
        bike.changeSpeed(10);
        bike.systemReport();
    }
}
