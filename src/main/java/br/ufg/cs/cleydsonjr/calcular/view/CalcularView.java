package br.ufg.cs.cleydsonjr.calcular.view;

public interface CalcularView {

    String pergunteExpressao();

    void imprimaResultado(float resultado);

    void imprimaErro(String mensagem);
}
