import utiles.TecladoIn;

public class Prueba {
    public static void main(String[] args) {
        int opcion = -1;
        FabricaTrago tragoElegido;

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
                }break;
                case 2:{
                    tragoElegido = new FabricaMojito();
                }break;
                default:{
                    tragoElegido = new FabricaAgua();
                }
            }
            tragoElegido.servirTrago();
        }
    }
}
