public class Generico extends Producto {

    public Generico(String name, String type, double baseprice, String code, int stock, String email,Long count, String nameSupplier){
        super(name, type, baseprice, code, stock, nameSupplier, count, email);
    }

    public double descuento(double baseprice) {
        if (50000 >= baseprice){
            return baseprice * 0.9;
        }
        return baseprice;
    }
// se define el bloque de codigo de la interfaz de manera
// independiente y unica para la clase que se implementa.
}
