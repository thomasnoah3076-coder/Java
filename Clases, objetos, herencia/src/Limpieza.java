class Limpieza extends Producto implements IVA{

    // Atributos de la clase hija Limpieza
    private String use;
    private String scent;

    public Limpieza(String name,String type, double price, String code, int stock, String use, String scent, String email,Long count, String nameSupplier) {
        super(name,type,price,code,stock,nameSupplier, count, email);
        this.setPrice(calcularIVA(price));
        this.setUse(use);
        this.setScent(scent);
    }

    // Getters y setters
    public String getUse() {
        return use;
    }

    public void setUse(String use) {this.use = use;}

    public String getScent() {return scent;}

    public void setScent(String scent) {this.scent = scent;}

    @Override
    public double descuento(double precio) {
        if (precio >= 50000) {
            return precio * 0.85;
        }
        return precio;
    }

    @Override
    public double calcularIVA(double basePrice){
        return basePrice * 1.19;
    }
// se define el bloque de codigo de la interfaz de manera
// independiente y unica para la clase que se implementa.
}