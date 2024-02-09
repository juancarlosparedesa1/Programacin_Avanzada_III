package com.programacion.avanzada;

public interface TailCall <T>{

    TailCall<T> resume();
    T eval();
    public boolean isSuspended();

}