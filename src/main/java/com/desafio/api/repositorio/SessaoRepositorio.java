package com.desafio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafio.api.modelo.Sessao;

public interface SessaoRepositorio extends JpaRepository<Sessao, Long> {
	
	@Query("SELECT s FROM Sessao s WHERE idPauta = ?1 AND tempoSessao > CURRENT_TIMESTAMP")
	Sessao buscaPautaSessaoAberta(Long idPauta);
}
