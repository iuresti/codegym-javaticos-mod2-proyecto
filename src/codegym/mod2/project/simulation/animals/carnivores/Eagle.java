package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;

@SimulationParameters(
        weight = 6,
        maxPerLocation = 20,
        speed = 3,
        maxNeededFoodKg = 1
)
public class Eagle extends Carnivore {
}
