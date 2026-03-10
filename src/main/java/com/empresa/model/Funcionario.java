package com.empresa.model;

public class Funcionario {

    private int id;
    private String nome;
    private int idade;
    private char sexo;
    private String email;

    public Funcionario(String nome, int idade, char sexo, String email) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
    }

    public Funcionario(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
}