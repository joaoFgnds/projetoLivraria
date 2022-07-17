/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.services;

/**
 *
 * @author faria
 */
public class ServicosFactory {
    private static ClienteServicos clienteServicos = new ClienteServicos();
    
    public static ClienteServicos getclienteServicos() {
        return clienteServicos;
    }
    
    private static EditoraServicos editoraServicos = new EditoraServicos();
    
    public static EditoraServicos geteditoraServicos(){
        return editoraServicos;
    }
    
    private static LivroServicos livroServicos = new LivroServicos();
    
    public static LivroServicos getLivroServicos(){
        return livroServicos;
    }
    
    private static vendaServicos VendaServicos = new vendaServicos();
    
    public static vendaServicos getvendaServicos(){
        return VendaServicos;
    }
}
