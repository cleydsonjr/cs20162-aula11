/*
 * Copyright (c) 2016. Cleydson José de Figueiredo Júnior
 * Creative Commons Attribution 4.0 International License.
 */
package br.ufg.cs.cleydsonjr.calcular.model;

import com.github.kyriosdata.parser.Expressao;
import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;

import java.util.List;

/**
 * Implementação do calculador de uma expressão, usando a biblioteca "parser".
 */
public class CalculadorExpressaoParser implements CalculadorExpressao {

    /**
     * Implementaçao da lógica para calculo do valor de uma expressão informada.
     * Usando o parse dos Tokens.
     *
     * @param textoExpressao A expressão para analisar e calcular.
     * @return O valor da expressão calculado
     * @throws IllegalArgumentException Caso a expressão seja inválida
     */
    public final float calculeValor(final String textoExpressao) throws IllegalArgumentException {
        Expressao expressao = expandaExpressao(textoExpressao);
        return expressao.valor();
    }

    /**
     * Realiza a quebra do texto da expressão e converte em Expressao.
     *
     * @param expressao O texto da expressão para converter.
     * @return A expressão montada
     * @see Expressao
     */
    private Expressao expandaExpressao(final String expressao) {
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        return parser.expressao();
    }
}
