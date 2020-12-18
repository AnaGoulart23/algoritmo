/**
 *
 */
package com.navita.algoritmo.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * @author Ana Márcia
 *
 */
@Service
public class AlgoritmoService {
    private final int IRMAO_MAIOR_INVALIDO = -1;
    private final String NUMERO_INVALIDO = "Digite um número Válido!";

    public Integer getMaiorNumeroIrmao(String valor) {
    	if(valor.matches("[0-9]")) {
    		throw new RuntimeException(NUMERO_INVALIDO);
    	}
        List<Integer> numeroConvertidoEmList = transformarNumeroEmListaDeInt(Integer.parseInt(valor));
        int irmaoMaior = getIrmaoMaior(numeroConvertidoEmList);
        if (irmaoMaiorInvalido(irmaoMaior)) {
            return IRMAO_MAIOR_INVALIDO;
        }
        return irmaoMaior;
    }

    private boolean irmaoMaiorInvalido(int irmaoMaior) {
        return irmaoMaior >= 100000000;
    }

    private int getIrmaoMaior(List<Integer> numeroConvertidoEmList) {
        return Integer.parseInt(numeroConvertidoEmList.stream()
                .sorted(Comparator.reverseOrder())
                .map(Object::toString)
                .collect(Collectors.joining()));
    }

    private List<Integer> transformarNumeroEmListaDeInt(final Integer numero) {
        return createListIntegerFromCharVector(convertNumeroToCharVector(numero));
    }

    private List<Integer> createListIntegerFromCharVector(final char[] charVector) {
        List<Integer> numeroInts = new ArrayList<>();
        for (char c : charVector) {
            numeroInts.add(Character.getNumericValue(c));
        }
        return numeroInts;
    }

    private char[] convertNumeroToCharVector(Integer numero) {
        return numero.toString().toCharArray();
    }
}
