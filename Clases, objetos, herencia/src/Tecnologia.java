class Tecnologia extends Producto {

    //Atributos de la clase hija
    private int reference;
    private String brand;

    public Tecnologia(String name, String tipe,  double basePrice, String code, int stock, int reference, String brand) {
        super(name ,tipe, basePrice, code, stock);
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

}