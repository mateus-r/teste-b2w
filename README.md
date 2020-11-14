# Teste de desenvolvedor B2W
Teste desenvolvido em Java, utilizando Maven.  
JUnit e Guava utilizados para os testes.

A linguagem escolhida foi Java, por ser a linguagem em que tenho maior domínio.

## O teste
O teste consiste em desenvolver um programa que receba como entrada uma lista de intervalos [A,B] e retorne o somatório
da quantidade de números mágicos encontrados em cada intervalo.

*Um número X é dito “mágico” quando a raiz quadrada de X existe e é um número primo.*

## Execução
O programa pode ser iniciado pelo Maven para ser testado pelo terminal executando `mvn exec:java -Dexec.mainClass="br.com.testeb2w.NumerosMagicos"`.

Os testes podem ser executados utilizando `mvn test`


## Considerações
O teste segue a seguinte afirmação:  
> É garantido que os números A e B serão inteiros positivos e que A será sempre menor ou igual que B  

O Crivo de Eratóstenes ou o cálculo prévio de números primos foi descartado devido ao consumo de memória em grandes intervalos.