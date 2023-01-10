package com.poo.daoxrepo;

import java.util.Date;

/**
 *
 * @author tulio
 */
public class main {

    public static void main(String[] args) {
        Produto p = new Produto(0, "mouse gamer", 127.99, "mouse novo ", new Date(System.currentTimeMillis()));
        SQLProdutoDAO daoP = new SQLProdutoDAO();
        
        try{
            daoP.add(p);
            p = new Produto(0, "Fonte 500w", 227.99, "XPG gammix 500w pfc ativo 80plus bronze ", new Date(System.currentTimeMillis()));
            daoP.add(p);
            p = new Produto(0, "pasta térmica", 1.99, "pasta térmica branca 1.2 w/mk", new Date(System.currentTimeMillis()));
            daoP.add(p);
            Produto a = daoP.getOne(11);
            System.out.println(a);
            System.out.println("---------------------------");
            System.out.print(daoP.getAll());
        }
        catch(Exception err){
            System.out.println(err);
        }
        
    }
}
