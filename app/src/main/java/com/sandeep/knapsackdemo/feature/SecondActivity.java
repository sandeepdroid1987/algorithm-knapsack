package com.sandeep.knapsackdemo.feature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sandeep.knapsackdemo.core.Item;
import com.sandeep.knapsackdemo.R;

import java.util.ArrayList;

public class SecondActivity extends Activity implements ShoppingItemsAdapter.ItemClickListener {

    private ArrayList<Item> optList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        optList = getIntent().getExtras().getParcelableArrayList("optimalList");
        if (optList.size() > 0) {
            populateListView();
        } else {
            TextView l =  findViewById(R.id.act2_finalText);
            l.setText(R.string.error);
        }
    }

    private void populateListView() {
        RecyclerView recyclerView =  findViewById(R.id.act2_finalListview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ShoppingItemsAdapter adapter = new ShoppingItemsAdapter(this, optList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        //do-nothing
    }

/*
    private class MyListAdapter extends ArrayAdapter<Item> {
        public MyListAdapter() {
            super(SecondActivity.this, R.layout.item_view, optList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // make sure you have a view to work with (may be given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);

            }
            // Find the item to work with;
            Item i = optList.get(position);
             =  itemView.findViewById(R.id.item_icon);
            imageview.setImageResource(i.getIcon());
            //name
            TextView makeName =  itemView.findViewById(R.id.item_txtName);
            makeName.setText(i.getName());
            //value
            TextView makeValue =  itemView.findViewById(R.id.item_txtValue);
            makeValue.setText("Value : " + i.getValue() + " Rupees");
            //weight
            TextView makeWeight =  itemView.findViewById(R.id.item_txtWeight);
            makeWeight.setText("Weight : " + i.getWeight() + " Kg");
            return itemView;
        }

    }*/
}
