package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;

@SimulationParameters(
        weight = 15,
        maxPerLocation = 30,
        speed = 1,
        maxNeededFoodKg = 3
)
public class Boa extends Carnivore {
}
