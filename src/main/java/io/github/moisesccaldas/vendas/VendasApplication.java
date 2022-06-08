package io.github.moisesccaldas.vendas;

import static java.lang.System.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.moisesccaldas.vendas.domain.entity.Cliente;
import io.github.moisesccaldas.vendas.domain.repository.ClienteRepository;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository rep) {
		return args -> {
			rep.save(new Cliente(null, "Moises"));
			rep.save(new Cliente(null, "Aritane"));
			rep.save(new Cliente(null, "Maylane"));
			
			List<Cliente> clientes = rep.list();
			clientes.forEach(out::println);
			
			out.println(rep.update(new Cliente(2, "Melissa")));
			rep.delete(3);

			clientes = rep.list();
			clientes.forEach(out::println);
			
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
