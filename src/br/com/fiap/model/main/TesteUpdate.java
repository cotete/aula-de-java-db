package br.com.fiap.model.main;

import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.factory.ConnectionFactory;
import br.com.fiap.model.dto.Carro;

import java.sql.Connection;

public class TesteUpdate {
    public static void main(String[] args) {

        Connection con = ConnectionFactory.abrirConexao();

        Carro carro = new Carro();
        carro.setPlaca("JKK1900");
        carro.setCor("Prata");
        carro.setDescricao("Nissan March");

        CarroDAO dao = new CarroDAO(con);

        System.out.println(dao.alterar(carro));

        ConnectionFactory.fecharConexao(con);
    }
}
