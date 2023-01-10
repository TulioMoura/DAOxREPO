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
 * Exemplo de implementação de um DAO para sqlite, nesse caso, o DAO abstrai as chamadas ao banco de dados, removendo a preocupação do programador em como e onde os dados são armazenados.
 * @author tulio
 */
public class SQLProdutoDAO implements ProdutoDAOinterface {
    //método que abre uma conexão com o banco de dados, e retorna uma conexão ativa
    private Connection  connect() throws Exception{ 
       Connection connection =  DriverManager.getConnection("jdbc:sqlite:productsdb.sqlite");
       return connection;
    }
    
    //método de adição de um novo produto, ele abstrai uma chamada ao banco de dados para criar um novo produto.
    public void add(Produto p)throws Exception{
        Connection c = connect(); //abre a conexão com o bd
        try{
            //cria uma query para ser enviada ao db com base nos dados recebidos
            PreparedStatement s = c.prepareStatement("INSERT INTO produtos (nome,valor,descricao,dataCriacao)"
                    + "VALUES ('"+ p.getNome() + "','" + p.getValor() + "','" + p.getDescição() + "','" + p.getDataCriacao().getTime() +"');");
            boolean execute = s.execute();//executa a query no banco de dados
        } catch (SQLException ex) {
            //trata qualquer exceção gerada pelo sql e retorna uma Exceção genérica, com uma tag de sql exception
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            //fecha a conexão com o bd
            c.close();
        }
        
    }
    
    
    public Produto getOne(int id)throws Exception{
        Connection c = connect(); //abre uma nova conexão com o bd              
        Produto p ;
        try{
            //gera uma nova query e recebe os dados do banco de dados
            PreparedStatement s = c.prepareStatement("SELECT * FROM produtos where id = "+id+";");
            ResultSet rst = s.executeQuery();
            String name = rst.getString("nome");
            double valor = rst.getDouble("valor");
            String desc = rst.getString("descricao");
            long dateTimestamp = rst.getLong("dataCriacao");
            
            Date dataCriacao  = new Date(dateTimestamp);
            //cria um novo objeto com base no que foi recebido do banco de dados e retorna
            p = new Produto(id, name, valor, desc, dataCriacao);
            return p;
            
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close(); //fecha a conexão com o bd
            
        }
        
    }
    public ArrayList<Produto> getAll()throws Exception{
        Connection c = connect(); //abre a conexão com o banco de dados
        ArrayList<Produto> lista = new ArrayList(); //instancia o arraylist que será retornado
        
        try{
            //gera a query sql que será executada
            PreparedStatement s = c.prepareStatement("SELECT * FROM produtos;");
            ResultSet rst = s.executeQuery(); //executa a query e obtém os resultados 
            
            do{
                //para cada linha do resultado da query, instancia um novo objeto e armazena na lista de produtos
                int id = rst.getInt("id");
               String name = rst.getString("nome");
            double valor = rst.getDouble("valor");
            String desc = rst.getString("descricao");
            long dateTimestamp = rst.getLong("dataCriacao");
            Date dataCriacao  = new Date(dateTimestamp);
            Produto p = new Produto(id, name, valor, desc, dataCriacao); 
                lista.add(p);
                
            }while(rst.next());
            
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close(); //fecha a conexão com o bd
            return lista; //retorna a lista com os resultados.
        }
        
        
    }
    
    public void update(Produto p)throws Exception{
        Connection c = connect();//abre uma nova conexão oom o bd
        
        try{
            //gera a query sql que atualiza a linha da tablea
            PreparedStatement s = c.prepareStatement("UPDATE produtos SET [nome] = '"+p.getNome()+"',[valor] = '"+p.getValor()+"', [descricao]='"+p.getDescição()+"' where id = "+p.getId()+";");
            
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            //fecha a conexaão com o banco de dados
            c.close();
        }
        
    }
    public void delete(int id) throws Exception{
        Connection c = connect();//abre a conexão com o banco de dados
        try{
            
            PreparedStatement s = c.prepareStatement("DELETE FROM produtos where id = "+id+";");
            s.executeQuery();
                  
        } catch (SQLException ex) {
            throw new Exception("sql exception: " + ex.getMessage());
            
        }
        finally{
            c.close();
        }
    }
}
