/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.controller;

import br.ufg.cs.cleydsonjr.calcular.model.CalculadorExpressao;
import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;

/**
 * Controller da aplicação. Contendo o fluxo de execução do projeto.
 */
public class CalcularController {
    /**
     * Instância do calculador de expressões.
     */
    private CalculadorExpressao calculadorExpressao;

    /**
     * Instância do view para comunicação com o usuário.
     */
    private CalcularView calcularView;

    /**
     * Construtor que recebe as dependências de lógica e de interface.
     *
     * @param calculadorExpressaoPadrao Implementação da regra de negócio.
     * @param calcularViewPadrao        Implementação da interface com o usuário.
     */
    public CalcularController(final CalculadorExpressao calculadorExpressaoPadrao,
                              final CalcularView calcularViewPadrao) {
        this.calculadorExpressao = calculadorExpressaoPadrao;
        this.calcularView = calcularViewPadrao;
    }

    /**
     * Fluxo principal de execução do programa.
     *
     * @param expressaoInformada A expressão informada no inicio da execução do programa.
     * @return O número de status para a execução. 0 sucesso para sucesso. 1 para erro.
     */
    public final int executeAplicacao(final String expressaoInformada) {
        String expressaoCalcular;

        if (expressaoInformada == null) {
            // Caso o usuário não tenha informado a expressão no inicio, pergunta.
            expressaoCalcular = calcularView.pergunteExpressao();
        } else {
            expressaoCalcular = expressaoInformada;
        }

        try {
            // Repassa a expressão para obter o valor e imprime para o usuário
            float valor = calculadorExpressao.calculeValor(expressaoCalcular);
            calcularView.informeResultado(valor);

            return 0;
        } catch (IllegalArgumentException ex) {
            // Expressão inválida informada.
            calcularView.informeErro(ex.getMessage());
            return 1;
        }
    }
}
