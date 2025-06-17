package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;

@SimulationParameters(
        weight = 500,
        maxPerLocation = 5,
        speed = 2,
        maxNeededFoodKg = 80,
        icon = "\uD83D\uDC3B"
)
public class Bear extends Carnivore {
}
