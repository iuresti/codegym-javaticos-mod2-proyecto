package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;

@SimulationParameters(
        weight = 8,
        maxPerLocation = 30,
        speed = 2,
        maxNeededFoodKg = 2
)
public class Fox extends Carnivore {
}
