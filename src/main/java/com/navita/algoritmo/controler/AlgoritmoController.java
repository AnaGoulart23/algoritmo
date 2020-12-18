/**
 * 
 */
package com.navita.algoritmo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navita.algoritmo.service.AlgoritmoService;

/**
 * @author Ana Márcia
 *
 */
@RestController
@RequestMapping("algoritmo")
public class AlgoritmoController {
	@Autowired
	private AlgoritmoService algoritmoService;
	
	@GetMapping("{valor}")
	public ResponseEntity<?> numerosIrmaos(@PathVariable("valor") String valor){
		return ResponseEntity.ok(algoritmoService.getMaiorNumeroIrmao(valor));
	}
}
