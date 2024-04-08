package lesson5Java3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Road extends Stage {
    Lock lock = new ReentrantLock();
        public Road(int length) {
            this.length = length;
            this.description = "Дорога " + length + " метров";
        }
        @Override
        public void go(Car c) {
                       try {
                  System.out.println(c.getName() + " начал этап: " + description);
                  Thread.sleep(length / c.getSpeed() * 1000);
                  System.out.println(c.getName() + " закончил этап: " + description);
                  if (length == MainClass.finishLine) {
                      System.out.printf("%s прибыл к финишу и занял %s место \n", c.getName(), ++MainClass.counter);
                       if (MainClass.counter == 1) {
                           MainClass.winCar = c.getName();
                       }
                  }
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
    }
