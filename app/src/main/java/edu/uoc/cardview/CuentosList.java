package edu.uoc.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import java.util.List;
import java.util.stream.Collectors;

import static edu.uoc.cardview.R.drawable.background;

public class CuentosList extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button buttonBack;
    private MainActivity mainActivity;
    public static boolean views;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos_list);
        //getSupportActionBar().hide();
        getSupportActionBar().setTitle(mainActivity.tipoCuento);

        this.recyclerView = findViewById(R.id.recycler_view);
        this.searchView = findViewById(R.id.searchView);
        this.layoutManager = new LinearLayoutManager(getBaseContext());


        adapter = new MainAdapter(this,MainActivity.cuentosRVArrayList,getApplicationContext());

        searchView.setOnQueryTextListener(this);
        loadpreferences();

        if (views == true) {
            recyclerView.setLayoutManager(layoutManager);
        }else{
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                    StaggeredGridLayoutManager.VERTICAL));
        }

        recyclerView.setAdapter(adapter);
    }

    public void loadpreferences() {

        PreferenceManager.setDefaultValues(this,R.xml.preferences, false);
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this /* Activity context */);

        views = sharedPreferences.getBoolean("Vista", false);

    }
    //Search view llamo a los metodos que implementa el search view y en el adaptador el metodo filter filtra para ver lo que queramos.
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        System.out.println("Funciona searchview"+newText);
        return false;
    }
}

