/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.view;

/**
 * Interface de comunicação com o usuário. Expõe os métodos para iteração.
 */
public interface CalcularView {

    /**
     * Usado para questionar o usuário por uma expressão e realizar a leitura.
     *
     * @return A expressão informada pelo usuário.
     */
    String pergunteExpressao();

    /**
     * Usado para informar o resultado da expressão informada de volta para o usuário.
     *
     * @param resultado o resultado da expressão.
     */
    void informeResultado(float resultado);

    /**
     * Usado para informa o usuário de um erro ocorrido ao processar a expressão;
     *
     * @param mensagem A mensagem do erro.
     */
    void informeErro(String mensagem);
}
