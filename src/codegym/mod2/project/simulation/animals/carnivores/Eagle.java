package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;
import codegym.mod2.project.simulation.animals.hervibores.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@SimulationParameters(
        weight = 6,
        maxPerLocation = 20,
        speed = 3,
        maxNeededFoodKg = 1,
        icon = "\uD83E\uDD85" //🦅
)
public class Eagle extends Animal implements Carnivore {

    private static final Map<Class<? extends Animal>, Integer> probabilityToEat;

    static {
        probabilityToEat = new HashMap<>();

        probabilityToEat.put(Fox.class, 10);
        probabilityToEat.put(Rabbit.class, 90);
        probabilityToEat.put(Mouse.class, 90);
        probabilityToEat.put(Duck.class, 80);
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
