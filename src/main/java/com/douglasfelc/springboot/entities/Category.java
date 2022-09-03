package com.douglasfelc.springboot.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
	/* Como a classe é Serializable, é necessário um número de série.
	 * Inicialmente você pode definir como 1L (número padrão), e depois,  
	 * se você fizer alguma alteração estrutural incompatível com versões anteriores, 
	 * você mudará o serialVersionUID para 2L. Em uma outra alteração, mudará para 3L e assim por diante. 
	 * Obviamente, se a alteração for pequena e nenhuma incompatibilidade for introduzida, você não deve alterar o serialVersionUID. */
	private static final long serialVersionUID = 1L;

	//Atributos básicos
	@Id //Define a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementável
	private Long id;
	private String name;
	
	@Transient //Para o JPA não interpetrar {PROVISÓRIO}
	private Set<Product> products = new HashSet<>();
	
	public Category() {
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	public Set<Product> getProducts() {
		return products;
	}
	
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

}
