package br.ufg.cs.cleydsonjr.calcular.view.console;

import br.ufg.cs.cleydsonjr.calcular.view.CalcularView;

public class CalcularConsoleView implements CalcularView {
    private EntradaConsole entradaConsole;

    public CalcularConsoleView() {
        this.entradaConsole = new EntradaConsole();
    }

    public String pergunteExpressao() {
        return entradaConsole.pergunteString("Informe a expressão:", true);
    }

    public void imprimaResultado(float resultado) {
        System.out.println(resultado);
    }

    public void imprimaErro(String mensagem) {
        System.out.println(mensagem);
    }
}
