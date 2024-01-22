package com.progra_avanzada_3_genercios;

public class GMultParametros <T,U> {
    T primerElemento;
    U segundoElemento;

    public GMultParametros(T primerElemento, U segundoElemento) {
        this.primerElemento = primerElemento;
        this.segundoElemento = segundoElemento;
    }

    public T getPrimerElemento() {
        return primerElemento;
    }

    public void setPrimerElemento(T primerElemento) {
        this.primerElemento = primerElemento;
    }

    public U getSegundoElemento() {
        return segundoElemento;
    }

    public void setSegundoElemento(U segundoElemento) {
        this.segundoElemento = segundoElemento;
    }

    public static void main(String[] args) {
        GMultParametros<Integer,String> instancia=new GMultParametros(2,"hola");
        //Integer primerElemento=instancia.getPrimerElemento();
        //String segundoElemento= instancia.getSegundoElemento();
        System.out.println("Primer elemento: "+instancia.primerElemento);
        System.out.println("Segundo elemento: "+instancia.segundoElemento);

    }
}
