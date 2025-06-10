package codegym.mod2.project.actions;

import codegym.mod2.project.Action;

public class ShowIslandStatusAction implements Action {

    @Override
    public void execute() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("Estado general de la isla");
    }
}
