package com.douglasfelc.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglasfelc.springboot.entities.User;
import com.douglasfelc.springboot.repositories.UserRepository;

@Service //Registrar um serviço no mecanismo de injeção de dependência
/**
 * Classe da camada de serviço do User
 */
public class UserService {

	@Autowired //Para o spring fazer a injeção de dependência
	//Declarar dependência do UserRepository
	private UserRepository repository;
	
	/* Método para retorna todos usuários
	 * @return Retorna o resultado da solicitação de buscar todos feita para o repository */
	public List<User> findAll() {
		return repository.findAll();
	}
	
	/* Método para buscar usuário por ID
	 * @param id = código do usuário
	 * @return Retorna o resultado da solicitação ao repository do retorno do User por ID */
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
