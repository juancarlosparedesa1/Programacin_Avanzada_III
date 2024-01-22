package com.programacion.avanzada.listas2;

import java.util.List;

/**
 * {1,2,3,4,5}
 *
 * [1, [2, [3, [4, [5,Empty]]]]]
 */
public interface Lista<T> {

    Lista Empty= new Empty();
    T head();
    List<T> tail();
    boolean isEmpty();
}
