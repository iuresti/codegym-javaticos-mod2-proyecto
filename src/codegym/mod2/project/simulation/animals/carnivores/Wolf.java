package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;
import codegym.mod2.project.simulation.animals.hervibores.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@SimulationParameters(
        weight = 50,
        maxPerLocation = 30,
        speed = 3,
        maxNeededFoodKg = 8,
        icon = "\uD83D\uDC3A" //🐺
)
public class Wolf extends Animal implements Carnivore {
    private static final Map<Class<? extends Animal>, Integer> probabilityToEat;

    static {
        probabilityToEat = new HashMap<>();

        probabilityToEat.put(Horse.class, 10);
        probabilityToEat.put(Deer.class, 15);
        probabilityToEat.put(Rabbit.class, 60);
        probabilityToEat.put(Mouse.class, 80);
        probabilityToEat.put(Goat.class, 60);
        probabilityToEat.put(Sheep.class, 70);
        probabilityToEat.put(WildBoar.class, 15);
        probabilityToEat.put(Buffalo.class, 10);
        probabilityToEat.put(Duck.class, 40);
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
