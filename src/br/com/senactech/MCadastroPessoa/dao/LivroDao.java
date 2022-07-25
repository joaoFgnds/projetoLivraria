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
import br.com.senactech.MCadastroPessoa.model.livro;
import br.com.senactech.MCadastroPessoa.model.editora;

/**
 *
 * @author faria
 */
public class LivroDao {

    public void cadastrarLivro(livro lVO) throws SQLException {
        //Busca conexao com o BD
        Connection con = conexao.getConexao();
        //cria um objeto stat responsavel por enviar os comandos sql do ajva 
        // para serem executados dentro do bd 
        Statement stat = con.createStatement();

        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into livro values (null, ' " + lVO.getTitulo() + " ' , ' "
                    + lVO.getIsbn() + " ' , ' " + lVO.getAssunto() + " ' , ' "
                    + lVO.getAutor() + " ' , " + lVO.getEstoque() + " , "
                    + lVO.getPreco() + " , " + lVO.getIdEditora() + ")";
            System.out.println(sql);
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir livro ! \n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public ArrayList<livro> buscarLivros() throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "select * from livro";
            //atribuo ao rs o resultado da execução da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<livro> livros = new ArrayList<>();
            while (rs.next()) {
                livro L = new livro();
                //lado do java |x| lado do banco
                L.setIdLivro(rs.getInt("idlivro"));
                L.setTitulo(rs.getString("tituloLivro"));
                L.setIsbn(rs.getString("isbn"));
                L.setAssunto(rs.getString("assunto"));
                L.setAutor(rs.getString("autor"));
                L.setEstoque(rs.getInt("estoque"));
                L.setPreco(rs.getFloat("valor"));
                L.setIdEditora(rs.getInt("ideditora"));
                livros.add(L);
            }
            return livros;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Livros! \n " + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }


    public livro getByDocBD(String isbn) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        livro L = new livro();
        
        try {
            String sql;
            sql = "select * from livro where isbn =  " + isbn;
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                L.setIdLivro(rs.getInt("idlivro"));
                L.setTitulo(rs.getString("tituloLivro"));
                L.setIsbn(rs.getString("isbn"));
                L.setAssunto(rs.getString("assunto"));
                L.setAutor(rs.getString("autor"));
                L.setEstoque(rs.getInt("estoque"));
                L.setPreco(rs.getFloat("valor"));
                L.setIdEditora(rs.getInt("ideditora"));
            }
        } catch (SQLException e) {
            throw new SQLException("Livro com este ISBN não existe. \n"
                    + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
        return L;
    }

    public boolean verificarLivro(int id) throws SQLException {
        boolean verLivro = false;
        try {
            for (livro liv : buscarLivros()) {
                if (liv.getIdEditora() == id) {
                    verLivro = true;
                    break;
                }
            }
            return verLivro;
        } catch (SQLException e) {
            throw new SQLException("livro com este id nao existe. \n"
                    + e.getMessage());
        }

    }

    public livro getByDocID(int id) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        livro L = new livro();
        try {
            String sql;
            sql = "select * from livro where idlivro = " + id;
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                L.setIdLivro(rs.getInt("idlivro"));
                L.setTitulo(rs.getString("tituloLivro"));
                L.setIsbn(rs.getString("isbn"));
                L.setAssunto(rs.getString("assunto"));
                L.setAutor(rs.getString("autor"));
                L.setEstoque(rs.getInt("estoque"));
                L.setPreco(rs.getFloat("valor"));
                L.setIdEditora(rs.getInt("ideditora"));
            }
        } catch (SQLException e) {
            throw new SQLException("Livro com este ID não existe. \n"
                    + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
        return L;
    }

    public void deletarLivro(int id) throws SQLException {
        // Busca conexão com o BD
        Connection con = conexao.getConexao();
        //Cria um objeto stat responsavel por enviar os comandos sql do Java para serem executados dentro do BD
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "delete from livro where idLivro = " + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar livro. \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }

    }
    
    public void atualizaLivros (livro LVO) throws SQLException {
        //Busca conexão com o BD
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "update livro set "
                    + "tituloLivro = ' " + LVO.getTitulo()+ " ', "
                    + "isbn = ' " +LVO.getIsbn()+ " ' , "
                    + "assunto = ' " + LVO.getAssunto()+ " ' , "
                    + "autor = ' " + LVO.getAutor()+ " ' , "
                    + "estoque = " + LVO.getEstoque()+ ","
                    + "valor = " + LVO.getPreco()+ " ";
               //     + "where ideditora = " + LVO.getIdLivro()+ "";
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao atualizar livros. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
}
