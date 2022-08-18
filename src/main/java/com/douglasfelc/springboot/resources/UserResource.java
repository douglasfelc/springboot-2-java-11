package com.douglasfelc.springboot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglasfelc.springboot.entities.User;

@RestController //Implementado por um controlador REST
@RequestMapping(value = "/users") //Caminho para acessar recurso

/**
 * Recurso web correspondente a entidade User
 */
public class UserResource {

	@GetMapping //Indicar que o método responde tipo GET do HTTP
	/**
	 * Tipo específico do Spring para retornar respostas de requisições web
	 * Difinido o tipo da resposta a classe User e o nome do método findAll()
	 * @return resposta com sucesso, e o usuário u no corpo da resposta
	 */
	public ResponseEntity<User> findAll() {
		//Instanciar um objeto User somente para teste
		User u = new User(1L, "Douglas", "douglas@onlinebr.net", "49999881111", "123456");

		return ResponseEntity.ok().body(u);
	}
}