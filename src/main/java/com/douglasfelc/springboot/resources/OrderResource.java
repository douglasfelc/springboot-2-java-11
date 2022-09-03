package com.douglasfelc.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglasfelc.springboot.entities.Order;
import com.douglasfelc.springboot.services.OrderService;

@RestController //Implementado por um controlador REST
@RequestMapping(value = "/orders") //Caminho para acessar recurso

/**
 * Recurso web correspondente a entidade Order
 */
public class OrderResource {
	
	@Autowired //Para o spring fazer a injeção de dependência
	//Declarar dependência do OrderService
	private OrderService service;

	@GetMapping //Indicar que o método responde tipo GET do HTTP
	/* Método para retorna todos usuários
	 * ResponseEntity: Tipo específico do Spring para retornar respostas de requisições web
	 * Difinido o tipo da resposta a classe Order e o nome do método findAll()
	 * @return resposta com sucesso, e no corpo a lista de todos usuários solicitada ao OrderSerice */
	public ResponseEntity<List<Order>> findAll() {
		//Carrego uma lista de Order com o retorno da operação service.findAll() - solicitação de busca de todos os usuários
		List<Order> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //Tipo GET do HTTP esperando um código
	/* Método para retornar usuário por ID
	 * @param id = código do usuário
	 * @return Retorna os dados do usuário como objeto */
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}