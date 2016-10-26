package br.ufg.cs.cleydsonjr.calcular.model;

import com.github.kyriosdata.parser.Expressao;
import com.github.kyriosdata.parser.Lexer;
import com.github.kyriosdata.parser.Parser;
import com.github.kyriosdata.parser.Token;

import java.util.List;

public class CalculadorExpressaoParser implements CalculadorExpressao {

    public float calculeValor(String textoExpressao) {
        Expressao expressao = expandaExpressao(textoExpressao);
        return expressao.valor();
    }

    private Expressao expandaExpressao(String expressao) {
        List<Token> tokens = new Lexer(expressao).tokenize();
        Parser parser = new Parser(tokens);
        return parser.expressao();
    }
}
