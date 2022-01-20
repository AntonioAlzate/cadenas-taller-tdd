package com.co.cadenas.calculadora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.Float.parseFloat;

public class CalculadoraCadenas {

    public int sumar(String valor) throws Exception {

        if(valor.length() > 0) {
            int temporal;
            String delimitador = null;

            try {
                temporal = Integer.parseInt("" + valor.charAt(0));
            } catch(Exception e) {
                if(("" + valor.charAt(0)) == "-") {
                    delimitador = null;
                } else {
                    delimitador = "" + valor.charAt(0);
                }
            }

            String[] listaDividida = null;
            if(delimitador != null && delimitador == "-") {
                listaDividida = valor.substring(1, valor.length()).split("[,|\n]");
            } else {
                listaDividida = valor.replaceAll("[\\[.*\\]|#]", ",").split("[,|\n]");
            }

            ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
            int acumulador = 0;
            for(String elemento: listaDividida) {
                try{
                    int valorTemporal = Integer.parseInt(elemento);
                    if(valorTemporal < 0) {
                        throw new Exception("Número Negativo");
                    }
                    if(valorTemporal > 1000) {
                        continue;
                    }
                    listaNumeros.add(valorTemporal);
                }
                catch (Exception e){
                    if(e.getMessage().equals("Número Negativo")){
                        throw new Exception("Número Negativo");
                    }
                }

            }
            for(Integer numero: listaNumeros) {
                acumulador += numero;
            }
            return acumulador;
        }
        return 0;
    }

}
