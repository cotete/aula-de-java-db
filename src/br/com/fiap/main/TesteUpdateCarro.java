package br.com.fiap.main;

import br.com.fiap.dao.CarroDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Carro;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;

public class TesteUpdateCarro {
    public static void main(String[] args) {

        Connection con = ConnectionFactory.abrirConexao();

        Cliente cliente = new Cliente();
        cliente.setPlaca("JKK1900");
        cliente.setNomeCliente("Jorge");
        cliente.setIdCliente(1);

        ClienteDAO dao = new ClienteDAO(con);

        System.out.println(dao.alterar(cliente));

        ConnectionFactory.fecharConexao(con);
    }
}
