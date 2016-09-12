package com.example;

import java.util.Random;
/**
 * Created by margaret on 9/12/16.
 */
public class Cow extends Animal {
    Random r = new Random();

    private String name;
    private String species;
    private String color;
    private double weight;
    private int legs;

    public Cow(String name, String color) {
        this.setName(name);
        this.setColor(color);
        this.setLegs(4);
        this.setSpecies("cat");
        this.setWeight(r.nextDouble(100) + 100);
    }
    public void grow() {
        this.weight *= 5;
    }

}
