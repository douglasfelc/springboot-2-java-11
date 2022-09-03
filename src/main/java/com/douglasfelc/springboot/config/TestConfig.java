package com.douglasfelc.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.douglasfelc.springboot.entities.Category;
import com.douglasfelc.springboot.entities.Order;
import com.douglasfelc.springboot.entities.User;
import com.douglasfelc.springboot.entities.enums.OrderStatus;
import com.douglasfelc.springboot.repositories.CategoryRepository;
import com.douglasfelc.springboot.repositories.OrderRepository;
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
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {

		//Instanciado objetos tipo Category		
		Category cat1 = new Category(null, "Eletrônicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores");
		
		//Salva as categorias no banco de dados
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));


		//Instanciado objetos tipo User
		User u1 = new User(null, "Jennifer Gonzalez", "gonzalez@gmail.com", "49999881112", "123456");
		User u2 = new User(null, "Fabrício Fernandez", "fernandez@gmail.com", "49999881113", "123456");

		//Salva os usuários no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));

		
		//Instanciado objetos tipo Order
		Order o1 = new Order(null, Instant.parse("2022-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		//Salva os pedidos no banco de dados
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
