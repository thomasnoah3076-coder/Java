import java.util.*;
// Proveedor es una clase cuyo objetivo es practicar la composición, puesto que cada
// proveedor tiene su nombre, cuenta bancaria, y correo electronico.
public class Proveedor {

    private String nameSupplier;
    private int count;
    private String email;

    public Proveedor (String nameSupplier, int count, String email) {
        this.setNameSupplier(nameSupplier);
        this.setCount(count);
        this.setEmail(email);
    }


    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
            try {
                int digitos = String.valueOf(Math.abs(count)).length();
                if (digitos == 10) {
                    this.count = count;
                } throw new InputMismatchException("La cuenta es invalida.");
            } catch (InputMismatchException e) {
                System.out.println(" Error: Mmm... parece que te hemos pedido un numero pero me has dado otra cosa.");
            }
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
