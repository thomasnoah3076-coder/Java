class Limpieza extends Producto {

    // Atributos de la clase hija Limpieza
    private String use;
    private String scent;

    public Limpieza(String name,String tipe, double price, String code, int stock, String use, String scent) {
        super(name,tipe,price, code, stock);
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

}