package com.programacion.avanzada;

import java.util.function.Function;

record Tupla<T>(T x, T y){
    @Override
    public String toString() {
        return String.format("(%s,%s)",x,y);
    }
}

public class Main {
    public static void main(String[] args) {

        //P1
        Lista<Tupla<String>> grafo = Lista.of(new Tupla<>("m","n"),
                new Tupla<>("m","p"),
                new Tupla<>("m","o"),
                new Tupla<>("n","q"),
                new Tupla<>("p","q"),
                new Tupla<>("o","r"),
                new Tupla<>("q","r"),
                new Tupla<>("q","s"));

        //Sucesores con recursividad en el Heap
        System.out.println("P1.1");
        System.out.println(sucesores(grafo,"q"));

        //Sucesores usando operacion de folding
        System.out.println("P1.2");
        Lista<String> res = null;
        System.out.println(foldingSucesor(grafo,"q",x->y-> y==null?new Lista<>(x): y.preppend(x),res).invertir());


        //P2
        System.out.println("P2");
        Lista<Integer> lista2 = Lista.of(1,2,3,4,5,6,7,8);
        System.out.println(lista2.eliminarNElementos(3,x->x%2==0));



        //P3
        System.out.println("P3");
        Lista<Integer> cambio = Lista.of(5,2,1);
        Integer valor = 19;

        System.out.println(convertir(cambio,valor,null));
    }

    public static<T> Lista<T> sucesores(Lista<Tupla<T>> tupla, T nodo){
        return sucesores_(tupla,nodo,null).eval();
    }

    public static<T> TailCall<Lista<T>> sucesores_(Lista<Tupla<T>> tupla,T nodo, Lista<T> res){
        return tupla==null
                ? Suspend.ret(res)
                : tupla.head().x().equals(nodo)
                    ? Suspend.sus(()-> sucesores_(tupla.tail(),nodo,res==null?new Lista<>(tupla.head().y()):res.append(tupla.head().y())))
                    : Suspend.sus(()-> sucesores_(tupla.tail(),nodo,res));
    }

    public static<T,U> U foldingSucesor(Lista<Tupla<T>> tupla, T nodo,Function<T, Function<U,U>> fn,U identity){
        return tupla.tail()==null
                ? (tupla.head().x()).equals(nodo)
                    ? fn.apply(tupla.head().y()).apply(identity)
                    :identity
                : (tupla.head().x()).equals(nodo)
                    ? foldingSucesor(tupla.tail(),nodo,fn,fn.apply(tupla.head().y()).apply(identity))
                    : foldingSucesor(tupla.tail(),nodo,fn,identity);
    }

    public static Lista<Integer> convertir(Lista<Integer> cambio, Integer valor,Lista<Integer> res){
        return valor==0
                ? res
                : valor-cambio.head()>=0
                    ? convertir(cambio,valor- cambio.head(),res==null?new Lista<>(cambio.head()):res.append(cambio.head()))
                    : convertir(cambio.tail(),valor,res);
    }


}