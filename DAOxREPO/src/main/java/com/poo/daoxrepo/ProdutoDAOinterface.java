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
    public void add();    
    public Produto getOne(int id);
    public ArrayList<Produto> getAll();
    public void update(Produto p);
    public void Delete(int id);
    
}
