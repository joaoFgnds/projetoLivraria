/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.dao;

/**
 *
 * @author faria
 */
public class DAOFactory {
    private static ClienteDAO clienteDAO = new ClienteDAO();
    
    public static ClienteDAO getclienteDAO() {
        return clienteDAO;
    }
    
    private static EditoraDAO editoraDAO = new EditoraDAO();
    
    public static EditoraDAO geteditoraDAO() {
        return editoraDAO;
    }
    
    private static LivroDao livroDAO = new LivroDao();
    
    public static LivroDao getlivroDAO() {
        return livroDAO;
    }
    
    private static vendaDAO vendaDAO = new vendaDAO();
    
    public static vendaDAO getvendaDAO() {
        return vendaDAO;
    }
}
