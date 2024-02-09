package com.programacion.avanzada;

public class Return<T> implements TailCall<T> {

    private final T t;

    public Return(T t){
        this.t =t;
    }

    @Override
    public TailCall resume() {
        return null;
    }

    @Override
    public T eval() {
        return t;
    }

    @Override
    public boolean isSuspended() {
        return false;
    }
}
