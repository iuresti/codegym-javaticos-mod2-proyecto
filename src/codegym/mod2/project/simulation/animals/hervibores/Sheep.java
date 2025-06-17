package codegym.mod2.project.simulation.animals.hervibores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Herbivore;

@SimulationParameters(
        weight = 500,
        maxPerLocation = 5,
        speed = 2,
        maxNeededFoodKg = 80,
        icon = "\uD83D\uDC11" //🐑
)
public class Sheep  extends Animal implements Herbivore {
}
