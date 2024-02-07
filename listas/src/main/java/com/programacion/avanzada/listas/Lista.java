package com.programacion.avanzada.listas;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Lista<T> {

    //por definicion es public static final
    Lista Empty = new Empty();

    T head();

    Lista<T> tail();

    boolean isEmpty();

    static <T> Lista<T> of(T... elements) {

        var tmp = Lista.Empty;
        for (int i = elements.length - 1; i >= 0; i--) {
            tmp = new Cons(elements[i], tmp);

        }
        return tmp;

    }

    static <T> Lista<T> of(T head, Lista<T> tail) {
        return new Cons<>(head, tail);

    }

    default int count() {
        return 1 + tail().count();


    }

    //    default Lista<T> prepend(T elemnt) {
//        return new Const<>(elemnt, Lista.Empty);
//    }
    default Lista<T> prepend(T elemnt) {
        return Lista.of(elemnt, this);
    }

    default Lista<T> append(T elem) {
        if (this.isEmpty()) {
            return new Cons<>(elem, Lista.Empty);
        } else {
            return new Cons<>(
                    this.head(),
                    this.tail().append(elem)
            );

        }
    }

    default Lista<T> insert(int index, T element) {

        if (index == 0) {
            return new Cons<>(element, this);
        } else {
            return Lista.of(
                    this.head(),
                    this.tail().insert(index - 1, element)
            );

        }

    }

    default T get(int index) {
        if (index == 0) {
            return this.head();

        } else {
            return this.tail().get(index - 1);
        }
    }

    default Lista<T> take(int n) {
        return n <= 0 || this.isEmpty()
                ? Lista.Empty
                : Lista.of(this.head(), this.tail().take(n - 1));

        /*if(n<=0 ||this.isEmpty()){
            return Lista.Empty;
        }else{
            return  Lista.of(this.head(), this.tail().take(n-1));
        }*/
    }

    default Lista<T> drop(int n) {
        return n <= 0 || this.isEmpty()
                ? this
                : this.tail().drop(n - 1);
        /*if(n<=0 || this.isEmpty()){
           return this;
       }else {
           return this.tail().drop(n-1);
       }*/

    }

    default Lista<T> concat(Lista<T> ls) {
        return this.isEmpty()
                ? ls
                : Lista.of(this.head(), this.tail().concat(ls));
        /*if(this.isEmpty()){
           return ls;
       }else {
           return Lista.of(this.head(), this.tail().concat(ls));
       }*/
    }

    default <U> Lista<U> map(Function<T, U> funcion) {
        return this.isEmpty()
                ? Lista.Empty
                : Lista.of(funcion.apply(this.head()), this.tail().map(funcion));
    }

    default <U> U foldingLeft(U identity, Function<U, Function<T, U>> function) {
        //De izquierda a derecha es iterativo
        U ret = identity;

        var tmp = this;
        while (!tmp.isEmpty()) {
            ret = function.apply(ret).apply(tmp.head());
            tmp = tmp.tail();
        }
        return ret;
    }

    default <U> U foldingRight(U identity, Function<T, Function<U, U>> function) {
        U ret = identity;
        var tmp = this.invertFolding(); // Invierte la estructura de datos

        while (!tmp.isEmpty()) {
            ret = function.apply(tmp.head()).apply(ret);
            tmp = tmp.tail();
        }

        return ret;
    }

    default <U> U foldRightHenry(U identify, Function<T, Function<U, U>> fn) {
        if (isEmpty()) {
            return identify;
        } else {
            return fn.apply(head()).apply(tail().foldRightHenry(identify, fn));
        }
    }

    // Método para invertir la estructura de datos

    //Invertir
    default Lista<T> invertFolding() {
        return foldingLeft(Lista.Empty, ls -> t -> ls.prepend(t));
    }

    default <U> Lista<U> mapFolding(Function<T, U> fn) {
        return foldingLeft(Lista.Empty, ls -> t -> ls.prepend(fn.apply(t)));
    }

    default <U> Lista<U> mapFolding2(Function<T, U> fn) {
        return foldingRight(Lista.Empty, t -> ls -> ls.prepend(fn.apply(t)));
    }

    default Integer countFolding() {
        return foldingLeft(0, n -> t -> n + 1);
    }

    default Lista<T> appendFolding(T elem) {
        return foldingRight(Lista.of(elem), t -> ls -> ls.prepend(t));
    }

    default T reduce(T indentity, Function<T, Function<T, T>> fn) {
        return foldingLeft(indentity, u -> t -> fn.apply(u).apply(t));

    }

    //Simplificado
    default T reduce2(Function<T, Function<T, T>> fn) {
        return this.tail().foldingLeft(this.head(), u -> t -> fn.apply(u).apply(t));

    }

    default Lista<T> takeFolding(int n) {
        return foldingLeft(Lista.Empty,
                ls -> t -> ls.count() < n ? ls.append(t) : ls);
    }

    //    default Lista<T> dropFold(int n){
//        int total= this.count()-n;
//        return foldingRight(
//                Lista.Empty,
//                t->ls->ls.count()<total?ls.prepend(t):ls
//        );
//    }
    default Lista<T> dropFold(int n) {
        int tot = this.count() - n;
        return foldingRight(
                Lista.Empty,
                t -> ls -> ls.count() < tot ? ls.prepend(t) : ls);
    }

    //Recursividad y Correcursividad

    //Range Recursivo

    default Lista<Integer> range(Integer start, Integer end){
        if(start >= end){
            return Lista.Empty;
        }else{
            return Lista.of(start, range(start + 1, end));
        }

    }
    //Range tail Recursivo
    static Lista<Integer> rangeRecTail(Integer start, Integer end, Lista<Integer> accumulator) {
        if (start < end) {
            return rangeRecTail(start + 1, end, accumulator.append(start));
        }
        return accumulator;
    }
    // Llamada inicial
    static Lista<Integer> rangeRec(Integer start, Integer end) {
        return rangeRecTail(start, end, Lista.Empty);
    }

    //Range Unfold
    //valor Incial
    static Lista<Integer> rangeUnfold(Integer start, Integer end) {
        return unfold(start, x -> x + 1, x -> x < end);
    }
    static <T> Lista<T> unfold(T start, Function<T, T> fn, Predicate<T> condition) {
        return condition.test(start) ? Lista.of(start, unfold(fn.apply(start), fn, condition)) : Lista.Empty;
    }

    //unfold imperactivo

     static void unfoldImperativo(int start, Function<Integer, Integer> fn, Predicate<Integer> condition) {
        while (condition.test(start)) {
            System.out.println(start);
            start = fn.apply(start);
        }
    }

    //unfold recursivo

    static Lista<Integer> unfoldRecursivo(Integer start, Function<Integer, Integer> fn, Predicate<Integer> condition) {
        if (condition.test(start)) {
            return Lista.of(start, unfoldRecursivo(fn.apply(start), fn, condition));
        } else {
            return Lista.Empty;
        }
    }
    //unfold tail recursivo

    //Llamada inicial
    static Lista<Integer> unfoldTailRecursivo(Integer start, Function<Integer, Integer> fn, Predicate<Integer> condition) {
        return unfoldTailRec(start, fn, condition, Lista.Empty);
    }

    private static Lista<Integer> unfoldTailRec(Integer start, Function<Integer, Integer> fn, Predicate<Integer> condition, Lista<Integer> accumulator) {
        if (condition.test(start)) {
            return unfoldTailRec(fn.apply(start), fn, condition, Lista.of(start, accumulator));
        } else {
            return accumulator.invertFolding();
        }
    }
}