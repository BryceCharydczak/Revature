public class OnDemandSingleton {
    private int value;

    private static class SingletonHolder{
        private static OnDemandSingleton mySingleton = new OnDemandSingleton();
    }

    private OnDemandSingleton(){
    }
    public static OnDemandSingleton getInstance(){
        return OnDemandSingleton.SingletonHolder.mySingleton;
    }
}
