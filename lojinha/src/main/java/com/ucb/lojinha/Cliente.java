/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucb.lojinha;

/**
 *
 * @author kurok
 */
public class Cliente {
    
    private long idCliente;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    
    public Cliente(long idCliente, String nome, String email, String senha, String cpf){
        
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }
    
    

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
