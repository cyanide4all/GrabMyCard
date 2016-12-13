package cyanoboru.grabmycard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

import cyanoboru.grabmycard.cards.cardAdaptor;
import cyanoboru.grabmycard.cards.cardAnimation;
import cyanoboru.grabmycard.grid.gridAdaptor;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    protected List<String> data;
    protected cardAdaptor adaptor;
    protected VerticalViewPager pager;
    protected GridView grid;
    protected boolean onGrid = false;

    public static final int QR_REQUEST = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maincards);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Main.this, CameraCapturer.class),QR_REQUEST);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // custom logic here
        data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");

        pager = (VerticalViewPager) findViewById(R.id.mainpager);
        pager.setAdapter(new cardAdaptor(getSupportFragmentManager(),data));
        pager.setPageTransformer(true,new cardAnimation());

        // grid logic

        ((ImageView) findViewById(R.id.maingrid)).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        // extension point

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.maingrid){
            if(!onGrid){
                pager.setVisibility(View.GONE);
                ViewStub q = ((ViewStub) findViewById(R.id.StubGrid));
                if(q != null){
                    View q1 = q.inflate();
                    grid = ((GridView) q1.findViewById(R.id.grid));
                    grid.setAdapter(new gridAdaptor(this,data));
                }else{
                    grid.setVisibility(View.VISIBLE);
                }
            }else{
                grid.setVisibility(View.GONE);
                pager.setVisibility(View.VISIBLE);
            }
            onGrid = !onGrid;
        }
    }
}
