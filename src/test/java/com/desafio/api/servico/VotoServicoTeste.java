package com.desafio.api.servico;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.desafio.api.DTO.VotoSessaoDTO;
import com.desafio.api.modelo.Voto;
import com.desafio.api.repositorio.PautaRepositorio;
import com.desafio.api.repositorio.SessaoRepositorio;
import com.desafio.api.repositorio.VotoRepositorio;
import com.desafio.api.servico.excessao.ExcessaoDesafioServico;

@RunWith(MockitoJUnitRunner.class)
public class VotoServicoTeste {
	
	@InjectMocks
	private VotoServico votoServico;
	
	@InjectMocks
	private PautaServico servicoPauta;

	@InjectMocks
	private SessaoServico sessaoServico;
	
	@Mock
	private VotoRepositorio votoRepositorio;
	
	@Mock
	private SessaoRepositorio sessaoRepositorio;
	
	@Mock
	private PautaRepositorio pautaRepositorio;
	
	private static Long ID_RANDOM = new Random().nextLong();
	
	
	@Test
	public void deveVotar() {
		when(pautaRepositorio.existsById(any(Long.class)))
		.thenReturn(true);
		
		when(sessaoRepositorio.existsById(any(Long.class)))
		.thenReturn(true);
		
		VotoSessaoDTO voto = new VotoSessaoDTO();
		voto.setCpfAssociado("15153204057");
		voto.setEscolha(1);
		voto.setIdSessao(ID_RANDOM);
		votoServico.votar(voto);
		verify(votoRepositorio).save(any(Voto.class));
	}
	
	@Test(expected = ExcessaoDesafioServico.class)
	public void erroVotarSessaoNula() {	
		VotoSessaoDTO voto = new VotoSessaoDTO();
		voto.setCpfAssociado("15153204057");
		voto.setEscolha(1);
		voto.setIdSessao(null);
		votoServico.votar(voto);
		verify(votoRepositorio, never()).save(any(Voto.class));
	}
	
	
	@Test(expected = ExcessaoDesafioServico.class)
	public void erroVotarEscolha() {	
		VotoSessaoDTO voto = new VotoSessaoDTO();
		voto.setCpfAssociado("15153204057");
		voto.setEscolha(2);
		voto.setIdSessao(ID_RANDOM);
		votoServico.votar(voto);
		verify(votoRepositorio, never()).save(any(Voto.class));
	}
	
	@Test(expected = ExcessaoDesafioServico.class)
	public void erroVotarAssociadoVazio() {	
		VotoSessaoDTO voto = new VotoSessaoDTO();
		voto.setCpfAssociado("");
		voto.setEscolha(1);
		voto.setIdSessao(ID_RANDOM);
		votoServico.votar(voto);
		verify(votoRepositorio, never()).save(any(Voto.class));
	}
	
	@Test(expected = ExcessaoDesafioServico.class)
	public void erroVotarSemSessao() {
		VotoSessaoDTO voto = new VotoSessaoDTO();
		voto.setCpfAssociado("");
		voto.setEscolha(1);
		votoServico.votar(voto);
		verify(votoRepositorio, never()).save(any(Voto.class));
	}
}
