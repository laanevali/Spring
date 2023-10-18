package characters;

import interfaces.WorldObject;
import world.World;

public abstract class Character implements WorldObject {
    private int xCoordinate;
    private int yCoordinate;
    private char symbol;
    private double lives;

    public Character (char symbol, World world){
        this.xCoordinate = generateRandomCoordinate(world.width);
        this.yCoordinate = generateRandomCoordinate(world.height);
        this.symbol = symbol;
    }
    @Override
    public int generateRandomCoordinate(int dimension) {
        return (1+(int)(Math.random()*((dimension-2))));
    }
}
