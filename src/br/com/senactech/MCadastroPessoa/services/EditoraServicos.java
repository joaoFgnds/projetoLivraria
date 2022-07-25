/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

import br.com.senactech.MCadastroPessoa.dao.DAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.senactech.MCadastroPessoa.model.editora;
import br.com.senactech.MCadastroPessoa.dao.EditoraDAO;

/**
 *
 * @author faria
 */
public class EditoraServicos {

    public void cadastrarEditora(editora eVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        eDAO.cadastrarEditora(eVO);
    }

    public ArrayList<editora> ListaEditoras() throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.buscarEditoras();
    }

    public boolean verificaEditora(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.verificarEditora(id);
    }

    public boolean verificaGerente(String gerente) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.verGerente(gerente);
    }

    public boolean verificaeditora(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.verID(id);
    }

    public void deletareditoa(int id) throws SQLException {
        EditoraDAO cDAO = DAOFactory.geteditoraDAO();
        cDAO.deletarcliente(id);
    }

//    public cliente pesqCli(int cpfCNPJ, String pesq) throws SQLException {
//        ClienteDAO cVO = DAOFactory.getclienteDAO();
//        return cVO.pesquisaCliente(cpfCNPJ, pesq);
//    }
    public int pegarIDEditora(String id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.getIdEditora(id);
    }

    public editora getByDocBD(int id) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.getByDocBD(id);
    }
     public editora getByDocBDnome(String nome) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.getByDocBDnome(nome);
    }
    
    public void editarCliente(editora cVO) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        eDAO.atualizarEditora(cVO);
    }

    public boolean verNomeeditora(String nome) throws SQLException {
        EditoraDAO eDAO = DAOFactory.geteditoraDAO();
        return eDAO.verNomeEditora(nome);
    }
}
