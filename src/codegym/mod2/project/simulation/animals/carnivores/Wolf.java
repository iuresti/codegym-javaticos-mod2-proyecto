package codegym.mod2.project.simulation.animals.carnivores;

import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Carnivore;

@SimulationParameters(
        weight = 50,
        maxPerLocation = 30,
        speed = 3,
        maxNeededFoodKg = 8,
        icon = "\uD83D\uDC3A"
)
public class Wolf extends Carnivore {

}
