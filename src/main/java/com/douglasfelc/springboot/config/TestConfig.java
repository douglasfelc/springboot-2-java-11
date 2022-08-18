package com.douglasfelc.springboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.douglasfelc.springboot.entities.User;
import com.douglasfelc.springboot.repositories.UserRepository;

@Configuration //Indicar para o Spring que é uma classe específica de configuração
@Profile("test") //Indica que é uma classe específica do perfil de teste

/**
 * Classe de configuração específica para o perfil de teste
 * CommandLineRunner: para acessar o método run, 
 *  a fim de executar quando a aplicação for iniciada
 */
public class TestConfig implements CommandLineRunner {

	@Autowired //Para o Spring resolver a dependência e associar uma instância de UserRepository
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//Instanciado objetos tipo User
		User u1 = new User(null, "Jennifer Gonzalez", "gonzalez@gmail.com", "49999881112", "123456");
		User u2 = new User(null, "Fabrício Fernandez", "fernandez@gmail.com", "49999881113", "123456");
		
		//Salvar os objetos no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
