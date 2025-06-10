package codegym.mod2.project.actions;

import codegym.mod2.project.Action;
import codegym.mod2.project.simulation.Simulator;

public class StopSimulationAction implements Action {
    @Override
    public void execute() {
        System.out.println();
        System.out.println("=========================");
        System.out.println("Deteniendo simulación ...");
        Simulator.getInstance().stop();
    }
}
