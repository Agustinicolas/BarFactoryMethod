import java.util.concurrent.RecursiveTask;
//import java.util.concurrent.ForkJoinPool;
/*
 * metodo que utiliza patrón de programación concurrente Fork-Join para dividir
 * la tarea de sumar los targos pedidos de forma paralela dividiendo la tarea en
 * otras subTareas
 */
public class sumarCuentaTragos extends RecursiveTask<Integer>{
    private static final int umbralDivision = 2;
    private int[] cuenta;
    private int start;
    private int end;

    public sumarCuentaTragos(int[] cuenta,int start,int cont){
        this.cuenta=cuenta;
        this.start=start;
        end=cont;
    }
    @Override
    protected Integer compute(){//computation task
        if(end-start<=umbralDivision){// caso de la divicion minima de la tarea
            int  suma = 0;
            for(int i=start;i<end;i++){
                suma+=cuenta[i];
            }
            return suma;
        }else{//caso recursivo
            int mid = (start + end) / 2;//divide el tamano del arrelo 
            sumarCuentaTragos leftTask = new sumarCuentaTragos(cuenta, start, mid);//se crea una nueva tarea del lado left
            sumarCuentaTragos rightTask = new sumarCuentaTragos(cuenta, mid, end);//se crea una nueva tarea del lado right

            leftTask.fork();//etapa de difurcacion
            int rightResult = rightTask.compute();//lado derecho llama a la tarea computar
            int leftResult = leftTask.join();//El hilo/proceso que se bifurcaron previamente se "une" nuevamente 

            return leftResult + rightResult;// se unen los resultados de las tareas
        }
    }
}
