package com.sandeep.knapsackdemo;

import com.sandeep.knapsackdemo.core.Item;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static List<Item> getItemList()  {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Gold", 5, 650000, R.drawable.gold));
        items.add(new Item("Beer", 1, 60, R.drawable.beer));
        items.add(new Item("Laptop", 5, 45000, R.drawable.lappy));
        items.add(new Item("Briefcase with 10000 cash", 4, 10000, R.drawable.brief));
        items.add(new Item("Sofa", 40, 6000, R.drawable.sofa));
        items.add(new Item("Fridge", 50, 15000, R.drawable.fridge));
        items.add(new Item("Watch", 1, 1000, R.drawable.watch));
        items.add(new Item("Os Book", 1, 400, R.drawable.osbook));
        items.add(new Item("Necklace", 2, 1000000, R.drawable.necklace));
        items.add(new Item("Bose headset", 1, 6000, R.drawable.bose));
        items.add(new Item("Diamonds", 1, 10000000, R.drawable.diam));
        items.add(new Item("Home Theatre", 15, 15000, R.drawable.home));
        items.add(new Item("Router", 6, 1000, R.drawable.internet));
        items.add(new Item("Cool Drink", 1, 20, R.drawable.soft));
        items.add(new Item("Money 200 cash", 2, 200, R.drawable.monet));
        items.add(new Item("Car keys", 1, 900000, R.drawable.careys));
        return items;
    }
}
