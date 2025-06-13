package codegym.mod2.project;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        Scanner scanner = new Scanner(System.in);

        while (!Thread.currentThread().isInterrupted()) {
            Menu menu = menuManager.get();

            menu.show();

            int selection = scanner.nextInt();

            Action action = menu.getAction(selection);
            action.execute();
        }

        System.out.println("bye!!");
    }
}
