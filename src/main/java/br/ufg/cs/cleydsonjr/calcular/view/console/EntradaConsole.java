/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.view.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Classe auxiliar para encapsular a leitura de entrada do usuário no console.
 */
public class EntradaConsole {
    /**
     * Scanner usado para leitura das entradas.
     */
    private Scanner scanner;

    /**
     * Saída padrão para iteração com o usuário.
     */
    private PrintStream saida;

    /**
     * Construtor para classe auxiliar que manipula entradas dos usuários.
     *
     * @param entradaPadrao InputStream padrão de entrada
     * @param saidaPadrao   O PrintStream padrão de saída.
     */
    public EntradaConsole(final InputStream entradaPadrao, final PrintStream saidaPadrao) {
        this.scanner = new Scanner(entradaPadrao);
        this.saida = saidaPadrao;
    }

    /**
     * Imprime uma pergunta para o usuário e lê o texto de entrada.
     *
     * @param pergunta O texto da pergutna que deve ser feita
     * @return O texto que o usuário inseriu
     */
    public final String pergunteString(final String pergunta) {
        saida.println(pergunta);
        return scanner.nextLine();
    }

    /**
     * Imprime uma pergunta para o usuário e lê o texto de entrada.
     *
     * @param pergunta       O texto da pergutna que deve ser feita
     * @param obrigarEntrada Flag para indicar se deve bloquear texto em branco
     * @return O texto que o usuário inseriu
     */
    public final String pergunteString(final String pergunta, final boolean obrigarEntrada) {
        String entrada = pergunteString(pergunta).trim();

        if (obrigarEntrada) {
            while ("".equals(entrada)) {
                entrada = pergunteString(pergunta);
            }
        }

        return entrada;
    }
}
