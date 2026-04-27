class Alimentos extends Producto {
    private String flavor;
    private String texture;

    public Alimentos(String name, String tipe, double price, String code, int stock, String flavor, String texture) {
        super(name, tipe, price, code, stock);
        this.setFlavor(flavor);
        this.setTexture(texture);
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    @Override
    public double descuento(double precio) {
        if (precio >= 50000) {
            return precio * 0.8;
        }
        return precio;
    }
}