package codegym.mod2.project.simulation;

import codegym.mod2.project.exception.IslandAlreadyActiveException;

public class Island {
    private static Island activeIsland;

    private int width;
    private int height;

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
}
