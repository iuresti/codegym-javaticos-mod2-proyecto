package codegym.mod2.project.simulation;

public class Simulator {
    private boolean isActive;
    private final PopulationManager populationManager;

    private Simulator() {
        populationManager = new PopulationManager();
    }

    public void start() {
        Island island = Island.getInstance();

        island.prepareLocations();
        island.populate(populationManager);

        island.start();

        isActive = true;
    }

    public void stop() {
        isActive = false;
    }

    private static class UniqueInstanceHolder {
        private static final Simulator simulator = new Simulator();
    }

    public static Simulator getInstance() {
        return UniqueInstanceHolder.simulator;
    }

    public boolean isActive() {
        return isActive;
    }
}
