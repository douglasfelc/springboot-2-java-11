package com.douglasfelc.springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.douglasfelc.springboot.entities.Category;
import com.douglasfelc.springboot.entities.Order;
import com.douglasfelc.springboot.entities.OrderItem;
import com.douglasfelc.springboot.entities.Product;
import com.douglasfelc.springboot.entities.User;
import com.douglasfelc.springboot.entities.enums.OrderStatus;
import com.douglasfelc.springboot.repositories.CategoryRepository;
import com.douglasfelc.springboot.repositories.OrderItemRepository;
import com.douglasfelc.springboot.repositories.OrderRepository;
import com.douglasfelc.springboot.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {

		//Instanciado objetos tipo Category		
		Category cat1 = new Category(null, "Eletrônicos");
		Category cat2 = new Category(null, "Livros");
		Category cat3 = new Category(null, "Computadores");
		
		//Salva as categorias no banco de dados
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));


		//Instanciado objetos tipo Product		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		//Salva os produtos no banco de dados
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		
		//Associação entre produtos e categorias
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		//Salva todos os produtos com as associações
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		
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
		
		
		//Instanciando os itens do pedidos
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		//Salva os itens dos pedidos
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}

}
