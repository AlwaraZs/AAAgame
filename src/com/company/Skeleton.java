package com.company;

import java.util.Random;

public class Skeleton extends Characters{
    Skeleton(String name) {
        super(name, "Skeleton", 1);//new Random().nextInt(100)
        this.addExperience(this.getLevel() * 100);
        this.addGold(new Random().nextInt(1000));
    }
}
