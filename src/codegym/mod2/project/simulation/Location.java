package codegym.mod2.project.simulation;

import codegym.mod2.project.simulation.animals.Carnivore;
import codegym.mod2.project.simulation.animals.Herbivore;

import java.util.*;

public class Location {
    private final List<Plant> plants;
    private final List<Carnivore> carnivores;
    private final List<Herbivore> hervibores;
    private final Map<Class<? extends Animal>, Integer> countByAnimal;

    public Location() {
        plants = new ArrayList<>();
        carnivores = new ArrayList<>();
        hervibores = new ArrayList<>();
        countByAnimal = new HashMap<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void addAnimal(Animal animal) {
        if (animal instanceof Carnivore carnivore)
            carnivores.add(carnivore);
        if (animal instanceof Herbivore herbivore)
            hervibores.add(herbivore);

        if (countByAnimal.containsKey(animal.getClass())) {
            countByAnimal.put(animal.getClass(), countByAnimal.get(animal.getClass()) + 1);
        } else {
            countByAnimal.put(animal.getClass(), 1);
        }
    }

    public int currentPopulation() {
        Set<Map.Entry<Class<? extends Animal>, Integer>> entries = countByAnimal.entrySet();
        int count = 0;

        for (Map.Entry<Class<? extends Animal>, Integer> entry : entries) {
            count += entry.getValue();
        }

        return count;
    }

    public int getPopulationByAnimal(Class<? extends Animal> classAnimal) {
        return countByAnimal.getOrDefault(classAnimal, 0);
    }

    public void printSummary() {
        System.out.print("\uD83E\uDD69: " + currentPopulation() + ", \uD83C\uDF33: " + plants.size());
    }

    public void printDetail() {
        System.out.println("\uD83C\uDF33: " + plants.size());
        countByAnimal.forEach((key, value) -> {
            SimulationParameters params = key.getAnnotation(SimulationParameters.class);
            if (params == null) {
                System.out.println("\uD83E\uDD69?: " + value);
            } else {
                System.out.println(params.icon() + ": " + value);
            }

        });
    }

    public List<Carnivore> getUnsortedCarnivores() {
        List<Carnivore> unsortedCarnivores = new ArrayList<>(carnivores);

        Collections.shuffle(unsortedCarnivores);

        return unsortedCarnivores;
    }

    public List<Animal> getAllAnimals() {
        return null;
    }

    public void remove(Animal animal) {
        if (animal instanceof Carnivore)
            carnivores.remove(animal);
        if (animal instanceof Herbivore)
            hervibores.remove(animal);
    }


}
