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
    public void cadastrarClientCpf (cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        cDAO.cadastrarClienteCPF(cVO);
    }
    
    public void cadastrarClienteCnpj (cliente cVO) throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
       cDAO.cadastrarClienteCNPJ(cVO);
    }
    
    
    public ArrayList<cliente> ListaCliente() throws SQLException {
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.buscarClientes();
    }
    
    public boolean verificaCliente(int id) throws SQLException{
        ClienteDAO cDAO = DAOFactory.getclienteDAO();
        return cDAO.vercliente(id);
    }
    
//    public void deletarCliente(int id) throws SQLException {
//        ClienteDAO cDAO = DAOFactory.getclienteDAO();
//        return cDAO.deletarcliente(id);
//    }
    
    
    public cliente pesqCli(int cpfCNPJ, String pesq) throws SQLException {
        ClienteDAO cVO = DAOFactory.getclienteDAO();
        return cVO.pesquisaCliente(cpfCNPJ, pesq);
    }
    
}
