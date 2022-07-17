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
import br.com.senactech.MCadastroPessoa.model.cliente;
import br.com.senactech.MCadastroPessoa.conexao.conexao;
import br.com.senactech.MCadastroPessoa.model.editora;

/**
 *
 * @author faria
 */
public class EditoraDAO {

    public void cadastrarEditora(editora eVO) throws SQLException {
        //Busca conexao com o BD
        Connection con = conexao.getConexao();
        //cria um objeto stat responsavel por enviar os comandos sql do ajva 
        // para serem executados dentro do bd 
        Statement stat = con.createStatement();
        
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into pessoa values (null, ' " + eVO.getNmEditora()+ " ' , ' "
                    + eVO.getEndereco()+ " ' , ' " + eVO.getTelefone() + " ' , ' "
                    + eVO.getGerente()+ " ' )";
            stat.execute(sql);
        } catch (Exception e) {
            throw new  SQLException("Erro ao inserir Editora ! \n" + e.getMessage());
        }finally {
            stat.close();
            con.close();
        }
    }
}
