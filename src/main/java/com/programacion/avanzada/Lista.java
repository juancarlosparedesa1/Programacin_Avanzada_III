package com.programacion.avanzada;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lista<T>{

    private final T head;
    private final Lista<T> tail;

    public T head() {
        return head;
    }

    public Lista<T> tail() {
        return tail;
    }



    public Lista(T head){
        this(head,null);
    }

    public Lista(T head, Lista<T> tail){
        this.head = head;
        this.tail = tail;
    }

    public Lista(T... elems){
        Lista<T> res = null;
        for(int i = elems.length-1; i>=0; i--){
            res = new Lista<>(elems[i],res);
        }
        this.head = res.head;
        this.tail = res.tail;
    }

    public Lista<T> eliminar(T elem){
        Lista<T> tmp = this;
        Lista<T> res = null;

        while (tmp!=null){
            if (!tmp.head.equals(elem)){
                res = new Lista<>(tmp.head,res);
            }
            tmp = tmp.tail;
        }
        return res.invertir();
    }

    public Lista<T> filtrar(Predicate<T> filtro){
        Lista<T> tmp = this;
        Lista<T> res = null;

        while(tmp!=null){
            if(filtro.test(tmp.head)){
                res = new Lista<>(tmp.head,res);
            }
            tmp = tmp.tail;
        }
        return res.invertir();
    }

    public Lista<T> invertir(){
        Lista<T> tmp = this;
        Lista<T> res = null;
        while (tmp!=null){
            res = new Lista<>(tmp.head,res);
            tmp = tmp.tail;
        }
        return res;
    }

    public void imprimir(Consumer<T> con){
        Lista<T> tmp = this;
        while(tmp!=null){
            con.accept(tmp.head);
            tmp = tmp.tail;
        }
    }

    public static<T> Lista<T> of(T... elems){
        return new Lista<>(elems);
    }

    public Lista<T> append(T elem) {
        return append_(this, elem, null).eval().invertir();
    }

    private static <T> TailCall<Lista<T>> append_(Lista<T> lista, T elem, Lista<T> acc) {
        return lista == null
                ? Suspend.ret(acc == null ? new Lista<>(elem) : acc.preppend(elem))
                : Suspend.sus(() -> append_(lista.tail(), elem, acc == null ? new Lista<>(lista.head()) : acc.preppend(lista.head())));
    }

    public Lista<T> preppend(T elem){
        return new Lista<>(elem,this);
    }

    public <U> Lista<U> mapRe(Function<T, U> fn){
        return mapRe_(fn,null).eval();
    }

    private<U> TailCall<Lista<U>> mapRe_(Function<T, U> fn, Lista<U> acc) {
        return this.tail == null
                ? Suspend.ret(new Lista<>(fn.apply(this.head), acc))
                : acc == null
                ? Suspend.sus(() -> this.tail.mapRe_(fn, new Lista<>(fn.apply(this.head), null)))
                : Suspend.sus(() -> this.tail.mapRe_(fn, new Lista<>(fn.apply(this.head), acc)));
    }




    public Lista<T> eliminarNElementos(Integer n, Predicate<T> condicion){
        return eliminarNElementos_(n,condicion,this,null).eval();
    }

    private TailCall<Lista<T>> eliminarNElementos_(Integer n, Predicate<T> condicion, Lista<T> lista, Lista<T> res){

        return n==0||lista==null
                ? Suspend.ret(res.concatener(lista))
                : !condicion.test(lista.head)
                    ? Suspend.sus(()->eliminarNElementos_(n,condicion,lista.tail,res==null?new Lista<>(lista.head):res.append(lista.head)))
                    : Suspend.sus(()->eliminarNElementos_(n-1,condicion,lista.tail,res==null?new Lista<>(lista.head):res));
    }

    private Lista<T> concatener(Lista<T> lista) {
        return lista==null
                ? this
                : this.append(lista.head).concatener(lista.tail);
    }





    @Override
    public String toString() {
        return String.format("[%s,%s]",
                this.head.toString(),
                this.tail==null?"null":this.tail.toString());
    }
}
