package com.desafio.api.DTO;

public class VotoSessaoDTO {
	
	private String cpfAssociado;
	private int escolha;
	private Long idSessao;
	
	public VotoSessaoDTO(String cpfAssociado, int escolha, Long idSessao) {
		super();
		this.cpfAssociado = cpfAssociado;
		this.escolha = escolha;
		this.idSessao = idSessao;
	}

	public VotoSessaoDTO() {
		super();
	}

	public String getCpfAssociado() {
		return cpfAssociado;
	}

	public void setCpfAssociado(String cpfAssociado) {
		this.cpfAssociado = cpfAssociado;
	}

	public int getEscolha() {
		return escolha;
	}

	public void setEscolha(int escolha) {
		this.escolha = escolha;
	}

	public Long getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(Long idSessao) {
		this.idSessao = idSessao;
	}
	

	
	
	
}
