/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

import br.com.senactech.MCadastroPessoa.dao.DAOFactory;
import br.com.senactech.MCadastroPessoa.dao.ClienteDAO;
import br.com.senactech.MCadastroPessoa.model.cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author faria
 */
public class ClienteServicos {

    public void cadastrarClientCpf(cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        cDAO.cadastrarClienteCPF(cVO);
    }

    public void cadastrarClienteCnpj(cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        cDAO.cadastrarClienteCNPJ(cVO);
    }

    public ArrayList<cliente> ListaCliente() throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.buscarClientes();
    }

    public boolean verificaCliente(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.verificarcliente(id);
    }

    public boolean verCNPJ(String cnpj) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.verCNPJ(cnpj);
    }
    
    public boolean verCPF(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.verCPF(cpf);
    }

    public void deletarCliente(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        cDAO.deletarcliente(id);
    }

    public cliente pesqCli(int cpfCNPJ, String pesq) throws SQLException {
        ClienteDAO cVO = DAOFactory.getclienteDAO();
        return cVO.pesquisaCliente(cpfCNPJ, pesq);
    }

    public void editarCliente(cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        cDAO.atualizarCliente(cVO);
    }

    public cliente buscarClienteBD(String cpf) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.getByDocBDCPF(cpf);
    }
    
     public cliente buscarClienteBDCNPJ(String cnpj) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.getByDocBDCNPJ(cnpj);
    }
     
      public cliente getByDocBD(int id) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.getByDocBD(id);
    }

    
 
}
