public class Excepciones  {
    // Exceptions es una clase que tiene un atributo privado mensaje;
    // al utilizar super llamamos al constructor de esa clase padre
    // y le decimos que guarde ese mensaje en ese atributo, con
    // esto también logramos utilizar sus métodos tales como:
    // .getMessage(); que devolverá el mensaje que le demos.
    // .printStackTrace();  Mostrará el error en consola incluyendo la descripción que escribiste.


    // Utilizamos la palabra reservada static para poder hacer
    // uso de sus métodos sin necesidad de instanciar la clase
    public static class NombreVacioException extends Exception  {
        public NombreVacioException (String mensaje){
            super(mensaje);
        }
    }

    public static class PrecioNoValidoException extends Exception{
        public PrecioNoValidoException (String mensaje){
            super(mensaje);
        }
    }

    public static class CodigoNoValidoException extends Exception{
        public CodigoNoValidoException (String mensaje){
            super(mensaje);
        }
    }

    public static class StockNoValidoException extends Exception {
        public StockNoValidoException (String mensaje){
            super(mensaje);
        }
    }

    public static class CuentaNoValidaException extends Exception {
        public CuentaNoValidaException(String mensaje){
            super(mensaje);
        }
    }

}
