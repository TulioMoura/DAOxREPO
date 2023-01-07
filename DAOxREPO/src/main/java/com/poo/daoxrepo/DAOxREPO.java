package com.poo.daoxrepo;

import java.util.Date;

/**
 *
 * @author tulio
 */
public class DAOxREPO {

    public static void main(String[] args) {
        Produto p = new Produto(1, "mouse gamer", 127.99, "mouse novo ", new Date(System.currentTimeMillis()));
        SQLProdutoDAO daoP = new SQLProdutoDAO();
        
        try{
            daoP.add(p);
            Produto a = daoP.getOne(p.getId());
            System.out.println(a.getNome() + "  "+a.getDataCriacao());
        }
        catch(Exception err){
            System.out.println(err);
        }
        
    }
}
