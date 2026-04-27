import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private String name;
    private String type;
    private double price;
    private double finalPrice;
    private String code;
    private int stock;
    private static int totalProductos;

    public Producto(String name, String tipe, double baseprice, String code, int stock) {
        this.name = name;
        this.setType(tipe);
        this.setPrice(baseprice);
        this.setFinalPrice(descuento(baseprice));
        this.setCode(code);
        this.setStock(stock);
        totalProductos++;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {this.type = type;}

    public double getPrice(  ) {return price;}

    public void setPrice(double price) {
        if (price <= 0.0) throw new IllegalArgumentException("El precio no puede tomar ese valor.");
        this.price = price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null && code.startsWith("C")) this.code = code;
        else throw new IllegalArgumentException("El código debe empezar por una C mayúscula.");
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("El stock no puede ser negativo.");
        this.stock = stock;
    }
    public static int getTotalProductos() {
        return totalProductos;
    }

    // Buscar producto
    public static void buscarProducto(Scanner sc, ArrayList<Producto> listaProductos) {
        System.out.println("Ingrese el código del producto:");
        String code = sc.nextLine();
        boolean encontrado = false;

        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto p : listaProductos) {
            if (p.getCode().equals(code)) {
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + p.getName());
                System.out.println("Precio de ingreso: " + p.getPrice());
                if (p.getType().equalsIgnoreCase("Limpieza")){
                    System.out.println("Precio con descuento: " + ((Limpieza) p).getFinalPrice());
                    System.out.println("Tipo:" + p.getType());
                    System.out.println("Uso:" + ((Limpieza) p).getUse());
                    System.out.println("Aroma:" + ((Limpieza) p).getScent());
                }else if (p.getType().equalsIgnoreCase("tecnologia") || p.getType().equalsIgnoreCase("tecnología")) {
                    System.out.println("Precio con descuento: " + ((Tecnologia) p).getFinalPrice());
                    System.out.println("Tipo:" + p.getType());
                    System.out.println("Referencia (numérica): " + ((Tecnologia) p).getReference());
                    System.out.println("Marca: " + ((Tecnologia) p).getReference());
                } else if (p.getType().equalsIgnoreCase("alimentos")) {
                    System.out.println("Precio con descuento: " + ((Alimentos) p).getFinalPrice());
                    System.out.println("Tipo:" + p.getType());
                    System.out.println("Sabor: "+ ((Alimentos) p).getFlavor());
                    System.out.println("Textura: "+ ((Alimentos)p).getTexture());

                } else {
                    System.out.println("Precio con descuento: " + p.getFinalPrice());
                }
                System.out.println("Código: " + p.getCode());
                System.out.println("Stock: " + p.getStock());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void nuevoObjeto(Scanner sc, ArrayList<Producto> listaProductos) {
        System.out.println("\n--- Registro de Nuevo Producto ---");
        System.out.print("Nombre: ");
        String name = sc.nextLine();

        System.out.print("Tipo (Limpieza/Tecnologia/Alimentos): ");
        String tipe = sc.nextLine().trim();        // por que lee el salto de linea anterior como si fuese un espacio esta funcion ignora el salto de linea

        System.out.print("Precio: ");
        double price = sc.nextDouble();

        sc.nextLine(); // Limpiar buffer

        System.out.print("Código (C...): ");
        String code = sc.nextLine();

        System.out.print("Stock inicial: ");
        int stock = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (tipe.equalsIgnoreCase("limpieza")) {
            System.out.print("Uso: ");
            String use = sc.nextLine();
            System.out.print("Aroma: ");
            String scent = sc.nextLine();
            listaProductos.add(new Limpieza(name, tipe, price, code, stock, use, scent));
        } else if (tipe.equalsIgnoreCase("tecnologia") || tipe.equalsIgnoreCase("tecnología")) {
            System.out.print("Referencia (numérica): ");
            int ref = sc.nextInt();
            sc.nextLine(); // Limpiar buffer antes de leer String
            System.out.print("Marca: ");
            String brand = sc.nextLine();
            listaProductos.add(new Tecnologia(name, tipe, price, code, stock, ref, brand));
        } else if (tipe.equalsIgnoreCase("alimentos")) {
            System.out.print("Sabor: ");
            String flavor = sc.nextLine();
            System.out.print("Textura: ");
            String texture = sc.nextLine();
            listaProductos.add(new Alimentos(name, tipe, price, code, stock, flavor, texture));
        } else {
            System.out.println("Tipo no reconocido. Creando producto genérico...");
            listaProductos.add(new Producto(name, tipe, price, code, stock));
        }
        System.out.println("¡Producto registrado con éxito!");
    }

    public double descuento(double precio) {
        if (precio > 0){
            if (precio >= 50000) {
            return precio * 0.9;
        }
            return precio;
        } throw new IllegalArgumentException("El precio no es valido.");
    }

}
