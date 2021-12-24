package com.desafio.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.desafio.api.DTO.PautaDTO;
import com.desafio.api.modelo.Pauta;
import com.desafio.api.servico.PautaServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/pauta")
@Api(value = "Pauta API")
public class PautaControle {
	
	@Autowired
	private PautaServico pautaServico;
	
	@PostMapping(value="/adicionar")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Adicionar pauta")
	public ResponseEntity<Pauta> adicionar( @RequestBody PautaDTO pauta) {		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(pautaServico.criarPauta(pauta));
	}	
}
