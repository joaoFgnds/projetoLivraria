/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.MCadastroPessoa.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.com.senactech.MCadastroPessoa.model.cliente;
import br.com.senactech.MCadastroPessoa.conexao.conexao;

/**
 *
 * @author faria
 */
public class ClienteDAO {

    public void cadastrarClienteCPF(cliente cVO) throws SQLException {
        //Busca conexao com o BD
        Connection con = conexao.getConexao();
        //cria um objeto stat responsavel por enviar os comandos sql do ajva 
        // para serem executados dentro do bd 
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into pessoa values (null, ' " + cVO.getNomeCliente() + " ' , ' "
                    + cVO.getEndereco() + " ' , ' " + cVO.getTelefone() + " ' , ' "
                    + cVO.getCpf() + " ' ," + "null" + ")";
            //vamos executar o comando construido na string sql
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Pessoa ! \n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
        //PARA CADASTRAR CLIENTE COM O CPF 
    }

    public void cadastrarClienteCNPJ(cliente cVO) throws SQLException {
        //Busca conexao com o BD
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        try {
            //sql vai receber o comando SQL
            String sql;
            sql = "insert into pessoa values (null, ' " + cVO.getNomeCliente() + " ' , ' "
                    + cVO.getEndereco() + " ' , ' " + cVO.getTelefone() + " ' , ' "
                    + "null" + ", ' " + cVO.getCnpj() + " ')";
            //vamos executar o comando construido na string sql
            stat.execute(sql);

            //}
        } catch (SQLException e) {
            throw new SQLException("Erro ao inserir Pessoa ! \n" + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
        //PARA CADASTRAR CLIENTE COM O CNPJ   
    }

    public ArrayList<cliente> buscarClientes() throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        try {
            String sql;
            sql = "select * from pessoa";
            //atribuo ao rs o resultado da execução da query no banco
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                cliente c = new cliente();
                //lado do java |x| lado do banco
                c.setIdCliente(rs.getInt("idcliente"));
                c.setNomeCliente(rs.getString("nome"));
                c.setEndereco(rs.getString("enderecoCompleto"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
                c.setCnpj(rs.getString("cnpj"));
                clientes.add(c);
            }
            return clientes;
        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar Pessoas! \n " + e.getMessage());
        } finally {
            stat.close();
            con.close();
        }
    }

    public boolean vercliente(int id) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        boolean vercliente = false;

        try {
            for (cliente cli : buscarClientes()) {
                if (cli.getIdCliente() == id) {
                    vercliente = true;
                    break;
                }
            }
            return vercliente;
        } catch (SQLException e) {
            throw new SQLException("Cliente com este id nao existe ");
        }
    }

    public boolean verCNPJ(String cnpj) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();
        boolean verCNPJ = false;

        try {
            String sql;
            sql = "select cnpj from cliente where cnpj = ' " + cnpj + " ' ";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verCNPJ = rs.wasNull();
            }
        } catch (SQLException e) {
            throw new SQLException("Pessoa com este cnpj nao existe. \n "
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }

        return verCNPJ;
    }

    public void deletarcliente(int id) throws SQLException {
        Connection con = conexao.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql;
            sql = "delete from pessoa where idPessoa = " + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Erro ao deletar Pessoa. \n"
                    + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    public cliente pesquisaCliente (int cpfCNPJ, String pesq) throws SQLException {
        cliente c = new cliente();
         try {
            switch (cpfCNPJ) {
                case 1:
                    for (cliente cli : buscarClientes()) {
                        if (cli.getCpf() != null && cli.getCpf().equals(pesq)) {
                            c = cli;
                            break;
                        }
                    }
                    break;
                case 2:
                    for (cliente cli : buscarClientes()) {
                        if (cli.getCnpj() != null && cli.getCnpj().equals(pesq)) {
                            c = cli;
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Cliente não Encontrado!!!");
                    break;
            }
            return c;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    }


