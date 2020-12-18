package com.navita.algoritmo;

import com.navita.algoritmo.service.AlgoritmoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlgoritmoApplicationTests {
	@Autowired
	private AlgoritmoService algoritmoService;

	@Test
	public void retornarIrmaoMaior() {
		int numeroIrmao = 535;
		int resultado = algoritmoService.getMaiorNumeroIrmao(numeroIrmao);

		Assertions.assertEquals(553,resultado);
	}

	@Test
	public void retornarIrmaoInvalido(){
		int nummeroIrmao = 100000000;
		int resultado = algoritmoService.getMaiorNumeroIrmao(nummeroIrmao);

		Assertions.assertEquals(-1,resultado);
	}

}
