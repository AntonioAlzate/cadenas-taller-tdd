package com.co.cadenas.calculadora;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculadoraCadenasTest {

    public CalculadoraCadenas calculadoraCadenas = new CalculadoraCadenas();

    // Una cadena vacía devuelve cero
    @Test
    public void cadenaVaciaValidacion(){
        assertThat(calculadoraCadenas.sumar(""), is(0));
    }

    // Un solo número devuelve el valor
    public void ingresoNumeroRetornaElValor(){
        assertThat(calculadoraCadenas.sumar("9"), is(9));
        assertThat(calculadoraCadenas.sumar("6"), is(6));
    }

    //Dos números, delimitados por comas, devuelven la suma
    @Test
    public void dosNumerosSeparadosPorComaRetornaSuma() throws Exception {
        assertThat(calculadoraCadenas.sumar("0,5"), is(5));
        assertThat(calculadoraCadenas.sumar("1,3"), is(4));
    }

    // Dos números, delimitados por saltos de línea, devuelve la suma
    @Test
    public void dosNumerosSeparadosSaltoLineaRetornaSuma() throws Exception {
        assertThat(calculadoraCadenas.sumar("0\n5"), is(5));
        assertThat(calculadoraCadenas.sumar("1\n3"), is(4));
    }

    // Tres números, delimitados de cualquier manera, devuelven la suma
    @Test
    public void tresNumerosSeparadosSaltoLineaOComaRetornaSuma() throws Exception {
        assertThat(calculadoraCadenas.sumar("1\n3,2"), is(6));
        assertThat(calculadoraCadenas.sumar("1,1\n8"), is(10));
    }

    // Los números negativos arrojan una excepción
    @Test(expected = Exception.class)
    public void numeroNegativoGeneraException() throws Exception {
        calculadoraCadenas.sumar("-5,-2");
    }

    // Los números superiores a 1000 se ignoran
    @Test
    public void numerosMayoresAMilIgnorados() throws Exception {
        assertThat(calculadoraCadenas.sumar("3,1000"), is(1003));
        assertThat(calculadoraCadenas.sumar("5,1111"), is(5));
    }

    // Se puede definir un solo delimitador de caracteres en la primera línea (p. Ej., // # para un "#" como delimitador)
    @Test
    public void unDelimitadorDeCaracteresEnPrimeraLinea() throws Exception {
        assertThat(calculadoraCadenas.sumar("#2#80"), is(82));
    }

    // Se puede definir un delimitador de varios caracteres en la primera línea (p. Ej., // [###] para "###" como delimitador)
    @Test
    void delimitadorVariosCaracteresPrimeraLinea(){
        assertThat(calculadoraCadenas.sumar("4[##]89[!]45[{}]7"),is(145));
        assertThat(calculadoraCadenas.sumar("4[__#]89[^!]45[%]7"), is(145));
        assertThat(calculadoraCadenas.sumar("4[##]89[^^&!]45[!%]7"), is(145));
    }

}