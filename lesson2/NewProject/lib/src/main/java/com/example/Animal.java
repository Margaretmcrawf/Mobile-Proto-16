package com.example;

/**
 * Created by margaret on 9/11/16.
 */
public abstract class Animal {
    private int legs;
    private String name;
    private String color;
    private String species;
    private double weight;

    public Animal(int legs, String name, String color, String species, double weight) {
        this.legs = legs;
        this.name = name;
        this.color = color;
        this.species = species;
        this.weight = weight;
    }
    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public void setLegs(int legs) {
        this.legs = legs;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public int getLegs() {
        return legs;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public String getSpecies() {
        return species;
    }
    public double getWeight() {
        return weight;
    }
    public abstract void grow(){
    }

}

