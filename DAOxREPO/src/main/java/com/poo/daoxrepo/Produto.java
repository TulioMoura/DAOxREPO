/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.daoxrepo;

import java.util.Date;

/**
 *
 * @author tulio
 */
public class Produto {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto(int id, String nome, float valor, String descição, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descição = descição;
        this.dataCriacao = dataCriacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescição() {
        return descição;
    }

    public void setDescição(String descição) {
        this.descição = descição;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    private int id;
    private String nome;
    private float valor;
    private String descição;
    private Date dataCriacao;
}
