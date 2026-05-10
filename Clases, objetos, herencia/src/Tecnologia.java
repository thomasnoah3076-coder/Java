class Tecnologia extends Producto implements IVA{

    //Atributos de la clase hija
    private int reference;
    private String brand;

    public Tecnologia(String name, String type,  double basePrice, String code, int stock, int reference, String brand, String email,Long count, String nameSupplier) {
        // "Super" llama al constructor de la clase abstracta Producto.
        super(name ,type, basePrice, code, stock, nameSupplier, count, email);
        // Después modificamos la variable con set price y a su vez
        // con el método de la interfaz.
        this.setPrice(calcularIVA(basePrice));
        this.setReference(reference);
        this.setBrand(brand);
    }

    // Getters y Setters de tecnología.
    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        if (reference <=  0) throw new IllegalArgumentException("Código no valido.");
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
// se define el bloque de código de la interfaz de manera
// independiente y unica para la clase que se implementa.
}