package com.douglasfelc.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglasfelc.springboot.entities.Order;
import com.douglasfelc.springboot.repositories.OrderRepository;

@Service //Registrar um serviço no mecanismo de injeção de dependência
/**
 * Classe da camada de serviço do Order
 */
public class OrderService {

	@Autowired //Para o spring fazer a injeção de dependência
	//Declarar dependência do OrderRepository
	private OrderRepository repository;
	
	/* Método para retorna todos usuários
	 * @return Retorna o resultado da solicitação de buscar todos feita para o repository */
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	/* Método para buscar usuário por ID
	 * @param id = código do usuário
	 * @return Retorna o resultado da solicitação ao repository do retorno do Order por ID */
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
