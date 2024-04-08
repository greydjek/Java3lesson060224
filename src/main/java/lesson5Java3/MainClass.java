package lesson5Java3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;


public class MainClass {
        public static final int CARS_COUNT = 4;
        static CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
static Semaphore semaphore = new Semaphore(2);
static ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
static FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
    @Override
    public String call() throws Exception {

        return winCar;
    }
});
static CountDownLatch count= new CountDownLatch(CARS_COUNT);
static int finishLine=40;
static int counter=0;
static String winCar = "Ждем победителя ";
static Semaphore semaphorewin= new Semaphore(1);
public static void main(String[] args) {
    try {
        racers();

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    private static void racers() throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(finishLine));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            int j=i;
           executorService.execute(new Thread(cars[i]));
        }
executorService.shutdown();
        executorService.submit(futureTask);
        var f = "bhbhbhbhbhbhbhbhbhbhbhbhbh";
    System.out.println(f);
    }
}

