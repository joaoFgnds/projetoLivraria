/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

import br.com.senactech.MCadastroPessoa.dao.DAOFactory;
import br.com.senactech.MCadastroPessoa.dao.LivroDao;
import br.com.senactech.MCadastroPessoa.model.livro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author faria
 */
public class LivroServicos {

    public void cadastrarLivro(livro lVO) throws SQLException {
        LivroDao lDAO = DAOFactory.getlivroDAO();
        lDAO.cadastrarLivro(lVO);
    }

    public ArrayList<livro> listaLivros() throws SQLException {
        LivroDao eDAO = DAOFactory.getlivroDAO();
        return eDAO.buscarLivros();
    }

    public boolean verificalivro(int id) throws SQLException {
        LivroDao eDAO = DAOFactory.getlivroDAO();
        return eDAO.verificarLivro(id);
    }

//    public boolean verificaEditora(String gerente) throws SQLException {
//        LivroDao eDAO = DAOFactory.getlivroDAO();
//        return eDAO.verISNB(gerente);
//    }
    public livro pegarisbn(String isbn) throws SQLException {
        LivroDao eDAO = DAOFactory.getlivroDAO();
        return eDAO.getByDocBD(isbn);
    }

    public livro pegarID(int id) throws SQLException {
        LivroDao eDAO = DAOFactory.getlivroDAO();
        return eDAO.getByDocID(id);
    }

    public void deletar(int id) throws SQLException {
        LivroDao eDAO = DAOFactory.getlivroDAO();
        eDAO.deletarLivro(id);
    }

    public void atualizaLivro(livro LVO) throws SQLException {
        LivroDao eDAO = DAOFactory.getlivroDAO();
        eDAO.atualizaLivros(LVO);
    }

}
