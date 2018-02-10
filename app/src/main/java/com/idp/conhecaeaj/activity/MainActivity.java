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
    private boolean flagList = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!flagList){
            listaSetor = createList();
        }

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


    public List createList(){
        List<Setor> listaSetor = new ArrayList<>();

        listaSetor.add(new Setor("Diretoria", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.diretoria, R.string.setor_descricao_diretoria,"(84)4002-8922", -5.886449, -35.362213));

        listaSetor.add(new Setor("Informática", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.informatica, R.string.descricao_informatica,"(84)4002-8922", -5.885786, -35.365748));

        listaSetor.add(new Setor("Apicultura", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.apicultura, R.string.setor_descricao_apicultura,"(84)4002-8922", 5.885880, -35.362644));

        listaSetor.add(new Setor("Centro Vocacional Tecnológico - CVT", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.cvt, R.string.setor_descricao_cvt,"(84)4002-8922", -5.884567, -35.364924));

        listaSetor.add(new Setor("Lanchonete", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.lanchonet, R.string.setor_descricao_lanchonete,"(84)4002-8922", -5.884967, -35.363785));

        listaSetor.add(new Setor("Avicultura", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.avicultura, R.string.setor_descricao_avicultura,"(84)4002-8922", -5.886712, -35.363297));

        listaSetor.add(new Setor("Prédio e-Tec", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.predio_etec, R.string.setor_descricao_predio_etec,"(84)4002-8922", -5.885260, -35.366496));

        listaSetor.add(new Setor("Restaurante universitário - RU", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.restaurante, R.string.setor_descricao_ru,"(84)4002-8922", -5.885471, -35.362908));

        flagList = true;
        return listaSetor;
    }



}
