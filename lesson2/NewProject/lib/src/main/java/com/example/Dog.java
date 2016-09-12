package com.example;

import java.util.Random;

/**
 * Created by margaret on 9/12/16.
 */
public class Dog extends Animal {
    Random r = new Random();

    private String name;
    private String species;
    private String color;
    private double weight;
    private int legs;

    public Dog(String name, String color) {
        this.setName(name);
        this.setColor(color);
        this.setLegs(4);
        this.setSpecies("dog");
        this.setWeight(r.nextDouble(25));
    }
    public void grow() {
        this.weight *= 1.5;
    }
}
