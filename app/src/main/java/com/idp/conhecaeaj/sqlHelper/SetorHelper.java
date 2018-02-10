package com.idp.conhecaeaj.sqlHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.idp.conhecaeaj.R;
import com.idp.conhecaeaj.Setor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quaresma on 08/02/2018.
 */

public class SetorHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "conhecendoEAJ";
    /*
    private double latitude;
    private double longetude;
    private String nomeSetor;
    private String horarioFuncionamento;
    private String emailResponsavel;
    private String nomeResponsavel;
    private int image;
    private String descricao;
    private int textao;
    private String telefone;
    *
    * */

    /* SQL de criação do banco de dados. */
    private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS setor(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome_setor TEXT," +
            "telefone TEXT, " +
            "horario_funcionamento TEXT, " +
            "email_responsavel TEXT, " +
            "nome_responsavel TEXT, " +
            "descricao TEXT, " + //Famoso TEXTAO
            "image INTEGER, " +
            "latitude REAL, " +
            "longitude REAL)";


    private static final String SQL_SELECT_ALL = "SELECT * FROM setor ORDER BY nome_setor";
    private static final String SQL_SELECT_NOME = "SELECT * FROM pessoa WHERE nome = '%s'";
    private static final String SQL_SELECT_ID = "SELECT * FROM pessoa WHERE id = '%s'";

    /* Classe com métodos para executar os comandos SQL e manipular o banco de dados. */
    private SQLiteDatabase banco = getWritableDatabase();
    /* Interface que permite acesso aos dados retornados pelo banco de dados. */
    private Cursor cursor = null;

    /* Índice das colunas no banco de dados */
    private int indexId;
    private int indexNomeSetor;
    private int indexTelefone;
    private int indexHorarioFuncionamento;
    private int indexEmail;
    private int indexNomeResp;
    private int indexDesc;
    private int indexImg;
    private int indexLongitude;
    private int indexLatitude;

    public SetorHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public boolean insert(Setor setor) {

        long id = setor.getId();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome_setor", setor.getNomeSetor());
        contentValues.put("horario_funcionamento", setor.getHorarioFuncionamento());
        contentValues.put("email_responsavel", setor.getEmailResponsavel());
        contentValues.put("nome_responsavel", setor.getNomeResponsavel());
        //contentValues.put("descricao", setor.getDescricao());
        contentValues.put("telefone", setor.getTelefone());
        contentValues.put("image", setor.getImage());
        contentValues.put("latitude", setor.getLatitude());
        contentValues.put("longitude", setor.getLongitude());

        this.banco.insert("setor", null, contentValues);

        if (banco != null)
            return true;
        else
            return false;


    }

    /* Método que recupera todos os registro do banco de dados. */
    public List<Setor> getAll() {
        SQLiteDatabase db = getReadableDatabase();
        try {
            // select * from carro
            Cursor c = db.query("setor", null, null, null, null, null, null, null);
            return toList(c);
        } finally {
            db.close();
        }
    }

    private List<Setor> toList(Cursor c) {

        List<Setor> setores = new ArrayList<>();

        if (c.moveToFirst()) {
            do {
                Setor setor = new Setor();
                setores.add(setor);

                // recupera os atributos de carro
                setor.setId(c.getInt(c.getColumnIndex("id")));
                setor.setNomeSetor(c.getString(c.getColumnIndex("nome_setor")));
                setor.setNomeResponsavel(c.getString(c.getColumnIndex("nome_responsavel")));
                setor.setEmailResponsavel(c.getString(c.getColumnIndex("email_responsavel")));
                setor.setHorarioFuncionamento(c.getString((c.getColumnIndex("horario_funcionamento"))));
                setor.setTelefone(c.getString((c.getColumnIndex("telefone"))));
                setor.setLatitude(c.getDouble((c.getColumnIndex("latitude"))));
                setor.setLongitude(c.getDouble((c.getColumnIndex("longitude"))));
                setor.setImage(c.getInt(c.getColumnIndex("image")));

                //setor.setDescricao(c.getInt(c.getColumnIndex("descricao")));
                //setor.setTextao(c.getInt(c.getColumnIndex(""))); //Famosa descrição

            } while (c.moveToNext());
        }
        return setores;
    }

    public List createList() {
        List<Setor> listaSetor = new ArrayList<>();

        listaSetor.add(new Setor("Diretoria", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.diretoria, R.string.setor_descricao_diretoria, "(84)4002-8922", -5.886449, -35.362213));

        listaSetor.add(new Setor("Informática", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.informatica, R.string.descricao_informatica, "(84)4002-8922", -5.885786, -35.365748));

        listaSetor.add(new Setor("Apicultura", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.apicultura, R.string.setor_descricao_apicultura, "(84)4002-8922", 5.885880, -35.362644));

        listaSetor.add(new Setor("Centro Vocacional Tecnológico - CVT", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.cvt, R.string.setor_descricao_cvt, "(84)4002-8922", -5.884567, -35.364924));

        listaSetor.add(new Setor("Lanchonete", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.lanchonet, R.string.setor_descricao_lanchonete, "(84)4002-8922", -5.884967, -35.363785));

        listaSetor.add(new Setor("Avicultura", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.avicultura, R.string.setor_descricao_avicultura, "(84)4002-8922", -5.886712, -35.363297));

        listaSetor.add(new Setor("Prédio e-Tec", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.predio_etec, R.string.setor_descricao_predio_etec, "(84)4002-8922", -5.885260, -35.366496));

        listaSetor.add(new Setor("Restaurante universitário - RU", "7h - 17h", "email@responsável.com", "Taniro Chacon",
                R.drawable.restaurante, R.string.setor_descricao_ru, "(84)4002-8922", -5.885471, -35.362908));

        return listaSetor;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
