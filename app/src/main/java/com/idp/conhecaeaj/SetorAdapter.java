package com.idp.conhecaeaj;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.idp.conhecaeaj.activity.SetorActivity;

import java.util.List;

/**
 * Created by DryZão on 06/02/2018.
 */

public class SetorAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Setor> lista;


    public SetorAdapter(Context context, List<Setor> lista){
        this.context = context;
        this.lista = lista;
    }

    //metodo que infla o layout e cria o viewholder (observar o retorno do metodo - viewHolder-)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_setor, parent, false);
        SetorViewHolder setorViewHolder = new SetorViewHolder(view);

        return setorViewHolder;
    }


    //metodo que atualiza o recycler view
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        //criar um objeto do meu viewholder para preencher de acordo com o setor que foi escolhido
        final SetorViewHolder holderSetor = (SetorViewHolder) holder;
        //pega um setor escolhido
        final Setor setor = lista.get(position);

        //colocar os valores das widgets
        holderSetor.nome.setText(setor.getNomeSetor());
        holderSetor.botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SetorActivity.class);
                String nome = holderSetor.nome.getText().toString();
                i.putExtra("objSetor", setor);

                Log.i("TESTANDO", nome);
                context.startActivity(i);

                Toast.makeText(context, "clicou no botao", Toast.LENGTH_LONG).show();


            }
        });
        holderSetor.imageSetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "clicou na imagem", Toast.LENGTH_LONG).show();

            }
        });

    }

    //retorna ao numero de itens do adapter
    @Override
    public int getItemCount() {
        if(lista != null){
            return lista.size();
        }else{
            return 0;
        }

        //return lista != null ? lista.size() : 0;
    }


    public class SetorViewHolder extends RecyclerView.ViewHolder{

        final TextView nome;
        final Button botao;
        final ImageView imageSetor;
        public SetorViewHolder(View view){
            super(view);
            nome = view.findViewById(R.id.nomeSetor);
            botao = view.findViewById(R.id.botDetalhes);
            imageSetor = view.findViewById(R.id.imageSetor);
        }


    }
}
