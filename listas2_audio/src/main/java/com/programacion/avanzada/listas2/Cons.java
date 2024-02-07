package com.programacion.avanzada.listas2;


record Cons<T> (T head, Lista<T> tail) implements  Lista<T>{

    /*private final T head;
    private final List<T> tail;

   public Cons(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

//    public T getHead() {
//        return head;
//    }
//
//    public List<T> getTalil() {
//        return tail;
//    }
    @Override
    public T head() {
        return head;
    }

    @Override
    public List<T> tail() {
        return tail;
    }*/

    @Override
    public boolean isEmpty() {
        return false;
    }

    public String toString(){
        return  String.format("[%s,%S",head,tail.toString());
    }
}
