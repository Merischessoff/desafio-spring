package com.desafio.api.servico;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.desafio.api.DTO.PautaDTO;
import com.desafio.api.modelo.Pauta;
import com.desafio.api.repositorio.PautaRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;

@RunWith(MockitoJUnitRunner.class)
public class PautaServicoTeste {
	
	@InjectMocks
	private PautaServico servicoPauta;

	@Mock
	private PautaRepositorio pautaRepositorio;
	
	@Test
	public void deveCriarPauta() {
		PautaDTO pauta = new PautaDTO("nome pauta", "descricao pauta");
		servicoPauta.criarPauta(pauta);
		verify(pautaRepositorio).save(any(Pauta.class));
	}
	
	@Test(expected = ExcessaoDesafioServico.class)
	public void erroNomePautaNullo() {		
		PautaDTO pauta = new PautaDTO(null,"descricao pauta");
		servicoPauta.criarPauta(pauta);
		verify(pautaRepositorio, never()).save(any(Pauta.class));
	}
	
	@Test(expected = ExcessaoDesafioServico.class)
	public void erroNomeVazio() {	
		PautaDTO pauta = new PautaDTO("","");
		servicoPauta.criarPauta(pauta);
		verify(pautaRepositorio, never()).save(any(Pauta.class));
	}
	
	
	
}
