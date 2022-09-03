package com.douglasfelc.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglasfelc.springboot.entities.Category;
import com.douglasfelc.springboot.repositories.CategoryRepository;

@Service //Registrar um serviço no mecanismo de injeção de dependência
/**
 * Classe da camada de serviço do Category
 */
public class CategoryService {

	@Autowired //Para o spring fazer a injeção de dependência
	//Declarar dependência do CategoryRepository
	private CategoryRepository repository;
	
	/* Método para retorna todos usuários
	 * @return Retorna o resultado da solicitação de buscar todos feita para o repository */
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	/* Método para buscar usuário por ID
	 * @param id = código do usuário
	 * @return Retorna o resultado da solicitação ao repository do retorno do Category por ID */
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
}
