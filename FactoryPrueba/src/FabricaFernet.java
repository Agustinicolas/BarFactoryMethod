public class FabricaFernet extends FabricaTrago {
    public Trago crearTrago(){
        return new Fernet();
    }
}
