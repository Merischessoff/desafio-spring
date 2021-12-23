package com.desafio.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.desafio.api.modelo.Sessao;

import com.desafio.api.servico.SessaoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/sessao")
@Api(value = "Sessao API")
public class SessaoControle {
	@Autowired
	private SessaoServico sessaoServico;
	
	@PostMapping(value="/abrir")
	@ApiOperation(value = "Abrir sessão para uma pauta")
	public ResponseEntity<Sessao> abrirSessao(
			@RequestBody Sessao sessao) {		
		return ResponseEntity.status(HttpStatus.OK)
				.body(sessaoServico.abrirSessao(sessao));
	}
}
