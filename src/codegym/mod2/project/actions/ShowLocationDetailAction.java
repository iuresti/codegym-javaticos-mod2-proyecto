package codegym.mod2.project.actions;

import codegym.mod2.project.Action;
import codegym.mod2.project.simulation.Island;

import java.util.Scanner;

public class ShowLocationDetailAction implements Action {
    @Override
    public void execute() {
        int row, column;
        Scanner scanner = new Scanner(System.in);
        Island island = Island.getInstance();

        System.out.println("======================");
        System.out.println("Mostrar detalle");
        System.out.print("Qué fila: ");
        row = scanner.nextInt();
        System.out.print("Qué Columna: ");
        column = scanner.nextInt();

        island.print(row, column);

        System.out.println("======================");
    }
}
