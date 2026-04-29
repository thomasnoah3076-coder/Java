# Curso de Java - MoureDev ☕

Este repositorio contiene los apuntes, ejercicios y conceptos fundamentales aprendidos durante el curso de **Java desde cero** impartido por [MoureDev](https://www.youtube.com/watch?v=JOAqpdM36wI&t=29037s).

El objetivo de este proyecto es servir como guía de referencia para los pilares de la Programación Orientada a Objetos (POO) y el desarrollo en Java .

## 🚀 Conceptos Fundamentales

### 1. Clases y Objetos
* **Clase:** Es el "molde" o plantilla general para crear objetos. Define los atributos y comportamientos comunes.
* **Objeto:** Es una instancia de una clase. Representa una entidad específica con características propias y valores únicos.

### 2. Modificadores de Acceso y Palabras Reservadas
Controlan el nivel de visibilidad de los atributos y métodos:

| Modificador | Visibilidad |
| :--- | :--- |
| `public` | Accesible desde cualquier punto del programa. |
| `(default)` | Accesible solo desde el mismo paquete. |
| `protected` | Accesible desde la misma clase y subclases (herencia). |
| `private` | Solo accesible dentro de la propia clase; protege los atributos de modificaciones externas directas. |
| `final` | Define una constante; el valor de la variable no puede ser modificado una vez asignado. |

---

### 3. Herencia
Mecanismo donde una **clase padre** (superclase) transmite sus atributos y métodos a una **clase hija** (subclase).

* **Palabra reservada `super`:** * Permite llamar al constructor de la superclase para inicializar atributos de forma sencilla.
    * Se utiliza para invocar métodos de la superclase cuando tienen el mismo nombre que los de la clase hija, facilitando su distinción.

---

### 4. Polimorfismo
Capacidad de que diferentes objetos respondan de manera distinta a un mismo estímulo o método.

* **Polimorfismo por herencia (Sobreescritura):** Las clases hijas utilizan métodos heredados pero modifican su comportamiento específico.
* **Polimorfismo por sobrecarga:** Se define el mismo método varias veces, pero ajustando el número, tipo u orden de los parámetros.

---

### 5. Abstracción
Se centra en el "qué hace" un objeto más que en el "cómo lo hace", ocultando la complejidad lógica.

* **Clase Abstracta (`abstract`):** * Es una clase particular diseñada para ejecutar lógica pero que **no puede ser instanciada** por sí sola.
    * Ejemplo: `public abstract class Producto { ... }`
* **Interfaz:** * Funciona como un "contrato". Define métodos que deben ser implementados de manera obligatoria por las clases que la utilicen.
    * Diferentes subclases pueden implementar la misma interfaz de formas únicas e individuales.

---

### 6. Manejo de Errores
Implementación de bloques para gestionar excepciones y asegurar que el programa pueda responder ante fallos inesperados sin detener su ejecución bruscamente.

---

## 🛠️ Tecnologías utilizadas
* **Lenguaje:** Java 17+
* **IDE recomendada:** IntelliJ IDEA o VS Code
* **Gestor de versiones:** Git

## 🔗 Referencias
* [Video del Curso Completo - MoureDev](https://www.youtube.com/watch?v=JOAqpdM36wI&t=29037s)
