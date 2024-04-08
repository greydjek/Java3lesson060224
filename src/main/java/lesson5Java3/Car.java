package lesson5Java3;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
        private static int CARS_COUNT;
        private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(MainClass.CARS_COUNT);
        private Race race;
        private int speed;
        private String name;
        private boolean win= false;
        public String getName() {
            return name;
        }
        public int getSpeed() {
            return speed;
        }
        public void setwin(){ win = true;}
        public Car(Race race, int speed) {
            this.race = race;
            this.speed = speed;
            CARS_COUNT++;
            this.name = "Участник #" + CARS_COUNT;
//            this.win;
        }
        @Override
        public void run() {
            try {
                System.out.println(this.name + " готовится");
                cyclicBarrier.await();
                Thread.sleep(500 + (int)(Math.random() * 800));
                System.out.println(this.name + " готов");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
             System.out.println("Важное обьявление -->>> Гонка началась ");

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
        }
    }
