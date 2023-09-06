public abstract class FabricaTrago {
    
    public void servirTrago(){
        recibirPedido();
        Trago tragoNuevo = crearTrago();
        tragoNuevo.ingredientes();
        tragoNuevo.preparacion();
        servir();
    }

    public abstract Trago crearTrago();

    public void recibirPedido(){
        System.out.println("Agarrar vaso. Colocar vaso sobre la barra.\n");
    }

    public void servir(){
        System.out.println("Trago listo, acercar a barra.\n");
    }

}
