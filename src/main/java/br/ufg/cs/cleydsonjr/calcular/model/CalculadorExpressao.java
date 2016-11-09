/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.model;

/**
 * Interface que expõe a regra de negócio do programa.
 */
@FunctionalInterface
public interface CalculadorExpressao {

    /**
     * Expõe a lógica para calculo do valor de uma expressão informada.
     *
     * @param textoExpressao A expressão para analisar e calcular.
     * @return O valor da expressão calculado
     * @throws IllegalArgumentException Caso a expressão seja inválida
     */
    float calculeValor(String textoExpressao);
}
