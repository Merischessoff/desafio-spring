package com.desafio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafio.api.modelo.Sessao;

public interface SessaoRepositorio extends JpaRepository<Sessao, Long> {
	
}
