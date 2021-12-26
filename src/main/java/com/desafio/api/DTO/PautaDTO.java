package com.desafio.api.DTO;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;


public class PautaDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nomePauta;
	@NotEmpty(message="Preenchimento obrigatório")
	private String descricaoPauta;
	
	public PautaDTO(String nomePauta, String descricaoPauta) {
		super();
		this.nomePauta = nomePauta;
		this.descricaoPauta = descricaoPauta;
	}

	public PautaDTO() {
		super();
	}

	public String getNomePauta() {
		return nomePauta;
	}

	public void setNomePauta(String nomePauta) {
		this.nomePauta = nomePauta;
	}

	public String getDescricaoPauta() {
		return descricaoPauta;
	}

	public void setDescricaoPauta(String descricaoPauta) {
		this.descricaoPauta = descricaoPauta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricaoPauta, nomePauta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PautaDTO other = (PautaDTO) obj;
		return Objects.equals(descricaoPauta, other.descricaoPauta) && Objects.equals(nomePauta, other.nomePauta);
	}

	@Override
	public String toString() {
		return "PautaDTO [nomePauta=" + nomePauta + ", descricaoPauta=" + descricaoPauta + "]";
	}
	
	
	
}
