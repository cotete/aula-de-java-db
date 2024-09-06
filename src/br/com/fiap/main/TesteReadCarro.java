package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

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
