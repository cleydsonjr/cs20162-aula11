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
public abstract class Application {

    /**
     * @param args Argumentos de inicio da aplicação. Pode receber uma expressão.
     */
    public static void main(final String[] args) {
        // Instancia as implementações padrões
        CalculadorExpressao calculadorExpressao = new CalculadorExpressaoParser();
        CalcularView calcularView = new CalcularConsoleView(System.in, System.out);

        // Cria o controller injetando as dependências
        CalcularController controller = new CalcularController(calculadorExpressao, calcularView);

        // Tenta obter a expressão informada nos argumentos
        String expressaoInformada = null;
        if (args.length > 0) {
            expressaoInformada = args[0];
        }

        int status = controller.executeAplicacao(expressaoInformada);

        System.exit(status);
    }
}
