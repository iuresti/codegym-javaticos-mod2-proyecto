package codegym.mod2.project.actions;

import codegym.mod2.project.Action;
import codegym.mod2.project.simulation.IslandGlobalStatusThread;

import java.util.Scanner;

public class ShowIslandStatusAction implements Action {

    @Override
    public void execute() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("Estado general de la isla");

        Scanner scanner = new Scanner(System.in);

        Thread thread = new Thread(new IslandGlobalStatusThread());
        thread.start();

        while(!Thread.currentThread().isInterrupted()){
            String input = scanner.nextLine();
            if(input.compareToIgnoreCase("q") == 0){
                break;
            }
        }

        thread.interrupt();

        System.out.println("Cerrando estado general...");
        System.out.println("=========================");
    }
}
