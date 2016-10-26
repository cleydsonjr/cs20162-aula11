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

    /**
     * @param args Argumentos de inicio da aplicação. Pode receber uma expressão.
     */
    public static void main(String[] args) {
        // Instancia as implementações
        CalculadorExpressao calculadorExpressao = new CalculadorExpressaoParser();
        CalcularView calcularView = new CalcularConsoleView();

        // Cria o controller injetando as dependências
        CalcularController controller = new CalcularController(calculadorExpressao, calcularView);

        // Tenta obter a expressão informada nos argumentos
        String expressaoInformada = null;
        if (args.length > 0) {
            expressaoInformada = args[0];
        }

        controller.executeAplicacao(expressaoInformada);
    }
}
