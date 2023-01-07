/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poo.daoxrepo;

import java.util.ArrayList;

/**
 *
 * @author tulio
 */
public interface ProdutoDAOinterface {
    public void add(Produto p)throws Exception;    
    public Produto getOne(int id)throws Exception;
    public ArrayList<Produto> getAll()throws Exception;
    public void update(Produto p)throws Exception;
    public void delete(int id)throws Exception;
}
