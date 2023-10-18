package characters;

import characters.Character;
import interfaces.Fight;
import world.World;

public class Enemy extends Character implements Fight {
    private double strength;

    public Enemy(World world) {
        super('z', world);
        this.strength = 4.4;
        this.lives = 5;
    }

    @Override
    public void hit(Character character) {
        //saadetakse playeri sisse
        character.lives = character.lives - this.strength;
    }
}
