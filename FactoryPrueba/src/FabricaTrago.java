public abstract class FabricaTrago {
    
    public void servirTrago(){
        preparacion();
        Trago tragoNuevo = crearTrago();
        tragoNuevo.ingredientes();
        servir();
    }

    public abstract Trago crearTrago();

    public void preparacion(){
        System.out.println("Agarrar vaso. Colocar vaso sobre la barra.\n");
    }

    public void servir(){
        System.out.println("Trago listo, acercar a barra.\n");
    }

}
