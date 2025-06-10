package codegym.mod2.project.actions;

import codegym.mod2.project.Action;
import codegym.mod2.project.simulation.Simulator;

public class StartSimulationAction implements Action {

    @Override
    public void execute() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("Iniciando simulación ...");
        Simulator.getInstance().start();
    }
}
