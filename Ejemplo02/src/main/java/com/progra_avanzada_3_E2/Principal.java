package com.progra_avanzada_3_E2;

import com.progra_avanzada_3_E1.Operaciones;

public class Principal {
    public static void main(String[] args) {

        //Métodos
        double ret = Division.div(0);
        System.out.println("La division es: " + ret);

        //function
        Division division = new Division();

        int ret1 = division.fn.apply(2);
        System.out.println("La división es:" + ret1);

        //implementando metodos del modulo 1 Ejemplo01

        Operaciones operaciones= new Operaciones();
        int op= Operaciones.sumar(9,2);
        System.out.println("La suma es: "+op);

    }
}
