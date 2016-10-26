/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.view.console;

import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;

/**
 * Implementação da camada de visão usando o console para iteração com o usuário.
 */
public class CalcularConsoleView implements CalcularView {
    private EntradaConsole entradaConsole;

    /**
     * Construtor que monta a classe auxiliar.
     */
    public CalcularConsoleView() {
        this.entradaConsole = new EntradaConsole();
    }

    /**
     * Questiona a expressão para o usuário através do console.
     *
     * @return A expressão informada no console
     */
    public String pergunteExpressao() {
        return entradaConsole.pergunteString("Informe a expressão:", true);
    }

    /**
     * Imprime o resultado da expressão de volta para o usuário.
     *
     * @param resultado o resultado da expressão.
     */
    public void informeResultado(float resultado) {
        System.out.println(resultado);
    }

    /**
     * Imprime o erro ocorrido para o usuário.
     *
     * @param mensagem o resultado da expressão.
     */
    public void informeErro(String mensagem) {
        System.out.println(mensagem);
    }
}
