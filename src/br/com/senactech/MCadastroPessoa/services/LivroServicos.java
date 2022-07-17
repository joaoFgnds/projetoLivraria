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

/**
 *
 * @author faria
 */
public class LivroServicos {
     public void cadastrarCliente (livro lVO) throws SQLException {
        LivroDao lDAO = DAOFactory.getlivroDAO();
        lDAO.cadastrarLivro(lVO);
    }
}
