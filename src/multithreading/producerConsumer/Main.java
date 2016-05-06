package multithreading.producerConsumer;

/**
 * Created by User on 06.05.2016.
 */
public class Main {

    public static void main(String[] args) {

        Bucket bucket = new Bucket();
        Thread consumerThread = new Thread(new Consumer(bucket));
        Thread producerThread = new Thread(new Producer(bucket));

        consumerThread.start();
        producerThread.start();

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException ignored) {
        }

        consumerThread.interrupt();
        producerThread.interrupt();

        try {
            consumerThread.join();
            producerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads closed");
        System.out.println(bucket);
    }

}
