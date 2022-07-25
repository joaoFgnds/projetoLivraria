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
import br.com.senactech.MCadastroPessoa.model.editora;
import br.com.senactech.MCadastroPessoa.conexao.conexao;
import br.com.senactech.MCadastroPessoa.model.cliente;

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
            sql = "insert into editora values (null , ' " + eVO.getNmEditora() + " ' , ' "
                    + eVO.getEndereco() + " ' , ' " + eVO.getTelefone() + " ' , ' "
                    + eVO.getGerente() + " ' )";
            //vamos executar o comando construido na string sql
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir editora ! \n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
        //PARA CADASTRAR CLIENTE COM O CPF 
    }

    public ArrayList<editora> buscarEditoras() throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "select * from editora";
            //atribuo ao rs o resultado da execução da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<editora> editoras = new ArrayList<>();
            while (rs.next()) {
                editora e = new editora();
                //lado do java |x| lado do banco
                e.setIdEditora(rs.getInt("ideditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                editoras.add(e);
            }
            return editoras;
        } catch (SQLException ex) {
            throw new SQLException("Erro ao buscar Pessoas! \n " + ex.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public boolean verificarEditora(int id) throws SQLException {
        boolean verEditora = false;
        try {
            for (editora edit : buscarEditoras()) {
                if (edit.getIdEditora() == id) {
                    verEditora = true;
                    break;
                }
            }
            return verEditora;
        } catch (SQLException e) {
            throw new SQLException("Cliente com este id nao existe. \n"
                    + e.getMessage());
        }

    }

    public boolean verGerente(String gerente) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        boolean verGerente = false;
        try {
            String sql;
            sql = "select gerente from editora where gerente = ' " + gerente + " ' ";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verGerente = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("gerente inesitente. \n "
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return verGerente;
    }
    
      public boolean verID(int id) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        boolean verID = false;
        try {
            String sql;
            sql = "select id from editora where id = " + id;
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verID = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("id inesitente. \n "
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return verID;
    }

    public void deletarcliente(int id) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "delete from editora where idEditora = " + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Pessoa. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    

//    public editora pesquisarEditora (int id, String pesq) throws SQLException {
//        editora e = new editora();
//         try {
//            switch (id ) {
//                case 1:
//                    for (editora edit : buscarEditoras()) {
//                        if (edit.getGerente() != null && edit.getGerente().equals(pesq)) {
//                            e = edit;
//                            break;
//                        }
//                    }
//                    break;
//                case 2:
//                    for (editora edit : buscarEditoras()) {
//                        if (edit.getCnpj() != null && edit.getCnpj().equals(pesq)) {
//                            e = edit;
//                            break;
//                        }
//                    }
//                    break;
//                default:
//                    System.out.println("Cliente não Encontrado!!!");
//                    break;
//            }
//            return e;
//        } catch (SQLException ex) {
//            throw new SQLException(ex.getMessage());
//        }
//    }
    
    
    public int getIdEditora(String id) throws SQLException {
        int idEditora = 0;
        for (editora edt : buscarEditoras()) {
            if (edt.getNmEditora().equals(id)) {
                idEditora = edt.getIdEditora();
                System.out.println("Editora: " + edt.getNmEditora());
            }
        }
        return idEditora;
    }
    
    
    public editora getByDocBD(int id) throws SQLException {
        //Busca conexão com o BD
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        editora e = new editora();

        try {
            String sql;
            sql = "select * from editora where ideditora = " + id;
            ResultSet rs = stat.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                //lado do java |x| lado do banco    
                e.setIdEditora(rs.getInt("ideditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("gerente"));    
            }
            
        } catch (SQLException ex) {
            throw new SQLException("Editora com este ID não existe. \n"
                    + ex.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return e;
    }
    
    public Boolean verNomeEditora(String nome) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        boolean verNomeEd = true;

        try {
            String sql;
            sql = "select nomeEditora from editora where nomeEditora = '" + nome + "'";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verNomeEd = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Editora com este nome não existe! \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return verNomeEd;
    }
    
    public editora getByDocBDnome(String nomeEditora) throws SQLException {
        //Busca conexão com o BD
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        editora e = new editora();

        try {
            String sql;
            sql = "select * from editora where nomeEditora = ' " + nomeEditora + " ' ";
            ResultSet rs = stat.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {
                //lado do java |x| lado do banco    
                e.setIdEditora(rs.getInt("ideditora"));
                e.setNmEditora(rs.getString("nomeEditora"));
                e.setEndereco(rs.getString("endereco"));
                e.setTelefone(rs.getString("telefone"));
                e.setGerente(rs.getString("gerente"));    
            }
            
        } catch (SQLException ex) {
            throw new SQLException("Editora com este ID não existe. \n"
                    + ex.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return e;
    }
     public void atualizarEditora(editora cVO) throws SQLException {
        //Busca conexão com o BD
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "update editora set "
                    + "nomeEditora = ' " + cVO.getNmEditora()+ " ', "
                    + "endereco= ' " +cVO.getEndereco() + " '," 
                    + "telefone = ' " + cVO.getTelefone()+ " ' ,"
                    + "gerente = ' " + cVO.getGerente() + " '";
                    //+ "where idEditora = " + cVO.getIdEditora()+ "";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar editora. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
}
