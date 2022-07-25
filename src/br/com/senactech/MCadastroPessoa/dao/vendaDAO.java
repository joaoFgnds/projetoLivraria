/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.senactech.MCadastroPessoa.conexao.conexao;
import br.com.senactech.MCadastroPessoa.model.vendaLivro;

/**
 *
 * @author faria
 */
public class vendaDAO {

    public void vendaLivro(vendaLivro vVO) throws SQLException {
        //Busca conexao com o BD
        Connection con = conexao.getConexao();
        //cria um objeto stat responsavel por enviar os comandos sql do ajva 
        // para serem executados dentro do bd 
        Statement stat = con.createStatement();
        
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into compra values (null, ' " + vVO.getIdCliente()+ ", "
                    + vVO.getIdLivro()+ ", ' " + vVO.getDataVenda()+ " ' ,"
                    + vVO.getQtd()+ " )";
            stat.execute(sql);
        } catch (SQLException e) {
            throw new  SQLException("Erro ao comprar livro ! \n" + e.getMessage());
        }finally {
            stat.close();
            con.close();
        }
    }
    
     public ArrayList<vendaLivro> buscarVendaLivros() throws SQLException {
        //busca conexão com o BD
        Connection con = conexao.getConexao();
        //cria um objeto stat reponsavel por enviar os comandos sql do Java
        //para serem executados dentro do DB
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "Select * from Venda";
            //atribuo ao rs o resultado da exec~ção da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<vendaLivro> vendas = new ArrayList<>();
            while (rs.next()) {
                vendaLivro v = new vendaLivro();
                //lado do java||lado do banco
                v.setIdVenda(rs.getInt("idVenda"));
                v.setIdCliente(rs.getInt("idCliente"));
                v.setIdLivro(rs.getInt("idLivro"));
                v.setQtd(rs.getInt("quantCompra"));
                v.setSubTotal(rs.getInt("subTotal"));  
               
                //v.setDataVenda(rs.getDate("dataVenda").toLocalDate());
                
                vendas.add(v);
            }
            return vendas;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar vendas \n" + e.getMessage());

        } finally {
            stat.close();
            con.close();
        }
    }
}
