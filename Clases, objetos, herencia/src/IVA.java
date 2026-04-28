// IVA es una interfaz, esta interfaz se caracteriza por tener metodos, sean vacio
// o con retorno, con paramertro o sin parametros, pero sin cuerpo o bloque de
// codigo, ya que el encargado de definirlos es la clase con la que se implementan
// o en otras palabras con las que firman un contrato.
interface IVA {
    public double calcularIVA(double basePrice);
}
