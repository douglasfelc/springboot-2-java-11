package com.douglasfelc.springboot.entities.enums;

public enum OrderStatus {

	/* NOME(codigo) */
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	
	/**
	 * Códigos abaixos são necessários para utilização de código fixo para o enumerado
	 */
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		//Percorre todos os valores deste enumerado
		for (OrderStatus value : OrderStatus.values()) {
			//Faz a comparação para encontrar 
			if (value.getCode() == code) {
				//retorna o valor(nome) do enumerado
				return value;
			}
		}
		//Se não encontrou nenhum código, lança uma exceção
		throw new IllegalArgumentException("Código inválido do status do pedido");
	}
}
