package codegym.mod2.project.menus;

import codegym.mod2.project.Action;
import codegym.mod2.project.Menu;
import codegym.mod2.project.actions.*;
import codegym.mod2.project.simulation.Island;
import codegym.mod2.project.simulation.Simulator;

import java.util.HashMap;
import java.util.Map;

public class InSimulationMenu implements Menu {

    private final Map<Integer, Action> actions;
    private final StartSimulationAction startSimulationAction;
    private final StopSimulationAction stopSimulationAction;

    public InSimulationMenu() {
        actions = new HashMap<>();

        startSimulationAction = new StartSimulationAction();
        stopSimulationAction = new StopSimulationAction();

        actions.put(1, () -> {
                    if (Simulator.getInstance().isActive()) {
                        stopSimulationAction.execute();
                    } else {
                        startSimulationAction.execute();
                    }
                }
        );
        actions.put(2, new ShowIslandStatusAction());
        actions.put(3, new ShowLocationDetailAction());
        actions.put(4, () -> Island.getInstance().destroy());
    }


    @Override
    public void show() {
        Simulator simulator = Simulator.getInstance();
        if (simulator.isActive()) {
            System.out.println("1. Detener simulación");
        } else {
            System.out.println("1. Iniciar simulación");
        }
        System.out.println("2. Mostrar estado del mapa");
        System.out.println("3. Mostrar detalle de ubicación");
        System.out.println("4. Resetear");
    }

    @Override
    public Action getAction(int selection) {
        return actions.getOrDefault(selection, InvalidSelectionAction.getInstance());
    }
}
