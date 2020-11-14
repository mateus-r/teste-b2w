package br.com.testeb2w;

import java.util.ArrayList;
import java.util.List;

public class NumerosMagicos {

    /**
     *
     * @param listaDeIntervalos  lista de intervalos a serem checados
     * @return a quantidade de números mágicos encontrados dentro do(s) intervalo(s) em listaDeIntervalos
     */
    public int contaNumerosMagicos(List<IntervaloDeInteiros> listaDeIntervalos) {

        int contador = 0;

        // itera pelos intervalos informados
        for(IntervaloDeInteiros intervalo : listaDeIntervalos) {
            // como 4 é primeiro número natural que possui uma raiz quadrada que é número primo, evita processamento desnecessário
            if(intervalo.getFim() > 3) {
                // todas as raízes que são números naturais estão contidas em [raiz do valor inicial, raiz do valor final]
                // então é possível iterar apenas os números ímpares deste intervalo menor em busca de números primos
                // (salvo pelo número 2)

                // a raiz é convertida para int usando ceil() para não usar um número anterior ao inicio
                // caso não seja um número natural
                int inicio = (int) Math.ceil(Math.sqrt(intervalo.getInicio()));

                // a raiz é convertida para int usando floor() para não usar um número posterior ao final
                int fim = (int) Math.floor(Math.sqrt(intervalo.getFim()));

                if (inicio <= 2) {
                    // incrementa o contador para considerar o número 2, que vai ser desconsiderado nas próximas checagens
                    contador++;
                    inicio++;
                }

                // se o inicio for par, incrementa um número
                if (inicio % 2 == 0) {
                    inicio++;
                }

                contador += contagemDeRaizesQuadradasMagicas(inicio, fim);
            }
        }
        return contador;
    }

    /**
     *
     * @param inicio numero ímpar, início do intervalo de raízes quadradas
     * @param fim número ímpar, fim do intervalo de raízes quadradas
     * @return o número de raízes quadradas que são números primos dentro do intervalo
     */
    private int contagemDeRaizesQuadradasMagicas(int inicio, int fim) {

        int contador = 0;

        // itera apenas pelas raízes ímpares
        for(int raiz = inicio; raiz <= fim; raiz += 2){
            boolean ehPrimo = true;
            // checa se o numero é primo, ignorando valores que já foram considerados
            for(int i = 3; i * i <= raiz; i += 2) {
                if(raiz % i == 0) {
                    ehPrimo = false;
                    break;
                }
            }
            if(ehPrimo) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] a) {
        NumerosMagicos numerosMagicos = new NumerosMagicos();
        List<IntervaloDeInteiros> listaDeIntervalos = new ArrayList<>();
        listaDeIntervalos.add(new IntervaloDeInteiros(0, 1));
        listaDeIntervalos.add(new IntervaloDeInteiros(0, 2));
        listaDeIntervalos.add(new IntervaloDeInteiros(0, 3));
        listaDeIntervalos.add(new IntervaloDeInteiros(0, 4));
        listaDeIntervalos.add(new IntervaloDeInteiros(1, 1));
        listaDeIntervalos.add(new IntervaloDeInteiros(2, 2));
        listaDeIntervalos.add(new IntervaloDeInteiros(3, 3));
        listaDeIntervalos.add(new IntervaloDeInteiros(4, 4));

        System.out.println(numerosMagicos.contaNumerosMagicos(listaDeIntervalos));
    }
}
