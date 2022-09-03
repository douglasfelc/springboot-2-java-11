package com.douglasfelc.springboot.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Indica uma entidade (classe relacionada a uma tabela do banco de dados) - modelo relacional
@Table(name = "tb_user") //Nome da tabela no banco de dados

/**
 * Classe de usuário
 * Serializable: necessário para enviar objetos pela rede, salvar no disco, ou comunicar de uma JVM com outra.
 */
public class User implements Serializable {
	/* Como a classe é Serializable, é necessário um número de série.
	 * Inicialmente você pode definir como 1L (número padrão), e depois,  
	 * se você fizer alguma alteração estrutural incompatível com versões anteriores, 
	 * você mudará o serialVersionUID para 2L. Em uma outra alteração, mudará para 3L e assim por diante. 
	 * Obviamente, se a alteração for pequena e nenhuma incompatibilidade for introduzida, você não deve alterar o serialVersionUID. */
	private static final long serialVersionUID = 1L;

	//Atributos básicos
	@Id //Define a chave primária
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //Autoincrementável
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	
	//Construtores
	public User() {
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	
	//hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
