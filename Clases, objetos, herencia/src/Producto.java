import java.util.ArrayList;
import java.util.Scanner;

public abstract class Producto  {
    private String name;
    private String type;
    private double price;  // se crea una variable price para que el usuario ingrese el precio de su producto.
    private double finalPrice;  // se crea otra variable para el precio final que sera sometida a un descuento.
    private String code;
    private int stock;
    private static int totalProductos;

    // el constructor de Producto al ser la clase padre (el cual es abstracto) inicializa el proceso de la construccion
    // de objetos, despues de que haya atribuido cada parametro a cada atributo, envia la informacion a los
    // constreuctores de sus clase hijas, los cuales puede decidir modificarlas segun les convenga.
    public Producto(String name, String tipe, double baseprice, String code, int stock) {
        this.setName(name);
        this.setType(tipe);

        // estos dos atributos trabajan con el mismo atributo. Lo dos lo validan, pero uno lo guarda tal cual
        // (despues se modifica con la interfaz iva) y el otro le aplica un descuento.
        this.setPrice(baseprice);
        this.setFinalPrice(descuento(baseprice));

        // Como descuento es un metodo abstracto, cada clase hijas define su contenido y como todas las clase hijas
        // tienen su descuento definido esto no causa errores en el constructor de esta clase.

        this.setCode(code);
        this.setStock(stock);
        totalProductos++;
    }

    // Getters y setters:  se utilizan generalmente para el encapsulamiento. El metodo de nombre
    // get que se la asocia a un atributo para acceder a el. El metodo set para modificarlo.
    public String getName() {
        return name;
    }

    // comentario de prueba

    public void setName(String name) {
        this.name = name;
//      this se utiliza para referirse a un atributo de una clase y name es la variable(parametro)
//      que se el asigna al objeto para su cración.
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {this.type = type;}

    public double getPrice(  ) {return price;}

    public void setPrice(double price) {
        if (price <= 0.0) throw new IllegalArgumentException("El precio no puede tomar ese valor.");
//      Si el precio tiene un valor igual o menor a 0 el programa se rompe, si es mayor a 0 se le
//      asigna el valor al atributo para la creacion del objeto.
        this.price = price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        if (finalPrice <= 0.0) throw new IllegalArgumentException("El precio no puede tomar ese valor.");
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

        //Primero verificamos si la lista esta vacio, para que no de
        // vueltas buscando productos que no existen.
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        // se crea p que es un objeto de la clase producto de manera temporal y lo ponemos a recorrer la lista.
        // lo que estamos haciendo es guardar en una variable p el objeto para poder utilizar sus metodos.
        for (Producto p : listaProductos) {
            if (p.getCode().equals(code)) {
                System.out.println("---Producto encontrado---");
                System.out.println("Nombre: " + p.getName());
                System.out.println("Precio de ingreso: " + p.getPrice());
                if (p.getType().equalsIgnoreCase("Limpieza")){
                    // lo que estamos haciendo aca es un casteo forzado, como se guardaron objetos de
                    // tipo producto en la array list, y necasitamos acceder a los atributos internos
                    // de un producto especifico, lo convertimos temporalmente en el objeto necesario.
                    // Tecnologia temp = (Tecnologia) p;
                    System.out.println("Precio con descuento e IVA: " + ((Limpieza) p).getFinalPrice());
                    System.out.println("Tipo:" + p.getType());
                    System.out.println("Uso:" + ((Limpieza) p).getUse());
                    System.out.println("Aroma:" + ((Limpieza) p).getScent());
                }else if (p.getType().equalsIgnoreCase("tecnologia") || p.getType().equalsIgnoreCase("tecnología")) {
                    System.out.println("Precio con descuento e IVA: " + ((Tecnologia) p).getFinalPrice());
                    System.out.println("Tipo:" + p.getType());
                    System.out.println("Referencia (numérica): " + ((Tecnologia) p).getReference());
                    System.out.println("Marca: " + ((Tecnologia) p).getReference());
                } else if (p.getType().equalsIgnoreCase("alimentos")) {
                    System.out.println("Precio : " + ((Alimentos) p).getFinalPrice());
                    System.out.println("Tipo:" + p.getType());
                    System.out.println("Sabor: "+ ((Alimentos) p).getFlavor());
                    System.out.println("Textura: "+ ((Alimentos)p).getTexture());

                } else {
                    System.out.println("Precio con descuento e IVA: " + p.getFinalPrice());
                    System.out.println("Precio con iva: ");
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
            listaProductos.add(new Generico(name, tipe, price, code, stock));
        }
        System.out.println("¡Producto registrado con éxito!");
    }

    public abstract double descuento(double basePrice) ;
}
