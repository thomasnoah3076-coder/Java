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
        this.count = count;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
