package com.example;

import java.util.ArrayList;

/**
 * Created by margaret on 9/12/16.
 */
public class Farm {
    public static void main(String  [] args) {
        ArrayList a = new ArrayList();
    }

    public Animal getHeaviestAnimals(ArrayList arr){
        for (int i = 0; i < arr.size(); i++) {
            Animal an = arr.get(i);
            double wt = an.getWeight();
            //need to use comparator??? idk.
        }
    }
}
