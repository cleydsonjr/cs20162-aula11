package br.ufg.cs.cleydsonjr.calcular.controller;

import br.ufg.cs.cleydsonjr.calcular.model.CalculadorExpressao;
import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;

public class CalcularController {
    CalculadorExpressao calculadorExpressao;
    CalcularView calcularView;

    public CalcularController(CalculadorExpressao calculadorExpressao, CalcularView calcularView) {
        this.calculadorExpressao = calculadorExpressao;
        this.calcularView = calcularView;
    }

    public void executeAplicacao(String expressaoInformada) {
        if (expressaoInformada == null) {
            expressaoInformada = calcularView.pergunteExpressao();
        }

        try {
            float valor = calculadorExpressao.calculeValor(expressaoInformada);
            calcularView.imprimaResultado(valor);

            System.exit(0);
        } catch (IllegalArgumentException ex) {
            calcularView.imprimaErro(ex.getMessage());
            System.exit(1);
        }
    }
}
