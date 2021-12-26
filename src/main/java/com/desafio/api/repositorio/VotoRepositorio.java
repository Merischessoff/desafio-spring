package com.desafio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.desafio.api.DTO.VotoDTO;
import com.desafio.api.modelo.Voto;

public interface VotoRepositorio extends JpaRepository<Voto, Long> {
	@Query(value= "SELECT NEW com.desafio.api.DTO.VotoDTO(s, "
			+ "SUM(CASE WHEN ESCOLHA = 1 THEN 1 ELSE 0 END) AS contagemVotosSim, "
			+ "SUM(CASE WHEN ESCOLHA = 0 THEN 1 ELSE 0 END) AS contagemVotosNao) "
			+ "FROM Voto v "
			+ "INNER JOIN v.sessao s "
			+ "WHERE ID_SESSAO_VOTO = ?1 "
			+ "GROUP BY ID_SESSAO_VOTO ")
	VotoDTO resultadoVotos(Long id);

}
