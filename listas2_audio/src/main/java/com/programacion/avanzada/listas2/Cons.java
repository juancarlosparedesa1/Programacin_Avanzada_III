package com.programacion.avanzada.listas2;

import java.util.List;

final class Cons<T> implements  Lista<T>{

    private final T head;
    private final List<T> tail;

    public Cons(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public T getHead() {
        return head;
    }

    public List<T> getTalil() {
        return tail;
    }


    public String toString(){
        return  String.format("[%s,%S",head,tail.toString());
    }

    @Override
    public T head() {
        return null;
    }

    @Override
    public List<T> tail() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
