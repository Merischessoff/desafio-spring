package com.desafio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DesafioAplicacao {
	private static Logger logger = LoggerFactory.getLogger(DesafioAplicacao.class);
	public static void main(String[] args) {
		SpringApplication.run(DesafioAplicacao.class, args);
		logger.info("Inicio da API Desafio");
	}

}
