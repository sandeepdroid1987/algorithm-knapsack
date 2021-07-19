package com.sandeep.knapsackdemo.feature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sandeep.knapsackdemo.core.Item;
import com.sandeep.knapsackdemo.R;

import java.util.List;

public class ShoppingItemsAdapter extends RecyclerView.Adapter<ShoppingItemsAdapter.ViewHolder> {

    private List<Item> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    ShoppingItemsAdapter(Context context, List<Item> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = mData.get(position);
        holder.bind(item);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageview;
        TextView makeName;
        TextView makeValue;
        TextView makeWeight;

        ViewHolder(View itemView) {
            super(itemView);
            imageview =  itemView.findViewById(R.id.item_icon);
            //name
            makeName =  itemView.findViewById(R.id.item_txtName);
            //value
            makeValue =  itemView.findViewById(R.id.item_txtValue);
            //weight
            makeWeight =  itemView.findViewById(R.id.item_txtWeight);

            itemView.setOnClickListener(this);
        }

        public void bind(Item i) {
            imageview.setImageResource(i.getIcon());
            makeName.setText(i.getName());
            makeValue.setText("Value : " + i.getValue() + " Rupees");
            makeWeight.setText("Weight : " + i.getWeight() + " Kg");
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Item getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}