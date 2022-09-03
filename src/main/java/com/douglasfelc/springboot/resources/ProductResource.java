package com.douglasfelc.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglasfelc.springboot.entities.Product;
import com.douglasfelc.springboot.services.ProductService;

@RestController //Implementado por um controlador REST
@RequestMapping(value = "/products") //Caminho para acessar recurso

/**
 * Recurso web correspondente a entidade Product
 */
public class ProductResource {
	
	@Autowired //Para o spring fazer a injeção de dependência
	//Declarar dependência do ProductService
	private ProductService service;

	@GetMapping //Indicar que o método responde tipo GET do HTTP
	/* Método para retorna todos usuários
	 * ResponseEntity: Tipo específico do Spring para retornar respostas de requisições web
	 * Difinido o tipo da resposta a classe Product e o nome do método findAll()
	 * @return resposta com sucesso, e no corpo a lista de todos usuários solicitada ao ProductSerice */
	public ResponseEntity<List<Product>> findAll() {
		//Carrego uma lista de Product com o retorno da operação service.findAll() - solicitação de busca de todos os usuários
		List<Product> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}") //Tipo GET do HTTP esperando um código
	/* Método para retornar usuário por ID
	 * @param id = código do usuário
	 * @return Retorna os dados do usuário como objeto */
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}