package com.desafio.api.DTO;

public class SessaoDTO {
	private int tempoDeterminado;
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
