package codegym.mod2.project.simulation.animals.hervibores;

import codegym.mod2.project.simulation.Animal;
import codegym.mod2.project.simulation.SimulationParameters;
import codegym.mod2.project.simulation.animals.Herbivore;

@SimulationParameters(
        weight = 500,
        maxPerLocation = 5,
        speed = 2,
        maxNeededFoodKg = 80,
        icon = "\uD83D\uDC03" //🐃
)
public class Buffalo extends Animal implements Herbivore  {
}
