package com.example.ace.recipe.shoppingCart.shoppingCart.adapter;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ace.recipe.R;
import com.example.ace.recipe.shoppingCart.shoppingCart.fragment.ShoppingCartFragment;
import com.example.ace.recipe.shoppingCart.shoppingCart.model.ShoppingCartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jovan on 3/14/2015.
 */
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ShoppingCartViewHolder>{

    private LayoutInflater mInflater;
    private List<ShoppingCartItem> items;
    private ViewGroup viewGroup;
    public Context ctx;

    public ShoppingCartAdapter(Context ctx){
        mInflater = LayoutInflater.from(ctx);
        items = new ArrayList<ShoppingCartItem>();
        this.ctx = ctx;
    }

    @Override
    public ShoppingCartViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.shopping_cart_item, viewGroup, false);

        this.viewGroup = viewGroup;

        return new ShoppingCartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ShoppingCartViewHolder shoppingCartViewHolder, int i) {
        final ShoppingCartItem item = items.get(i);

        shoppingCartViewHolder.cbDone.setChecked(item.isDone());
        shoppingCartViewHolder.tvName.setText(item.getName());
        shoppingCartViewHolder.tvQuantity.setText(item.getQuantity());

        final int position = i;

        shoppingCartViewHolder.cbDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                items.get(position).setDone(cb.isChecked());
                if(items.get(position).isDone() == true) {
                    shoppingCartViewHolder.tvName.setPaintFlags(shoppingCartViewHolder.tvName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    shoppingCartViewHolder.tvQuantity.setPaintFlags(shoppingCartViewHolder.tvQuantity.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    shoppingCartViewHolder.btnDelete.setVisibility(View.VISIBLE);
                }
                else {
                    shoppingCartViewHolder.tvName.setPaintFlags(0);
                    shoppingCartViewHolder.tvQuantity.setPaintFlags(0);
                    shoppingCartViewHolder.btnDelete.setVisibility(View.INVISIBLE);
                }
            }
        });

        shoppingCartViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
    }

    public List<ShoppingCartItem> getItems(){
        return items;
    }


    public void addItems(List<ShoppingCartItem> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItem(ShoppingCartItem item){
        this.items.add(item);
        notifyDataSetChanged();
    }

    public void clear(){
        this.items.clear();
        notifyDataSetChanged();
    }

    public static class ShoppingCartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        protected CheckBox cbDone;
        protected TextView tvName;
        protected TextView tvQuantity;
        protected ImageView btnDelete;

        public ShoppingCartViewHolder(View view){
            super(view);
            view.setOnClickListener(this);
            cbDone = (CheckBox) view.findViewById(R.id.cb_sc_item);
            tvName = (TextView) view.findViewById(R.id.tv_sc_item_name);
            tvQuantity = (TextView) view.findViewById(R.id.tv_sc_item_quantity);
            btnDelete = (ImageView) view.findViewById(R.id.btn_delete_sc_item);
            //int id = Resources.getSystem().getIdentifier("btn_check_holo_dark", "drawable", "android");
            //cbDone.setButtonDrawable(id);
        }

        //Za klik na item
        public void onClick(View view){
            Bundle bundle = new Bundle();
            bundle.putLong("id", getItemId());
            ShoppingCartFragment scFragment = new ShoppingCartFragment();
            FragmentManager fm = ((Activity) view.getContext().getApplicationContext()).getFragmentManager();
            //FragmentManager fm =
            scFragment.setArguments(bundle);
            fm.beginTransaction()
                    .replace(R.id.tblLayout, scFragment)
                    .commit();
        }
    }
}
