package world;

import characters.Character;

import java.util.List;

public class World {
    int height = 5;
    int width = 10;

    public void printMap(List<Character> characters,
                         List<Item> items) {
        char symbol;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height -1) {
                    //System.out.print("-");
                    symbol = '-';
                } else if (x == 0 || x == width -1) {
                    //System.out.print("|");
                    symbol = '|';
                } else {
                    //System.out.print(" ");
                    symbol = ' ';
                }
                //if (playerXCoordinate == x && playerYCoordinate == y){
                    //System.out.println(playerSymbol);
                    //symbol = playerSymbol;
                //}
                //if (enemyXCoordinate == x && enemyYCoordinate == y){
                    //System.out.println(playerSymbol);
                    //symbol = enemySymbol;
                //}
                for (Item i: items) {
                    if (i.xCoordinate == x && i.yCoordinate == y){
                        symbol = i.symbol;
                        break;
                    }
                }
                for (Character c: characters) {
                    if (c.xCoordinate == x && c.yCoordinate == y){
                        symbol = c.symbol;
                        break;
                    }
                }
                //for (int i = 0; i < characters.size(); i++) {
                    //characters.get(i);
                //}
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
