package edu.fsu.cs.mobile.pupiltools;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    // Declaring values
    private DrawerLayout dLayout;
    private ActionBarDrawerToggle dToggle;
    NavigationView nView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing values
        dLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nView = (NavigationView) findViewById(R.id.navigation);
        dToggle = new ActionBarDrawerToggle(this, dLayout, R.string.menuOpen, R.string.menuClose);

        nView.setNavigationItemSelectedListener(this);  // Listening for what is clicked in menu
        dLayout.addDrawerListener(dToggle); // Listening for toggle to open menu
        dToggle.syncState();    // Synchronize state with DrawerLayout

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }

    // If item is selected on menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (dToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (id) {
            case R.id.gradeCalc:
                Toast.makeText(this, "Grade clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gpaCalc:
                Toast.makeText(this, "GPA clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                break;
        }
         return super.onOptionsItemSelected(item);
    }

    // If item is selected on the menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.gradeCalc:
                Toast.makeText(this, "Grade clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gpaCalc:
                Toast.makeText(this, "GPA clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                break;
        }

        // Close menu when cases are complete
        dLayout.closeDrawer(GravityCompat.START);

        return false;
    }

    // Checking for back button for menu
    @Override
    public void onBackPressed() {
        if (dLayout.isDrawerOpen(GravityCompat.START))
        {
            dLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
