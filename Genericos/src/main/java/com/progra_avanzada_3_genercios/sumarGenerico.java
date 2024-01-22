package com.progra_avanzada_3_genercios;

public class sumarGenerico {
    //método estático
    public static <T extends Number> T sumar(T num1, T num2) {
        //se verifica que el primer numero num1 sea de tipo Integer
        //solo se verifica el primer numero porque asumimos que num1 y num2
        //son del mismo tipo
        if (num1 instanceof Integer) {
            //1.num1.intValue() + num2.intValue(): Se obtienen los valores enteros de num1 y num2 utilizando
            // el método intValue(). Esto es posible porque el tipo genérico T extiende la clase Number, que
            // tiene el método intValue() para obtener la representación entera del número.
            //2.Integer.valueOf(...): El resultado de la suma se envuelve en un objeto Integer utilizando el
            // método estático valueOf de la clase Integer. Esto convierte el resultado de la suma, que es un
            // primitivo int, en un objeto Integer.
            //3.(T) ...: El resultado se castea al tipo genérico T. Este casting es necesario porque valueOf
            // devuelve un objeto Integer, pero el método está definido para devolver un tipo genérico T.
            //Este enfoque permite realizar la suma y convertir el resultado al tipo genérico especificado en
            // la llamada al método sumar. Sin embargo, ten en cuenta que este código supone que el tipo genérico
            // T es compatible con Integer. Si T no es compatible con Integer, puede haber pérdida de precisión o
            // errores en tiempo de ejecución. Este tipo de conversión puede ser seguro para ciertos tipos de
            // números, pero debes tener cuidado al utilizarlo en contextos más generales.
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
        } else if (num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
        } else if (num1 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
        }
        throw new IllegalArgumentException("Tipo de dato no soportado");
    }
    //Long sumarLongs = sumarGenerico.sumar(2L, 2L); // Lanzará una IllegalArgumentException

    public static void main(String[] args) {

        //Ejemplo uso de enteros
        Integer sumarEnteros=sumarGenerico.sumar(2,2);
        System.out.println("La suma de enteros es: "+sumarEnteros);
        //Ejemplo de uso de decimales
        Double sumarDoubles=sumarGenerico.sumar(2.0,2.0);
        System.out.println("La suma de double es: "+sumarDoubles);
        //Ejemplo de uso de float
        Float sumarFloats=sumar(2.0f,2.0f);
        System.out.println("La suma es Float: "+sumarFloats);

    }
}

