package br.ufg.cs.cleydsonjr.calcular.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculadorExpressaoParserTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void calculeValorRetornaValorCorretoParaExpressaoBemFormatada() throws Exception {
        CalculadorExpressaoParser calculador = new CalculadorExpressaoParser();

        float valorCalculado = calculador.calculeValor("(2 + 2) * 2");

        Assert.assertEquals("Valor calculado difere do esperado", 8f, valorCalculado, 0);
    }

    @Test
    public void calculeValorLancaExececaoParaExpressaoMalFormatada() throws Exception {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("Nao esperado: /");

        CalculadorExpressaoParser calculador = new CalculadorExpressaoParser();
        calculador.calculeValor("/(@2 + 2)-= * 2");
    }

}