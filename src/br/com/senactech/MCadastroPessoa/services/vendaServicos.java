/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

import br.com.senactech.MCadastroPessoa.dao.DAOFactory;
import br.com.senactech.MCadastroPessoa.dao.vendaDAO;
import br.com.senactech.MCadastroPessoa.model.vendaLivro;
import java.sql.SQLException;

/**
 *
 * @author faria
 */
public class vendaServicos {
    public void venderLivro (vendaLivro vVO) throws SQLException {
        vendaDAO vDAO = DAOFactory.getvendaDAO();
        vDAO.vendaLivro(vVO);
    }
}
