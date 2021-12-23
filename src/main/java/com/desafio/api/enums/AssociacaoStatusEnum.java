package com.desafio.api.enums;

public enum AssociacaoStatusEnum {
	
	ASSOCIACAO_COM_VOTO("ABLE_TO_VOTE"), 
	SEM_ASSOCIACAO_VOTO("UNABLE_TO_VOTE");	
	private final String value;
	
	AssociacaoStatusEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
