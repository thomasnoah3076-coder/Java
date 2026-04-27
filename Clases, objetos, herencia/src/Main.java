/*
Clase: es el molde para crear un objeto de manera general.
Objeto: es una instancia de la clase. Es decir es le creacion en si de un objeto, que tiene caracteristicas especificas y propias de el
Modificadores de acceso.
 - Public - desde cualquier punto del programa
 - (default) permite llamar desde el paquete
 - protected - solo desde la misma clase y subclases - se permite acceder desde clases hijas o herencia.
 - Prívate - solo desde dentro de la clase - no va a permitir que una instancia u objeto se le modifiquen sus atributos.
 - Final - se le asigna a una constante - no se puede modificar el valor de una variable desde adentro del programa.
Herencia - una clase padre hereda todos sus atributos y metodos a una clase hija.
Polimorfismo - dos objetos responden de manera diferente a un mismo estimulo llamese metodo, atributo, etc.
 -Polimorfismo por herencia o sobreescritura: Las clases hijas heredan los metodos de las superclases pero pueden sobreescribrlos.
 -Polimorfismo por sobrecarga: ajustando el numero, tipo y orden de los parametros
Abstraccion.
 - Clase abstracta: una clase abtracta es un clase particular, con la cual queremos ejecutar toda la parte logica, pero sin mostrarla
   en otras palabras nos intereza que funcione no como funciona. Una de las caracteristicas mas importantes de una clase abstracta
  es que no se puede instanciar por si sola.
 - Interefaz: es un metodo/s que no se puede implementar ni definirse, sino que la clase que lo implementa debe definirlo de manera
   individual y unica, diferentes subclases pueden tener un "contrato (pueden ser implementadas)" con la misma interfaz.
*/

void main() {
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
