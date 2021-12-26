package com.desafio.api.DTO;

import javax.validation.constraints.NotEmpty;

public class SessaoDTO {
	@NotEmpty(message="Preenchimento obrigatório")
	private int tempoDeterminado;
	@NotEmpty(message="Preenchimento obrigatório")
	private long idPauta;
	
	public SessaoDTO(int tempoDeterminado, long idPauta) {
		super();
		this.tempoDeterminado = tempoDeterminado;
		this.idPauta = idPauta;
	}

	
	public SessaoDTO() {
		super();
	}


	public int getTempoDeterminado() {
		return tempoDeterminado;
	}

	public void setTempoDeterminado(int tempoDeterminado) {
		this.tempoDeterminado = tempoDeterminado;
	}

	public long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(long idPauta) {
		this.idPauta = idPauta;
	}
	
	
	
	
	
}
