package codegym.mod2.project.simulation;

import codegym.mod2.project.exception.IslandAlreadyActiveException;

public class Island {
    private static Island activeIsland;

    private int width;
    private int height;

    private Location [][]locations;

    private Island(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public static Island getInstance(){
        return activeIsland;
    }

    public static synchronized void initialize(int width, int height){
        if(activeIsland != null){
            throw new IslandAlreadyActiveException();
        }

        activeIsland = new Island(width, height);
    }

    public void destroy(){
        System.out.println();
        System.out.println(" Destruyendo la isla...");
        activeIsland = null;
    }

    public void prepareLocations() {
        locations = new Location[height][width];

        for(int i = 0; i < height; i ++){
            for(int j = 0; j < width; j++){
                locations[i][j] = new Location();
            }
        }
    }

    public void populate(PopulationManager populationManager) {
        for(int i = 0; i < height; i ++){
            for(int j = 0; j < width; j++){
                populationManager.populate(locations[i][j]);
            }
        }
    }
}
