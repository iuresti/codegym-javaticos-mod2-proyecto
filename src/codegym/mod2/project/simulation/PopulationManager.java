package codegym.mod2.project.simulation;

import codegym.mod2.project.simulation.animals.carnivores.*;
import codegym.mod2.project.simulation.animals.hervibores.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PopulationManager {

    private static final int INITIAL_POPULATION_PER_LOCATION = 20;

    @SuppressWarnings("unchecked")
    private static final Class<? extends Animal>[] supportedAnimals = new Class[]{
            Wolf.class, Bear.class, Eagle.class, Boa.class, Fox.class,
            Buffalo.class, Caterpillar.class, Deer.class, Duck.class,
            Goat.class, Horse.class, Mouse.class, Rabbit.class, Sheep.class,
            WildBoar.class
    };
    public static final int MAX_PLANTS_PER_LOCATION = 200;
    private final Random random = new Random();


    public void populate(Location location) {

        ArrayList<Class<? extends Animal>> universe = new ArrayList<>(Arrays.asList(supportedAnimals));

        while (location.currentPopulation() < INITIAL_POPULATION_PER_LOCATION && !universe.isEmpty()) {
            Class<? extends Animal> classAnimal = getRandomClassAnimal(universe);
            SimulationParameters parameters = classAnimal.getAnnotation(SimulationParameters.class);
            if (parameters == null) {
                continue;
            }

            int maxPerLocation = parameters.maxPerLocation();

            if (location.getPopulationByAnimal(classAnimal) < maxPerLocation) {
                try {
                    location.addAnimal(classAnimal.getConstructor().newInstance());
                } catch (Exception ex) {
                    System.out.println("No pude añadir al: " + classAnimal);
                }
            } else {
                universe.remove(classAnimal);
            }
        }

        int maxPlants = random.nextInt(MAX_PLANTS_PER_LOCATION);

        for (int i = 0; i < maxPlants; i++) {
            location.addPlant(new Plant());
        }
    }

    private Class<? extends Animal> getRandomClassAnimal(ArrayList<Class<? extends Animal>> universe) {
        int typeIndex = random.nextInt(universe.size());

        return universe.get(typeIndex);
    }
}
