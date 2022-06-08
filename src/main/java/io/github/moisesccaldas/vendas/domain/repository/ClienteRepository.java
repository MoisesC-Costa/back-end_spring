package io.github.moisesccaldas.vendas.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.github.moisesccaldas.vendas.domain.entity.Cliente;

@Repository
public class ClienteRepository {
	private static final String INSERT = "INSERT INTO CLIENTES(NOME) VALUES (?)";
	private static final String LIST = "SELECT * FROM CLIENTES";
	private static final String LOAD = "SELECT * FROM CLIENTES WHERE ID = ?";
	private static final String UPDATE = "UPDATE CLIENTES SET NOME = ? WHERE ID = ?";
	private static final String DELETE = "DELETE FROM CLIENTES WHERE ID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Cliente save(Cliente cliente) {
		jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
		return cliente;
	}

	public List<Cliente> list(){
		return jdbcTemplate.query(LIST, (resultSet, i) -> {
			return new Cliente(resultSet.getInt("ID"), resultSet.getString("NOME"));
		});
	}

	public Cliente load(Integer id) {
		return jdbcTemplate.queryForObject(LOAD,
				(resultSet, i) -> {
					return new Cliente(resultSet.getInt("ID"), resultSet.getString("NOME"));
				},
				id);
	}
	
	public Cliente update(Cliente cliente) {
		jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
		return cliente;
	}
	
	public void delete(Integer id) {
		jdbcTemplate.update(DELETE, new Object[] {id});
	}

}
