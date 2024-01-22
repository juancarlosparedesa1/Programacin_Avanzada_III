package progra_avanzada_3;

public class sumarEstatico {

    //utilización de un método estático
    public static int sumar(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        System.out.println("Ejemplo 01 Estáticos");
        int ret= sumarEstatico.sumar(2,3);
        System.out.println("La suma es:"+ret);
    }
}
