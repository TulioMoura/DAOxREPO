/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.daoxrepo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author tulio
 */
public class SQLProdutoDAO implements ProdutoDAOinterface {
    private Connection  connect() throws Exception{
       Connection connection =  DriverManager.getConnection("jdbc:sqlite:productsdb.sqlite");
       return connection;
    }
    public void add(Produto p)throws Exception{
        Connection c = connect();
        try{
            
            PreparedStatement s = c.prepareStatement("INSERT INTO produtos (nome,valor,descricao,dataCriacao)"
                    + "VALUES ('"+ p.getNome() + "','" + p.getValor() + "','" + p.getDescição() + "','" + p.getDataCriacao().getTime() +"');");
            boolean execute = s.execute();            
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close();
        }
        
    }
    public Produto getOne(int id)throws Exception{
        Connection c = connect();
        try{
            
            PreparedStatement s = c.prepareStatement("SELECT * FROM produtos where id = "+id+";");
            ResultSet rst = s.executeQuery();
            String name = rst.getString("nome");
            double valor = rst.getDouble("valor");
            String desc = rst.getString("descricao");
            long dateTimestamp = rst.getLong("dataCriacao");
            Date dataCriacao  = new Date(dateTimestamp);
            Produto p = new Produto(id, name, valor, desc, dataCriacao);
            return p;
            
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close();
        }
        
    }
    public ArrayList<Produto> getAll()throws Exception{
        Connection c = connect();
        try{
            
            PreparedStatement s = c.prepareStatement("SELECT * FROM produtos;");
            ResultSet rst = s.executeQuery();
            ArrayList<Produto> lista = new ArrayList();
            do{
                int id = rst.getInt("id");
               String name = rst.getString("nome");
            double valor = rst.getDouble("valor");
            String desc = rst.getString("descricao");
            long dateTimestamp = rst.getLong("dataCriacao");
            Date dataCriacao  = new Date(dateTimestamp);
            Produto p = new Produto(id, name, valor, desc, dataCriacao); 
                lista.add(p);
                
            }while(rst.next());
            return lista;
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close();
        }
        
        
    }
    
    public void update(Produto p)throws Exception{
        Connection c = connect();
        try{
            PreparedStatement s = c.prepareStatement("SELECT * FROM produtos where id = "+p.getId()+";");
            ResultSet rst = s.executeQuery();
            rst.updateString("nome", p.getNome());
            rst.updateDouble ("valor",p.getValor());
            rst.updateString("descricao",p.getDescição());
            rst.updateLong("dataCriacao",p.getDataCriacao().getTime());
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close();
        }
        
    }
    public void delete(int id) throws Exception{
        Connection c = connect();
        try{
            PreparedStatement s = c.prepareStatement("SELECT * FROM produtos where id = "+id+";");
            s.executeQuery();
                  
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close();
        }
    }
}
