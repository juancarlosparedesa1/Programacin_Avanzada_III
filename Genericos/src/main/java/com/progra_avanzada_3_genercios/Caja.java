package com.progra_avanzada_3_genercios;

//Ejemplo de una clase generica
public class Caja<T> {
    private T contenido;

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {

        this.contenido = contenido;
    }


    public static void main(String[] args) {
        //Uso de la clase generica
        Caja<Integer> cajaNumeros = new Caja<>();
        cajaNumeros.setContenido(4);
        Integer contenido = cajaNumeros.getContenido();
        System.out.println(contenido);
    }
}
