package com.example.ace.recipe;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
        recLayout=new LinearLayoutManager(this);
        recView.setLayoutManager(recLayout);

        drawerLayout = (DrawerLayout)findViewById(R.id.DrawerLayout);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.action_open,R.string.action_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened when drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
                };
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.mipmap.ic_launcher);
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
}
