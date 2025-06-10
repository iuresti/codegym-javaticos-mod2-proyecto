package codegym.mod2.project.simulation;

public class Simulator {
    private boolean isActive;

    private Simulator(){

    }

    public void start() {
        isActive = true;
    }

    public void stop() {
        isActive = false;
    }

    private static class UniqueInstanceHolder {
        private static Simulator simulator = new Simulator();
    }

    public static Simulator getInstance(){
        return UniqueInstanceHolder.simulator;
    }

    public boolean isActive() {
        return isActive;
    }
}
