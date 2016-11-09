package br.ufg.cs.cleydsonjr.calcular.controller;

import br.ufg.cs.cleydsonjr.calcular.model.CalculadorExpressao;
import br.ufg.cs.cleydsonjr.calcular.model.CalculadorExpressaoParser;
import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;
import br.ufg.cs.cleydsonjr.calcular.view.console.CalcularConsoleView;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


public class CalcularControllerTest {

    @Test
    public void executeAplicacaoInformandoDiretamenteExpressaoValida() throws Exception {
        String textoEntrada = "";
        InputStream entradaPadrao = new ByteArrayInputStream(textoEntrada.getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream saidaPadrao = new PrintStream(out);

        CalculadorExpressao calculadorExpressao = new CalculadorExpressaoParser();
        CalcularView calcularView = new CalcularConsoleView(entradaPadrao, saidaPadrao);

        CalcularController controller = new CalcularController(calculadorExpressao, calcularView);
        int status = controller.executeAplicacao("(2 * 2) + 2");

        String saida = new String(out.toByteArray(), StandardCharsets.UTF_8);

        Assert.assertEquals(0, status);
        Assert.assertEquals("6.0\n", saida);
    }

}