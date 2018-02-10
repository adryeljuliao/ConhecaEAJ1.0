package com.idp.conhecaeaj;


import java.io.Serializable;

public class Setor implements Serializable{

    private double latitude;
    private double longitude;
    private String nomeSetor;
    private String horarioFuncionamento;
    private String emailResponsavel;
    private String nomeResponsavel;
    private int image;
    private int descricao;
    private int textao;
    private String telefone;






    public Setor(String s3, String s2, String s1, String s, int alojamento_m, String nomeSetor, String horarioFuncionamento, double v, int textao) {
        this.nomeSetor = nomeSetor;
        this.horarioFuncionamento = horarioFuncionamento;
        this.textao = textao;
    }

    public Setor(String nomeSetor, String horario, String email, String nomeResponsavel, int image, int descricao, String telefone, double latitude, double longitude) {
        this.nomeSetor = nomeSetor;
        this.horarioFuncionamento = horario;
        this.descricao = descricao;
        this.emailResponsavel = email;
        this.nomeResponsavel = nomeResponsavel;
        this.image = image;
        this.telefone = telefone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setTextao(int textao) {
        this.textao = textao;
    }

    public int getTextao() {

        return textao;
    }

    public Setor(String nomeSetor){

        this.nomeSetor = nomeSetor;
    }
    public Setor( String nomeSetor, String horarioFuncionamento, String emailResponsavel, String nomeResponsavel, int image, int descricao, int textao, String telefone, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nomeSetor = nomeSetor;
        this.horarioFuncionamento = horarioFuncionamento;
        this.emailResponsavel = emailResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.image = image;
        this.descricao = descricao;
        this.textao = textao;
        this.telefone = telefone;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    public int   getDescricao() {
        return descricao;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public int getImage() {
        return image;
    }
}
