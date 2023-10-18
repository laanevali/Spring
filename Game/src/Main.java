import characters.Character;
import characters.Enemy;
import characters.Player;
import items.Item;
import items.ItemType;
import world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        World world = new World();

        Player player = new Player(world);
        Enemy enemy = new Enemy(world);

        List<Character> characters = new ArrayList<>();
        characters.add(player);
        characters.add(enemy);

        Item sword = new Item(world, ItemType.SWORD);
        Item hammer = new Item(world, ItemType.HAMMER);
        Item dagger = new Item(world, ItemType.DAGGER);
        List<Item> items = new ArrayList<>();
        items.add(sword);
        items.add(hammer);
        items.add(dagger);

        //double komakohaga;
        //boolean kahendväärtus;
        //float kohakomaga2 --> lühem, mälu säästmiseks
        //long andmebaasi ID
        //byte pilte/0/1

        //boolean isAdult <--- deklareerin
        // isAdult = true <--- initsialiseerin
        // boolean isAdult = true ; deklareerin ja initsialiseerin
        //hasRights() <--- andmebaasi küsima

        Scanner scanner = new Scanner(System.in);
        // ObjectMapper objectMapper = new ObjectMapper();
        // RestTemplate restTemplate = new RestTemplate();
        // items.Item sword = new items.Item();
        // items.Item hammer = new items.Item();

        world.printMap(characters,items);

        String input = scanner.nextLine();
        //System.out.println(input);
        while (!input.equals("end")) {
            player.move(input,world);
            world.printMap(characters, items);
            for (Item i: items){
                if ( i.xCoordinate == player.xCoordinate &&
                i.yCoordinate == player.yCoordinate){
                    player.addItem(i);
                }
            }
            //sword.hit(enemy);
            //enemy.hit(player);

            input = scanner.nextLine();
        }
    }

}