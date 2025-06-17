package codegym.mod2.project.simulation;

import codegym.mod2.project.simulation.animals.Carnivore;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LocationTask implements Runnable {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;
    private final Location location;
    private final int row;
    private final int column;

    public LocationTask(Location location, int row, int column) {
        this.location = location;
        this.row = row;
        this.column = column;
    }

    public void run() {
        while (Thread.currentThread().isInterrupted()) {
            performHunt();

            moveAnimals();

            Thread.yield();
        }
    }

    private void performHunt() {
        List<Carnivore> carnivores = location.getUnsortedCarnivores();

        for (Carnivore predator : carnivores) {

            List<Animal> allAnimals = location.getAllAnimals();
            for (Animal prey : allAnimals) {
                if (predator.wantsToEat(prey)) {
                    predator.eat(prey);
                    location.remove(prey);
                }
                if(predator.isSatisfied()){
                    break;
                }
            }
        }
    }

    private void moveAnimals() {
        Island island = Island.getInstance();
        List<Animal> allAnimals = location.getAllAnimals();
        int height = island.getHeight();
        int width = island.getWidth();
        int newRow = row;
        int newColumn = column;

        for (Animal animal : allAnimals) {
            SimulationParameters parameters = animal.getClass().getAnnotation(SimulationParameters.class);
            int speed = parameters.speed();
            switch (ThreadLocalRandom.current().nextInt(4)){
                case UP:
                    newRow = Math.abs(row - speed) % height;
                    break;
                case DOWN:
                    newRow = (row + speed) % height;
                    break;
                case LEFT:
                    newColumn = Math.abs(column - speed) % width;
                    break;
                case RIGHT:
                    newColumn = (column + speed) % width;
                    break;
            }
            island.move(animal, newColumn, newRow);
        }
    }
}
