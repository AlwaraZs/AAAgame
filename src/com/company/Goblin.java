package com.company;

import java.util.Random;

public class Goblin extends Characters{
    Goblin(String name) {
        super(name, "Goblin", 1); //new Random().nextInt(100)
        this.addExperience(this.getLevel() * 100);
        this.addGold(new Random().nextInt(1000));
    }
}
