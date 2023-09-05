import utiles.TecladoIn;
import java.util.concurrent.ForkJoinPool;
import java.util.LinkedList;

public class Prueba {
    public static void main(String[] args) {
        int opcion = -1;
        LinkedList<Integer> cuenta = new LinkedList<Integer>();
        int[] arregloCuenta;
        int cantidadTragos = 0;
        FabricaTrago tragoElegido;
        ForkJoinPool pool = new ForkJoinPool();
        int precioFinal;

        while(opcion != 0){
            System.out.println("##################################################");
            System.out.println("Elegir Trago:");
            System.out.println("\t1. Fernet");
            System.out.println("\t2.Mojito");
            System.out.println("\t0.Agua y finalizar\n");
            System.out.println("##################################################");
            opcion = TecladoIn.readLineInt();
            switch(opcion){
                case 1:{
                    tragoElegido = new FabricaFernet();
                    cuenta.add(1000);
                    cantidadTragos++;
                }break;
                case 2:{
                    tragoElegido = new FabricaMojito();
                    cuenta.add(1600);
                    cantidadTragos++;
                }break;
                default:{
                    tragoElegido = new FabricaAgua();
                }
            }
            tragoElegido.servirTrago();
            
        }

        //"Conversion" de LinkedList<Integer> a int[]
        arregloCuenta = new int[cantidadTragos];
        for(int i=0; i < cantidadTragos; i++){
            arregloCuenta[i] = (int)cuenta.get(i);
        }

        precioFinal = pool.invoke(new sumarCuentaTragos(arregloCuenta,0,cantidadTragos));
        System.out.println("Suma de los targos: " + precioFinal);
    }
}
