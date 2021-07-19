package com.sandeep.knapsackdemo.feature;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sandeep.knapsackdemo.TestData;
import com.sandeep.knapsackdemo.core.Item;
import com.sandeep.knapsackdemo.core.Knapsack;
import com.sandeep.knapsackdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ShoppingItemsAdapter.ItemClickListener {

    private List<Item> items = new ArrayList();
    private List<Item> wishList = new ArrayList();
    private Knapsack ks;
    private int knapWeight;
    private ArrayList<Item> optimalList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtonListener();
        populateItems();
        populateListView();
    }

    private void populateItems() {
        items = TestData.getItemList();
    }

    private void populateListView() {

        RecyclerView recyclerView =  findViewById(R.id.myListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ShoppingItemsAdapter adapter = new ShoppingItemsAdapter(this, items);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void setButtonListener() {
        Button b = findViewById(R.id.button);
        b.setOnClickListener(arg0 -> {
            TextView t = findViewById(R.id.weightBox);
            knapWeight = Integer.parseInt((t.getText()).toString());
            ks = new Knapsack(wishList, knapWeight);
            optimalList = ks.getKnapsack();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putParcelableArrayListExtra("optimalList" , optimalList);

            startActivity(intent);
        });

    }

    @Override
    public void onItemClick(View view, int pos) {
        Item i = items.get(pos);
        String msg = String.format(getString(R.string.wishlist_add_success), i.getName());
        if (!wishList.contains(i)) {
            wishList.add(i);
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        } else {
            msg = String.format(getString(R.string.wishlist_add_error), i.getName());
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        }

    }
}
