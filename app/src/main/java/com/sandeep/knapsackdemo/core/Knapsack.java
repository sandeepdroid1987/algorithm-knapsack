package com.sandeep.knapsackdemo.core;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    public double table[][];
    public List<Item> list;
    public int knapWeight;
    public double optimalvalue;

    public Knapsack(List<Item> items, int knapWeight) {
        table = new double[items.size() + 1][knapWeight + 1];
        list = items;
        this.knapWeight = knapWeight;
        for (int i = 0; i <= items.size(); i++) {
            for (int j = 0; j <= knapWeight; j++) {
                table[i][j] = -1;
            }
        }
    }

    public ArrayList<Item> getKnapsack() {
        optimalvalue = fillTable(list.size(), knapWeight);
        ArrayList<Item> sackList = returnItems();
        return sackList;
    }

    private double fillTable(int n, int weight) {
        double t;
        if (weight == 0) {
            table[n][weight] = 0;
            t = 0;
        } else if (n == 0) {
            table[n][weight] = 0;
            t = 0;
        } else if (table[n][weight] != -1) {
            t = table[n][weight];
        } else {
            double a = fillTable(n - 1, weight);
            double b;
            //System.out.println("the "+n);
            if (weight >= list.get(n - 1).getWeight()) {
                b = fillTable(n - 1, weight - list.get(n - 1).getWeight()) + list.get(n - 1).getValue();
                if (a >= b) {
                    table[n][weight] = a;
                    t = a;
                } else {
                    table[n][weight] = b;
                    t = b;
                }
            } else {
                table[n][weight] = a;
                t = a;
            }
        }
        return t;
    }

    private ArrayList<Item> returnItems() {
        ArrayList<Item> l = new ArrayList<Item>();
        int j = knapWeight;
        for (int i = list.size(); i > 0; i--) {
            double val = table[i][j];
            double val2;
            if (j >= list.get(i - 1).getWeight()) {
                val2 = table[i - 1][j - list.get(i - 1).getWeight()];
                if (val2 + list.get(i - 1).getValue() == val) {
                    l.add(list.get(i - 1));
                    j = j - list.get(i - 1).getWeight();
                }
            }
        }
        return l;
    }

}

/*public class Item {
    private String name;
    private double value;
    private int weight;
    private int imageID;

    public String toString() {
        return "Name : " + name + " Value is : " + value + " weight: " + weight + "\n";
    }

    public Item(String name, int weight, double value, int img) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        imageID = img;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public int getIcon() {
        return imageID;
    }
}
*/
