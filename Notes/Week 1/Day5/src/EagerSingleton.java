public class EagerSingleton {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private static EagerSingleton mySingleton = new EagerSingleton();

    private EagerSingleton(){

    }
    public static EagerSingleton getInstance(){
        return mySingleton;
    }
}
