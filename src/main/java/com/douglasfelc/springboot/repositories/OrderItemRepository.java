package com.douglasfelc.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douglasfelc.springboot.entities.OrderItem;

//@Repository //OPCIONAL: Não é necessário registrar como repository no mecanismo de injeção de dependência, pois já está herdando do JpaRepository, que já está registrado como um componete do Spring 
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
