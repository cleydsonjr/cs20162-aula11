/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.main;

import br.ufg.cs.cleydsonjr.calcular.controller.CalcularController;
import br.ufg.cs.cleydsonjr.calcular.model.CalculadorExpressao;
import br.ufg.cs.cleydsonjr.calcular.model.CalculadorExpressaoParser;
import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;
import br.ufg.cs.cleydsonjr.calcular.view.console.CalcularConsoleView;

/**
 * Classe principal para execução do programa.
 */
public final class Application {

    public static void main(String[] args) {
        CalculadorExpressao calculadorExpressao = new CalculadorExpressaoParser();
        CalcularView calcularView = new CalcularConsoleView();

        CalcularController controller = new CalcularController(calculadorExpressao, calcularView);

        String expressaoInformada = null;

        if (args.length > 0) {
            expressaoInformada = args[0];
        }

        controller.executeAplicacao(expressaoInformada);
    }
}
