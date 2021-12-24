package com.desafio.api.modelo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pauta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPauta;
	private String nomePauta;
	private String descricaoPauta;
	
	public Pauta(Long idPauta, String nomePauta, String descricaoPauta) {
		super();
		this.idPauta = idPauta;
		this.nomePauta = nomePauta;
		this.descricaoPauta = descricaoPauta;
	}

	public Pauta() {
		super();
	}
	
	

	public Long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(Long idPauta) {
		this.idPauta = idPauta;
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
		return Objects.hash(descricaoPauta, idPauta, nomePauta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pauta other = (Pauta) obj;
		return Objects.equals(descricaoPauta, other.descricaoPauta) && Objects.equals(idPauta, other.idPauta)
				&& Objects.equals(nomePauta, other.nomePauta);
	}

	@Override
	public String toString() {
		return "Pauta [idPauta=" + idPauta + ", nomePauta=" + nomePauta + ", descricaoPauta=" + descricaoPauta + "]";
	}
	
	
	
	
}
