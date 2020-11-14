package br.com.testeb2w;

import com.google.common.math.IntMath;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NumerosMagicosTest {

    /**
     *  Teste simples usando apenas conhecimento do domínio
     */
    @Test
    public void testaContadorDeNumerosMagicos() {
        NumerosMagicos numerosMagicos = new NumerosMagicos();
        List<IntervaloDeInteiros> listaDeIntervalos = new ArrayList<>();
        int resultado;

        // Para a entrada: [[8,27], [49,49]]
        // Resultado: 3
        // Seriam os números 9 e 25 do primeiro intervalo e 49 do segundo
        listaDeIntervalos.add(new IntervaloDeInteiros(8, 27));
        listaDeIntervalos.add(new IntervaloDeInteiros(49, 49));
        resultado = 3;
        assertEquals(resultado, numerosMagicos.contaNumerosMagicos(listaDeIntervalos));

        listaDeIntervalos.clear();

        // Para a entrada: [[1,50], [50,100]]
        // Resultado: 4
        // Seriam os números 4, 9, 25 e 49 do primeiro intervalo
        listaDeIntervalos.add(new IntervaloDeInteiros(1, 50));
        listaDeIntervalos.add(new IntervaloDeInteiros(50, 100));
        resultado = 4;
        assertEquals(resultado, numerosMagicos.contaNumerosMagicos(listaDeIntervalos));

        listaDeIntervalos.clear();

        // Para a entrada: [[500, 10000]]
        // Resultado: 17
        // Seriam os números 529, 841, 961, 1369, 1681, 1849, 2209, 2809, 3481, 3721, 4489, 5041, 5329, 6241, 6889, 7921, 9409
        listaDeIntervalos.add(new IntervaloDeInteiros(500, 10000));
        resultado = 17;
        assertEquals(resultado, numerosMagicos.contaNumerosMagicos(listaDeIntervalos));

        listaDeIntervalos.clear();

        // Para a entrada: [[1, 1], [1, 2], [1, 3], [1, 4], [2, 2], [3, 3], [4, 4]]
        // Resultado: 2
        // Seria o número 4 do quarto intervalo, e o número 4 do sétimo intervalo
        listaDeIntervalos.add(new IntervaloDeInteiros(1, 1));
        listaDeIntervalos.add(new IntervaloDeInteiros(1, 2));
        listaDeIntervalos.add(new IntervaloDeInteiros(1, 3));
        listaDeIntervalos.add(new IntervaloDeInteiros(1, 4));
        listaDeIntervalos.add(new IntervaloDeInteiros(2, 2));
        listaDeIntervalos.add(new IntervaloDeInteiros(3, 3));
        listaDeIntervalos.add(new IntervaloDeInteiros(4, 4));
        resultado = 2;
        assertEquals(resultado, numerosMagicos.contaNumerosMagicos(listaDeIntervalos));
    }

    /**
     * Teste usando Google Guava
     * este teste é semelhante ao algorítimo sendo testado, porém utiliza bibliotecas externas e não otimiza o intervalo
     */
    @Test
    public void testaContadorDeNumerosMagicosGuava() {
        NumerosMagicos numerosMagicos = new NumerosMagicos();
        List<IntervaloDeInteiros> listaDeIntervalos = new ArrayList<>();
        int resultado;

        // Para a entrada: [[8,27], [49,49]]
        // Resultado: 3
        // Seriam os números 9 e 25 do primeiro intervalo e 49 do segundo
        listaDeIntervalos.add(new IntervaloDeInteiros(8, 27));
        listaDeIntervalos.add(new IntervaloDeInteiros(49, 49));

        int contador = 0;

        for(IntervaloDeInteiros intervalo : listaDeIntervalos) {
            for(int i = intervalo.getInicio(); i <= intervalo.getFim(); i++) {
                if(Math.sqrt(i) % 1 == 0) {
                    int raiz = (int) Math.sqrt(i);
                    if(IntMath.isPrime(raiz)) {
                        contador++;
                    }
                }
            }
        }
        resultado = contador;

        assertEquals(resultado, numerosMagicos.contaNumerosMagicos(listaDeIntervalos));
    }

}