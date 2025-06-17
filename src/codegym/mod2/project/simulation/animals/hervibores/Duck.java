package codegym.mod2.project.simulation.animals.hervibores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;
import codegym.mod2.project.simulation.animals.Herbivore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@SimulationParameters(
        weight = 500,
        maxPerLocation = 5,
        speed = 2,
        maxNeededFoodKg = 80,
        icon = "\uD83E\uDD86" //🦆
)
public class Duck extends Animal implements Carnivore, Herbivore {

    private static final Map<Class<? extends Animal>, Integer> probabilityToEat;

    static {
        probabilityToEat = new HashMap<>();

        probabilityToEat.put(Caterpillar.class, 90);
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
