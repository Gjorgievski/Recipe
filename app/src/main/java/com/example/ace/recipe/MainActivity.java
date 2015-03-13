package com.example.ace.recipe;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.ace.recipe.fragments.HomeFragment;

public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar; // Declaring the Toolbar Object
    private RecyclerView recView;
    private RecyclerView.Adapter recAdapter;
    private RecyclerView.LayoutManager recLayout;
    private DrawerLayout drawerLayout;
        private ActionBarDrawerToggle toggle;

        private String[] categories;
        private int[] icons={R.drawable.ic_home,R.drawable.ic_action,R.drawable.ic_favorite,R.drawable.ic_dinner,R.drawable.ic_dessert,R.drawable.ic_entertaining,R.drawable.ic_healthy,R.drawable.ic_shopping};


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);//setting the new action bar that will be used throughout the app

        categories=getResources().getStringArray(R.array.drawer_content);


        recView=(RecyclerView)findViewById(R.id.RecyclerView);
        recView.setHasFixedSize(true);//in order to prevent changing size of the view depending on the adapter content
        recAdapter=new MyAdapter(categories,icons);

        recView.setAdapter(recAdapter);

        //DRAWER CATEGORY SELECTION HANDLING
        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });

        recView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());

                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                    drawerLayout.closeDrawers();
                    switch (recyclerView.getChildPosition(child)){
                        case 1: {
                            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Home</font>"));
                            loadHome();
                            break;
                        }
                        case 2:break;
                        case 3:break;
                        case 4: {
                            CategoryFragment fragment = new CategoryFragment();
                            Bundle arguments = new Bundle();
                            arguments.putString("category","dinner");
                            fragment.setArguments(arguments);
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.tblLayout, fragment).commit();
                            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Dinner</font>"));
                            break;
                        }
                        case 5:{
                            CategoryFragment fragment = new CategoryFragment();

                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.tblLayout, fragment).commit();
                            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Dessert</font>"));
                            break;
                        }
                        case 6:{
                            CategoryFragment fragment = new CategoryFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.tblLayout, fragment).commit();
                            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Entertaining</font>"));
                            break;
                        }
                        case 7:{
                            CategoryFragment fragment = new CategoryFragment();
                            FragmentManager fragmentManager = getFragmentManager();
                            fragmentManager.beginTransaction().replace(R.id.tblLayout, fragment).commit();
                            getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Healty</font>"));
                            break;
                        }
                        case 8:break;
                        default:Toast.makeText(MainActivity.this,"Oops something went wrong! Select once again.",Toast.LENGTH_SHORT).show();  break;
                    }

                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }
        });

        recLayout=new LinearLayoutManager(this);
        recView.setLayoutManager(recLayout);

        drawerLayout = (DrawerLayout)findViewById(R.id.DrawerLayout);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.action_open,R.string.action_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //BY DEFAULT WE LOAD THE HOME FRAGMENT
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Home</font>"));
        loadHome();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //getSupportActionBar().setTitle("Martin");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //MY FUNCTIONS
    public void loadHome(){
        HomeFragment fragment=new HomeFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.tblLayout, fragment);
        ft.commit();
    }
}
