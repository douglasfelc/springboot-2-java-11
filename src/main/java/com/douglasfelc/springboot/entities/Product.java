package com.douglasfelc.springboot.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity //Indica uma entidade (classe relacionada a uma tabela do banco de dados) - modelo relacional
@Table(name = "tb_product") //Nome da tabela no banco de dados
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id //Define a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementável
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(
		name = "tb_product_category", 
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id")
	) //Tabela que relaciona o muitos para muitos, e chaves estrangeiras para associação das tabelas, onde joinColumns é para tabela desta classe e inverseJoinColumns é para associar a outra tabela
	//Já instanciado para garantir que a coleção não comece nula, e sim vazia.
	//Foi usado o HashSet (classe correspondente), pois o Set é uma interface e não pode ser instanciado
	private Set<Category> categories = new HashSet<>(); //Set = Conjunto; para garantir que não vou ter um produto com mais uma ocorrência da mesma categoria.
	
	public Product() {
	}

	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
}
