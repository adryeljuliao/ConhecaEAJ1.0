package com.idp.conhecaeaj;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
        holderSetor.nomeSetor.setText(setor.getNomeSetor());
        holderSetor.horarioSetor.setText(setor.getHorarioFuncionamento());
        //holderSetor.imageSetor.setImageResource(setor.getImage());
        holderSetor.telefone.setText(setor.getTelefone());

        holderSetor.botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SetorActivity.class);
                String nome = holderSetor.nomeSetor.getText().toString();
                i.putExtra("objSetor", setor);

                Log.i("TESTANDO", nome);
                context.startActivity(i);



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

        final TextView nomeSetor;
        final ImageButton botao;
        final ImageView imageSetor;
        final TextView horarioSetor;
        final TextView telefone;
        public SetorViewHolder(View view){
            super(view);
            nomeSetor = view.findViewById(R.id.nomeSetorLayout);
            botao = view.findViewById(R.id.botVerDetalhesLayout);
            imageSetor = view.findViewById(R.id.imageLayout);
            horarioSetor = view.findViewById(R.id.horarioLayout);
            telefone = view.findViewById(R.id.telefoneLayout);
        }


    }
}
