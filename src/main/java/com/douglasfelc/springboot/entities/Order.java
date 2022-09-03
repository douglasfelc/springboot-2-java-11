package com.douglasfelc.springboot.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //Indica uma entidade (classe relacionada a uma tabela do banco de dados) - modelo relacional
@Table(name = "tb_order") //Nome da tabela no banco de dados

/**
 * Classe de pedidos
 * Serializable: necessário para enviar objetos pela rede, salvar no disco, ou comunicar de uma JVM com outra.
 */
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id //Define a chave primária
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //Autoincrementável
	private Long id;
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	
	public Order() {
	}
	
	public Order(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
