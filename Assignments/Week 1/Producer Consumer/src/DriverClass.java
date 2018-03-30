public class DriverClass {
    public static void main(String args[])
    {
        Queue2 q = new Queue2();

        new Consumer(q);

        new Producer(q);
    }
}
