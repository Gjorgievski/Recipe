package com.example.ace.recipe.shoppingCart.shoppingCart.fragment;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;

import com.example.ace.recipe.R;
import com.example.ace.recipe.shoppingCart.shoppingCart.adapter.ShoppingCartAdapter;
import com.example.ace.recipe.shoppingCart.shoppingCart.contentProvider.ShoppingCartContentProvider;
import com.example.ace.recipe.shoppingCart.shoppingCart.model.ShoppingCartItem;
import com.software.shell.fab.ActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jovan on 3/14/2015.
 */
public class ShoppingCartFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    //private ActionButton actionButton;
    private RecyclerView scRecyclerView;
    ShoppingCartAdapter scAdapter;
    CheckBox cbDone;

    public ShoppingCartFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // initActionButton();
    }

    /*
    private void initActionButton(){
        actionButton = (ActionButton) getActivity().findViewById(R.id.fab);
    }

    public void onActionButtonClick(View v){
    }
    */

    @Override
    public void onStart() {
        super.onStart();
        getLoaderManager().initLoader(0, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.shopping_cart_fragment, container, false);

        scRecyclerView = (RecyclerView) rootView.findViewById(R.id.shopping_cart_list);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        scRecyclerView.setLayoutManager(llm);

        scAdapter = new ShoppingCartAdapter(getActivity().getApplicationContext());
        //scAdapter.setItems(getItems());

        scRecyclerView.setAdapter(scAdapter);

        List<ShoppingCartItem> items = scAdapter.getItems();
        for(int i = 0; i < items.size(); i++) {
            ShoppingCartItem item = items.get(i);

        }

        return rootView;

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {ShoppingCartContentProvider.DBOpenHelper.COLUMN_ID,
                ShoppingCartContentProvider.DBOpenHelper.COLUMN_NAME, ShoppingCartContentProvider.DBOpenHelper.COLUMN_QUANTITY,
                ShoppingCartContentProvider.DBOpenHelper.COLUMN_DONE};

        CursorLoader cursorLoader = new CursorLoader(getActivity().getApplicationContext(), ShoppingCartContentProvider.CONTENT_URI, projection, null, null, null);

        return cursorLoader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        System.out.println("DATA COUNT LOADED: " +data.getCount());
        if(data.getCount() > 0){
            List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
            while (data.moveToNext()){
                ShoppingCartItem item = new ShoppingCartItem(data.getLong(0), data.getString(1), data.getString(2), false);
                items.add(item);
            }
            Collections.reverse(items);
            scAdapter.addItems(items);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        scAdapter.addItems(new ArrayList<ShoppingCartItem>());
    }
}
