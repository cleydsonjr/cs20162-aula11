/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.view.console;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Classe auxiliar para encapsular a leitura de entrada do usuário no console.
 */
public class EntradaConsole {
    /**
     * Scanner usado para leitura das entradas.
     */
    private Scanner scanner;

    /**
     * Construtor para classe auxiliar que manipula entradas dos usuários.
     *
     * @param in InputStream padrão de entrada
     */
    public EntradaConsole(final InputStream in) {
        this.scanner = new Scanner(in);
    }

    /**
     * Imprime uma pergunta para o usuário e lê o texto de entrada.
     *
     * @param pergunta O texto da pergutna que deve ser feita
     * @return O texto que o usuário inseriu
     */
    public final String pergunteString(final String pergunta) {
        out.println(pergunta);
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
        String entrada = pergunteString(pergunta);

        if (obrigarEntrada) {
            while (entrada.trim().equals("")) {
                entrada = pergunteString(pergunta);
            }
        }

        return entrada;
    }
}
