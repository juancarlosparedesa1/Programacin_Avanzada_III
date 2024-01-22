package com.programacion.avanzada.listas;

public interface Lista<T> {

    //por definicion es public static final

    //atributos
    Lista Empty = new Empty();

    //métodos
    T head();
    Lista<T> tail();

    boolean isEmpty();

    static<T>  Lista<T> of(T ... elements){

        var tmp= Lista.Empty;
        for (int i = elements.length-1; i >=0 ; i--) {
         tmp= new Cons(elements[i], tmp);

        }
        return tmp;

    }

    default  int count(){
        var tmp = this;
        int cc = 0;
        while(!tmp.isEmpty()) {
            cc++;
            tmp = tmp.tail();
        }
        return cc;
    }
    default Lista<T> prepend(T elemnt){
            return  new Cons<>(elemnt,this);
    }
    default Lista<T> append(T elem){
        return this.isEmpty()
                ? new Cons<>(elem, Lista.Empty)
                : new Cons<>(this.head(), this.tail().append(elem));
//        if(this.isEmpty()){
//            return  new Const<>(elem,Lista.Empty);
//        }else{
//            return new Const<>(
//                    this.head(),
//                    this.tail().append(elem)
//            );
//
//        }
    }

    default Lista<T> insert(int index, T element){
        return (index == 0)
                ? new Cons<>(element, this)
                :new Cons<>(this.head(), this.tail().insert(index - 1, element));

//        if(index==0){
//            return  new Const<>(element,this);
//        }else{
//            return new Const<>(
//                    this.head(),
//                    this.tail().insert(index-1,element)
//            );
//
//        }

    }
    default T get(int index){
        return (index == 0)
                ? this.head()
                : this.tail().get(index - 1);
//        if (index == 0) {
//            return this.head();
//
//        }else{
//            return this.tail().get(index-1);
//        }
    }
}
