package com.desafio.api.servico;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.desafio.api.DTO.SessaoDTO;
import com.desafio.api.modelo.Sessao;
import com.desafio.api.repositorio.PautaRepositorio;
import com.desafio.api.repositorio.SessaoRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;

@RunWith(MockitoJUnitRunner.class)
public class SessaoServicoTeste {
	@InjectMocks
	private SessaoServico sessaoServico;

	@Mock
	private SessaoRepositorio sessaoRepositorio;
	
	@Mock
	private PautaRepositorio pautaRepositorio;
	
	private static Long ID_RANDOM = new Random().nextLong();
	
	@Test
	public void deveAbrirSessao() {
		when(pautaRepositorio.existsById(any(Long.class)))
			.thenReturn(true);
		
		SessaoDTO sessao = new SessaoDTO();
		sessao.setIdPauta(ID_RANDOM);
		sessao.setTempoDeterminado(30);
		
		sessaoServico.abrirSessao(sessao);
		verify(sessaoRepositorio).save(any(Sessao.class));
	}
	
	@Test
	public void erroAbrirSessaoTempoNegativo() {
		when(pautaRepositorio.existsById(any(Long.class)))
			.thenReturn(true);
		
		SessaoDTO sessao = new SessaoDTO();
		sessao.setTempoDeterminado(-1);
		
		sessaoServico.abrirSessao(sessao);
		verify(sessaoRepositorio).save(any(Sessao.class));
	}
	
	@Test(expected = ExcessaoDesafioServico.class)
	public void erroAbrirSessaoPautaNula() {
		SessaoDTO sessao = new SessaoDTO();
		sessao.setIdPauta(0);
		sessao.setTempoDeterminado(30);
		
		sessaoServico.abrirSessao(sessao);
		verify(sessaoRepositorio).save(any(Sessao.class));
	}	
	
}
