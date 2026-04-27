class Tecnologia extends Producto implements IVA{

    //Atributos de la clase hija
    private int reference;
    private String brand;

    public Tecnologia(String name, String type,  double basePrice, String code, int stock, int reference, String brand) {
        // Super llama al  contructor de la clase abstracta Producto.
        super(name ,type, basePrice, code, stock);
        // Despues modificamos la variable con set price y a su vez
        // con el metododo de la interfaz.
        this.setPrice(calcularIVA(basePrice));
        this.setReference(reference);
        this.setBrand(brand);
    }

    // Getters y Setters de tecnologia.
    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        if (reference <=  0) throw new IllegalArgumentException("Codigo no valido.");
        this.reference = reference;
        // Validaciones.
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public double descuento(double precio) {
        if (precio >= 50000) {
            return precio * 0.9;
        }
        return precio;
    }

    public double calcularIVA (double basePrice) {
        return basePrice * 1.16;
    }
// se define el bloque de codigo de la interfaz de manera
// independiente y unica para la clase que se implementa.
}