package com.idp.conhecaeaj.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.idp.conhecaeaj.R;
import com.idp.conhecaeaj.Setor;
import com.idp.conhecaeaj.SetorAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Setor> listaSetor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createList();

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        SetorAdapter setorAdapter = new SetorAdapter(MainActivity.this, listaSetor);
        recyclerView.setAdapter(setorAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

//        recyclerView.addOnItemTouchListener(new MeuRecyclerClick(MainActivity.this, recyclerView, new MeuRecyclerClick.ItemTouch() {
//
//
//            @Override
//            public void clickSimples(View view, int position) {
//
//
//                Toast.makeText(MainActivity.this, "CLICKOU CARD", Toast.LENGTH_LONG).show();
//
//
//            }
//        }));

    }


    public void createList(){
        listaSetor.add(new Setor("Adryel"));
        listaSetor.add(new Setor("Escola agricola de jundiai"));

    }



}
