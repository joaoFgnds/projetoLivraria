/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.controler;

import java.util.ArrayList;
import br.com.senactech.MCadastroPessoa.model.vendaLivro;

/**
 *
 * @author jairb
 */
public class CVendaLivros {
    ArrayList<vendaLivro> vendaLivros = new ArrayList<>();
    
    public void addVendaLivro(vendaLivro vl){
        vendaLivros.add(vl);
    }

    public ArrayList<vendaLivro> getVendaLivros() {
        return vendaLivros;
    }    
    
}
