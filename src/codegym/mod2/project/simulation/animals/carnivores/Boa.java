package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;
import codegym.mod2.project.simulation.animals.hervibores.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@SimulationParameters(
        weight = 15,
        maxPerLocation = 30,
        speed = 1,
        maxNeededFoodKg = 3,
        icon = "\uD83D\uDC0D" //🐍
)
public class Boa extends Animal implements Carnivore {
    private static final Map<Class<? extends Animal>, Integer> probabilityToEat;

    static {
        probabilityToEat = new HashMap<>();

        probabilityToEat.put(Fox.class, 15);
        probabilityToEat.put(Rabbit.class, 20);
        probabilityToEat.put(Mouse.class, 40);
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
