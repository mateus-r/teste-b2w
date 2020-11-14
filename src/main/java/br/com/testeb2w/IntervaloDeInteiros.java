package br.com.testeb2w;

/**
 * Objeto que representa o início e o fim de um intervalo de números inteiros
 */
public class IntervaloDeInteiros {
    private int inicio;
    private int fim;

    public IntervaloDeInteiros(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }
}
