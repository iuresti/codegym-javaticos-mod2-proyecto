package codegym.mod2.project;

import codegym.mod2.project.menus.HomeMenu;
import codegym.mod2.project.menus.InSimulationMenu;
import codegym.mod2.project.simulation.Island;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {

    private final Menu inactiveIslandMenu;
    private final Menu activeIslandMenu;

    public MenuManager() {
        inactiveIslandMenu = new HomeMenu();
        activeIslandMenu = new InSimulationMenu();
    }

    public Menu get(){
        Island island = Island.getInstance();

        if(island == null){
            return inactiveIslandMenu;
        } else {
            return activeIslandMenu;
        }
    }
}
