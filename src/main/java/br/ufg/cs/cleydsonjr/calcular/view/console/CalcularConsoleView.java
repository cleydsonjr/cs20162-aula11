/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.view.console;

import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Implementação da camada de visão usando o console para iteração com o usuário.
 */
public class CalcularConsoleView implements CalcularView {
    /**
     * Implementação auxiliar para abstrair a comunicação com o usuário.
     */
    private EntradaConsole entradaConsole;

    /**
     * Saída padrão para iteração com o usuário.
     */
    private PrintStream saida;

    /**
     * Construtor que monta a classe auxiliar.
     *
     * @param entradaPadrao O InputStream padrão de entrada.
     * @param saidaPadrao   O PrintStream padrão de saída.
     */
    public CalcularConsoleView(final InputStream entradaPadrao, final PrintStream saidaPadrao) {
        this.entradaConsole = new EntradaConsole(entradaPadrao, saidaPadrao);
        this.saida = saidaPadrao;
    }

    /**
     * Questiona a expressão para o usuário através do console.
     *
     * @return A expressão informada no console
     */
    public final String pergunteExpressao() {
        return entradaConsole.pergunteString("Informe a expressão:", true);
    }

    /**
     * Imprime o resultado da expressão de volta para o usuário.
     *
     * @param resultado o resultado da expressão.
     */
    public final void informeResultado(final float resultado) {
        saida.println(resultado);
    }

    /**
     * Imprime o erro ocorrido para o usuário.
     *
     * @param mensagem o resultado da expressão.
     */
    public final void informeErro(final String mensagem) {
        saida.println(mensagem);
    }
}
