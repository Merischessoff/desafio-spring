package com.desafio.api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.desafio.api.DTO.VotoDTO;
import com.desafio.api.DTO.VotoSessaoDTO;
import com.desafio.api.modelo.Voto;
import com.desafio.api.servico.VotoServico;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/voto")
@Api(value = "Voto API")
public class VotoControle {
	@Autowired
	private VotoServico votoServico;
	
	@PostMapping(value="/votoSessao")
	@ApiOperation(value = "Obtém o voto de um associado em uma sessão")
	public ResponseEntity<Voto> votoSessaoPauta(
			@RequestBody VotoSessaoDTO voto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(votoServico.votar(voto));
	}
	
	@GetMapping(value="/resultadoSessao")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Resultado da votação da sessão")
	public VotoDTO resultadoSessao(
		@RequestParam(required=true) Long id) {
		return votoServico.resultadoVotos(id);
	}
}
