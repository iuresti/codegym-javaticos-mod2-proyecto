package codegym.mod2.project.simulation;

import java.util.concurrent.TimeUnit;

public class IslandGlobalStatusThread implements Runnable {

    @Override
    public void run() {
        Island island = Island.getInstance();

        while(!Thread.currentThread().isInterrupted()){
            island.print();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
