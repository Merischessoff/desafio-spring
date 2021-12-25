package com.desafio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.api.modelo.Pauta;

public interface PautaRepositorio extends JpaRepository<Pauta, Long> {

}
