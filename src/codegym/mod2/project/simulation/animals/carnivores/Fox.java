package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;
import codegym.mod2.project.simulation.animals.hervibores.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@SimulationParameters(
        weight = 8,
        maxPerLocation = 30,
        speed = 2,
        maxNeededFoodKg = 2,
        icon = "\uD83E\uDD8A" //🦊
)
public class Fox extends Animal implements Carnivore {

    private static final Map<Class<? extends Animal>, Integer> probabilityToEat;

    static {
        probabilityToEat = new HashMap<>();

        probabilityToEat.put(Rabbit.class, 70);
        probabilityToEat.put(Mouse.class, 90);
        probabilityToEat.put(Duck.class, 60);
        probabilityToEat.put(Caterpillar.class, 40);
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
