package br.ufg.cs.cleydsonjr.calcular.view.console;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class CalcularConsoleViewTest {
    @Test
    public void pergunteExpressaoPerguntaCorretamenteEObtemAEntrada() throws Exception {
        String textoEntrada = "expressao\n";
        InputStream entradaPadrao = new ByteArrayInputStream(textoEntrada.getBytes(StandardCharsets.UTF_8));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream saidaPadrao = new PrintStream(out);

        CalcularConsoleView view = new CalcularConsoleView(entradaPadrao, saidaPadrao);

        String entrada = view.pergunteExpressao();
        String pergunta = new String(out.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals("A pergunta feita não foi a esperada", "Informe a expressão:\n", pergunta);
        Assert.assertEquals("A entrada retornada não foi a informada", "expressao", entrada);
    }

    @Test
    public void informeResultadoImprimeCorretamenteParaUsuario() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream saidaPadrao = new PrintStream(out);

        CalcularConsoleView view = new CalcularConsoleView(System.in, saidaPadrao);

        view.informeResultado(2f);
        String saida = new String(out.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals("O resultado informado não foi correto", "2.0\n", saida);
    }

    @Test
    public void informeErroImprimeErroCorretamente() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream saidaPadrao = new PrintStream(out);

        CalcularConsoleView view = new CalcularConsoleView(System.in, saidaPadrao);

        view.informeErro("Mensagem de erro");
        String saida = new String(out.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals("O erro informado não foi correto", "Mensagem de erro\n", saida);
    }

}