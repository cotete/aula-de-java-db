package br.com.fiap.model.main;

import br.com.fiap.model.dao.CarroDAO;
import br.com.fiap.model.factory.ConnectionFactory;
import br.com.fiap.model.dto.Carro;

import java.sql.Connection;

public class TesteCreate {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        Carro carro = new Carro();
        carro.setCor("azul");
        carro.setPlaca("JKK1903");
        carro.setDescricao("celta");

        CarroDAO carroDAO = new CarroDAO(con);
        System.out.println(carroDAO.inserir(carro));






        ConnectionFactory.fecharConexao(con);
    }
}
