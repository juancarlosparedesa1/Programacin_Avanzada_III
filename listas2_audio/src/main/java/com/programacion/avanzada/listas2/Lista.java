package com.programacion.avanzada.listas2;


/**
 * {1,2,3,4,5}
 *
 * [1, [2, [3, [4, [5,Empty]]]]]
 */
public interface Lista<T> {

    Lista Empty= new Empty();
    T head();
    Lista<T> tail();
    boolean isEmpty();

    static <T>Lista<T> of (T... elements){

        var tmp= Lista.Empty;
        for (int i = elements.length-1; i >=0 ; i--) {
            tmp= new Cons(elements[i], tmp);
        }
        return tmp;
    }

}
