package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;

@SimulationParameters(
        weight = 500,
        maxPerLocation = 5,
        speed = 2,
        maxNeededFoodKg = 80
)
public class Bear extends Carnivore {
}
