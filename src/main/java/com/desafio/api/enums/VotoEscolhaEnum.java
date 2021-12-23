package com.desafio.api.enums;

public enum VotoEscolhaEnum {
	
	ESCOLHA_SIM("SIM"), 
	ESCOLHA_NAO("NAO");	
	private final String value;
	
	VotoEscolhaEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}