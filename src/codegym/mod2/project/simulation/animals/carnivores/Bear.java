package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;
import codegym.mod2.project.simulation.animals.hervibores.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@SimulationParameters(
        weight = 500,
        maxPerLocation = 5,
        speed = 2,
        maxNeededFoodKg = 80,
        icon = "\uD83D\uDC3B" //🐻
)
public class Bear extends Animal implements Carnivore {

    private static final Map<Class<? extends Animal>, Integer> probabilityToEat;

    static {
        probabilityToEat = new HashMap<>();

        probabilityToEat.put(Boa.class, 80);
        probabilityToEat.put(Horse.class, 40);
        probabilityToEat.put(Deer.class, 80);
        probabilityToEat.put(Rabbit.class, 80);
        probabilityToEat.put(Mouse.class, 90);
        probabilityToEat.put(Goat.class, 70);
        probabilityToEat.put(Sheep.class, 70);
        probabilityToEat.put(WildBoar.class, 50);
        probabilityToEat.put(Buffalo.class, 20);
        probabilityToEat.put(Duck.class, 10);
    }


    @Override
    public boolean wantsToEat(Animal prey) {

        if (probabilityToEat.containsKey(prey.getClass())) {
            return ThreadLocalRandom.current().nextInt(100) < probabilityToEat.get(prey.getClass());
        }

        return false;
    }

    @Override
    public void eat(Animal prey) {

    }

    @Override
    public boolean isSatisfied() {
        return false;
    }
}
