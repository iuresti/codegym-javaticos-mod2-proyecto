package codegym.mod2.project.menus;

import codegym.mod2.project.Action;
import codegym.mod2.project.Menu;
import codegym.mod2.project.actions.InvalidSelectionAction;
import codegym.mod2.project.actions.SetMapSizeAction;

public class HomeMenu implements Menu {

    @Override
    public void show() {
        System.out.println("1. Establecer tamaño de mapa");
        System.out.println("2. Salir");
    }

    @Override
    public Action getAction(int selection) {
        if(selection == 1){
            return SetMapSizeAction.getInstance();
        } else if(selection == 2) {
            return () -> Thread.currentThread().interrupt();
        }

        return InvalidSelectionAction.getInstance();

    }
}
