package codegym.mod2.project.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {
    private final List<Plant> plants;
    private final List<Animal> animals;
    private final Map<Class<? extends Animal>, Integer> countByAnimal;

    public Location() {
        plants = new ArrayList<>();
        animals = new ArrayList<>();
        countByAnimal = new HashMap<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);

        if (countByAnimal.containsKey(animal.getClass())) {
            countByAnimal.put(animal.getClass(), countByAnimal.get(animal.getClass()) + 1);
        } else {
            countByAnimal.put(animal.getClass(), 1);
        }
    }

    public int currentPopulation() {
        return animals.size();
    }

    public int getPopulationByAnimal(Class<? extends Animal> classAnimal) {
        return countByAnimal.getOrDefault(classAnimal, 0);
    }
}
