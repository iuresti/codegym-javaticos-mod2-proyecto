package codegym.mod2.project.actions;

import codegym.mod2.project.Action;
import codegym.mod2.project.Menu;
import codegym.mod2.project.simulation.Island;

import java.util.Scanner;

public class SetMapSizeAction implements Action {

    private SetMapSizeAction(){

    }

    private static class UniqueInstanceHolder {
        static SetMapSizeAction uniqueInstance = new SetMapSizeAction();
    }

    public static SetMapSizeAction getInstance(){
        return UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ubicaciones a lo largo: ");
        int sizeWidth = scanner.nextInt();
        System.out.print("Ubicaciones a lo ancho: ");
        int sizeHeight = scanner.nextInt();

        Island.initialize(sizeWidth, sizeHeight);

    }
}
