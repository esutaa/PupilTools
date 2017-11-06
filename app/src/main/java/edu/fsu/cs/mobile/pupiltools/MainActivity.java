package edu.fsu.cs.mobile.pupiltools;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // Declaring values
    private DrawerLayout dLayout;
    private ActionBarDrawerToggle dToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing values
        dLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        dToggle = new ActionBarDrawerToggle(this, dLayout, R.string.menuOpen, R.string.menuClose);

        dLayout.addDrawerListener(dToggle); //Listening for toggle
        dToggle.syncState();    // Synchronize state with DrawerLayout

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (dToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
