package progra_Avanzada_3_ED;

import java.util.List;
import java.util.function.Predicate;

public class Ejercicio01 {
    // Crea una lista de números y utiliza un stream para
    // obtener la suma de los cuadrados de los números pares.
    public static <T extends Number> double sumaCuadrados(List<T> lista, Predicate<T> condicion) {
        // Utilizamos el tipo de dato double para la suma, ya que el resultado puede ser decimal
        double suma = lista.stream()
                .filter(condicion)
                .mapToDouble(numero -> Math.pow(numero.doubleValue(), 2))
                .sum();

        return suma;
    }

    public static void main(String[] args) {
        List<Integer> listaEnteros = List.of(1, 2, 3, 4, 5, 6);
        Predicate<Integer> condicionPar = num -> num % 2 == 0;

        double resultado = sumaCuadrados(listaEnteros, condicionPar);

        System.out.println("La suma de los cuadrados de los números pares es: " + resultado);
    }
}
