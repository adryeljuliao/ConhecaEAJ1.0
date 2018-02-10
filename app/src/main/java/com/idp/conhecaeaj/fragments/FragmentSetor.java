package com.idp.conhecaeaj.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.idp.conhecaeaj.R;
import com.idp.conhecaeaj.Setor;

/**
 * Created by DryZão on 09/02/2018.
 */

public class FragmentSetor extends Fragment {

    private TextView nomeSetor;
    private TextView horario;
    private TextView descricao;
    private TextView email;
    private TextView telefone;
    private TextView responsavel;
    private ImageView imagemSetor;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.conteudo_layout_setor, container, false);

        Intent i = getActivity().getIntent();
        Setor s = (Setor) i.getSerializableExtra("objSetor");


        recuperarIds(view);

        nomeSetor.setText(s.getNomeSetor());
        horario.setText(s.getHorarioFuncionamento());
        email.setText(s.getEmailResponsavel());
        telefone.setText(s.getTelefone());
        responsavel.setText(s.getNomeResponsavel());
        //descricao.setText(s.getDescricao());
        imagemSetor.setImageResource(s.getImage());
        return view;
    }


    void recuperarIds(View view){

        nomeSetor = view.findViewById(R.id.nomeSetorDetalhes);
        horario = view.findViewById(R.id.horarioSetorDetalhes);
        descricao = view.findViewById(R.id.descricaoSetorDetalhes);
        email = view.findViewById(R.id.emailSetorDetalhes);
        responsavel = view.findViewById(R.id.responsavelSetorDetalhes);
        telefone = view.findViewById(R.id.telefoneSetorDetalhes);
        imagemSetor = getActivity().findViewById(R.id.image_toolbar_layout);

    }









}
