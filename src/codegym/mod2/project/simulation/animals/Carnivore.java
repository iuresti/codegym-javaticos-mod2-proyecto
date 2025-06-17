package codegym.mod2.project.simulation.animals;

import codegym.mod2.project.simulation.Animal;

public interface Carnivore {
    boolean wantsToEat(Animal prey);

    void eat(Animal prey);

    boolean isSatisfied();
}
