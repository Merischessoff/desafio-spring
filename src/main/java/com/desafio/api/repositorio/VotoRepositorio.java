package com.desafio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafio.api.modelo.Voto;

public interface VotoRepositorio extends JpaRepository<Voto, Long> {

	@Query("SELECT v FROM Voto v WHERE idSessao = ?1 AND cpfAssociado = ?2 ")
	Voto buscaAssociacaoVoto(Long idSessao, String cpfAssociado);
	
	@Query(value= "SELECT NEW com.desafio.api.modelo.Voto(s, "
			+ "SUM(CASE WHEN escolha = 'Y' THEN 1 ELSE 0 END) AS votosSim, "
			+ "SUM(CASE WHEN escolha = 'N' THEN 1 ELSE 0 END) AS VotosNao) "
			+ "FROM Voto v "
			+ "INNER JOIN v.sessao s "
			+ "WHERE idSessao = ?1 "
			+ "GROUP BY idSessao ")
	Voto resultadoVotos(Long idSessao);

}
