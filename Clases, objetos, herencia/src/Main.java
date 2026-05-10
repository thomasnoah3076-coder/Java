import java.util.*;

    void main() throws Excepciones.NombreVacioException, Excepciones.StockNoValidoException, Excepciones.PrecioNoValidoException, Excepciones.CuentaNoValidaException, Excepciones.CodigoNoValidoException {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        ArrayList<Producto> listaProductos = new ArrayList<>();

        while (continuar) {
            IO.println("Bienvenido.\n 1. Desea añadir algun producto.\n 2. Desea ver algun producto.\n 3. Cantidad de productos disponibles. \n 4. Salir del programa. \n Rcuerde que nuestra tienda tiene un descuento para productos genericos del 10%, \n productos de limpieza del 15%, productos de tecnología del 5%, de alimentos \n del 20%.   ");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                Producto.nuevoObjeto(sc, listaProductos);
            } else if (option == 2) {
                Producto.buscarProducto(sc, listaProductos);
            } else if (option == 3) {
                IO.println("Productos registrados: " + Producto.getTotalProductos());
            } else if (option == 4) {
                continuar = false;
            } else {
                IO.println("Opcion no valida ");
            }
        }

    }

