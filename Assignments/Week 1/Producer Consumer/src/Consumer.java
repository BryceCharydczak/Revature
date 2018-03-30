public class Consumer implements Runnable{
    Queue2 q;
    Consumer(Queue2 q){
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run()
    {
        for(int i=0; i < 5; i++)
            q.get();
    }
}
