/**
 *
 */
package com.navita.algoritmo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * @author Ana Márcia
 *
 */
@Service
public class AlgoritmoService {
    private static final int IRMAO_MAIOR_INVALIDO = -1;

    public Integer getMaiorNumeroIrmao(final Integer numero) {
        List<Integer> numeroConvertidoEmList = transformarNumeroEmListaDeInt(numero);
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
