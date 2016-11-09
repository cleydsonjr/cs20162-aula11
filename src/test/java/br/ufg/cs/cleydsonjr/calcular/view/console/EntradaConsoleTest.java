package br.ufg.cs.cleydsonjr.calcular.view.console;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class EntradaConsoleTest {

    @Test
    public void pergunteStringDeveRetornarAStringFornecina() throws Exception {
        String textoEntrada = "String\n";
        InputStream stream = new ByteArrayInputStream(textoEntrada.getBytes(StandardCharsets.UTF_8));

        EntradaConsole entradaConsole = new EntradaConsole(stream, System.out);
        String textoLido = entradaConsole.pergunteString("Perguta");

        Assert.assertEquals("O texto lido difere do esperado", "String", textoLido);
    }

    @Test
    public void pergunteStringForcandoDeveRetornarAPrimeiraStringFornecina() throws Exception {
        String textoEntrada = "\n\n\nString\n";
        InputStream stream = new ByteArrayInputStream(textoEntrada.getBytes(StandardCharsets.UTF_8));

        EntradaConsole entradaConsole = new EntradaConsole(stream, System.out);
        String textoLido = entradaConsole.pergunteString("Perguta", true);

        Assert.assertEquals("O texto lido difere do esperado", "String", textoLido);
    }

}