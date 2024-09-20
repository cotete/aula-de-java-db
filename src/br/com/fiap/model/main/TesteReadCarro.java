package br.com.fiap.model.main;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.factory.ConnectionFactory;
import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;

public class TesteReadCarro {
    public static void main(String[] args) {

        Connection con = ConnectionFactory.abrirConexao();

        ClienteDAO clienteDAO = new ClienteDAO(con);

        Cliente pesquisa = new Cliente();
        pesquisa.setPlaca("JKK1900");

        Cliente resultado = clienteDAO.listarEspecifico(pesquisa);

        if (resultado !=null){
            System.out.println(resultado.getIdCliente());
            System.out.println(resultado.getNomeCliente());
            System.out.println(resultado.getPlaca());
            System.out.println("--------------------");
        }

        ConnectionFactory.fecharConexao(con);


    }
}
