/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.controller;

import br.ufg.cs.cleydsonjr.calcular.model.CalculadorExpressao;
import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;

/**
 * Controller da aplicação. Contendo o fluxo de execução do projeto
 */
public class CalcularController {
    private CalculadorExpressao calculadorExpressao;
    private CalcularView calcularView;

    /**
     * Construtor que recebe as dependências de lógica e de interface.
     *
     * @param calculadorExpressao Implementação da regra de negócio.
     * @param calcularView        Implementação da interface com o usuário.
     */
    public CalcularController(CalculadorExpressao calculadorExpressao, CalcularView calcularView) {
        this.calculadorExpressao = calculadorExpressao;
        this.calcularView = calcularView;
    }

    /**
     * Fluxo principal de execução do programa.
     *
     * @param expressaoInformada A expressão informada no inicio da execução do programa.
     */
    public void executeAplicacao(String expressaoInformada) {
        if (expressaoInformada == null) {
            // Caso o usuário não tenha informado a expressão no inicio, pergunta.
            expressaoInformada = calcularView.pergunteExpressao();
        }

        try {
            // Repassa a expressão para obter o valor e imprime para o usuário
            float valor = calculadorExpressao.calculeValor(expressaoInformada);
            calcularView.informeResultado(valor);

            System.exit(0);
        } catch (IllegalArgumentException ex) {
            // Expressão inválida informada.
            calcularView.informeErro(ex.getMessage());
            System.exit(1);
        }
    }
}
