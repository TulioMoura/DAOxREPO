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

    private int id;
    private String nome;
    private double valor;
    private String descição;
    private Date dataCriacao;


    public Produto(int id, String nome, double valor, String descição, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.descição = descição;
        this.dataCriacao = dataCriacao;
    }
    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
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
    
    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", desci\u00e7\u00e3o=" + descição + ", dataCriacao=" + dataCriacao + '}';
    }
}
