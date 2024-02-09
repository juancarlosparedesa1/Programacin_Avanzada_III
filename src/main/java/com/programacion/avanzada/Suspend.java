package com.programacion.avanzada;

import java.util.function.Supplier;

public class Suspend <T> implements TailCall<T> {

    private final Supplier<TailCall<T>> resume;

    public Suspend(Supplier<TailCall<T>> resume) {
        this.resume = resume;
    }

    @Override
    public TailCall<T> resume() {
        return resume.get();
    }

    @Override
    public T eval() {
        TailCall<T> tailRec = this;
        while (tailRec.isSuspended()) {
            tailRec = tailRec.resume();
        }
        return tailRec.eval();
    }

    @Override
    public boolean isSuspended() {
        return true;
    }

    public static <T> Return<T> ret(T t) {
        return new Return<>(t);
    }

    public static <T> Suspend<T> sus(Supplier<TailCall<T>> s) {
        return new Suspend<>(s);
    }
}

