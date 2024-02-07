package com.programacion.avanzada.listas2;



public final class Cons1<T> implements Lista<T> {

    private final T head;
    private final Lista<T> tail;


    public Cons1(T head, Lista<T> tail) {
        this.head = head;
        this.tail = tail;
    }


    @Override
    public T head() {
        return null;
    }

    @Override
    public Lista<T> tail() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
