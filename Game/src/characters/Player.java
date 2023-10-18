package characters;

import characters.Character;
import items.Item;
import world.World;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {


    List<world.Item> items; // {xCoord: 2, yCoord: 1, symbol: 'x', lives: 0, items: [{name: "",.. }, {}]}

    public Player(World world){
        super('x', world);
        this.lives = 3;
        this.items = new ArrayList<>();
    }

    public void addItem(items.Item item){
        if (items.contains(item)){
            item.durability++;
        } else {
            items.add(item);
        }
    }
    public void move(String input, World world){
        switch(input) {
            case "w" -> {
                if(yCoordinate == 1){
                    yCoordinate= 1;
                }
                else {
                    yCoordinate--;
                }
            }

            case "s" -> {
                if(yCoordinate == world.height-2){
                    yCoordinate= world.height-2;
                }
                else {
                    yCoordinate++;
                };
            }
            case "a" -> {
                if(xCoordinate == 1 ){
                    xCoordinate = 1;
                }
                else {
                    xCoordinate--;
                }
            }
            case "d" -> {
                if(xCoordinate == world.width-2){
                    xCoordinate = world.width-2;
                }
                else {
                    xCoordinate++;
                }
            }
        }
    }
}
