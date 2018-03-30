public class Producer implements Runnable {
    Queue2 q;
    Producer(Queue2 q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for(int i=0; i < 5; i++)
            q.put(i);
    }
}
