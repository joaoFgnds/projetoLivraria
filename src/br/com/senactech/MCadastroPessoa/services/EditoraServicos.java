/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

import br.com.senactech.MCadastroPessoa.dao.DAOFactory;
import java.sql.SQLException;
import br.com.senactech.MCadastroPessoa.model.editora;
import br.com.senactech.MCadastroPessoa.dao.EditoraDAO;


/**
 *
 * @author faria
 */
public class EditoraServicos {
    public void cadastrarEditora (editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        eDAO.cadastrarEditora(eVO);
    }
}   
