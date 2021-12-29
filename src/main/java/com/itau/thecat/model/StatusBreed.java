package com.itau.thecat.model;

public enum StatusBreed {
	PENDENTE("Pendente"), RECEBIDO("Recebido"),CANCELADO("Cancelado");

	private String descricao;

	private StatusBreed(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
