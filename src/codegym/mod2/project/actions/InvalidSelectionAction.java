package codegym.mod2.project.actions;

import codegym.mod2.project.Action;
import codegym.mod2.project.Menu;

public class InvalidSelectionAction implements Action {

    private InvalidSelectionAction() {

    }

    private static class UniqueInstanceHolder {
        static InvalidSelectionAction uniqueInstance = new InvalidSelectionAction();
    }

    public static InvalidSelectionAction getInstance() {
        return InvalidSelectionAction.UniqueInstanceHolder.uniqueInstance;
    }

    @Override
    public void execute() {
        System.out.println("Selección inválida");
    }
}
