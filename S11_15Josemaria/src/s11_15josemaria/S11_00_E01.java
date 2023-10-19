package s11_15josemaria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josem
 */
public class S11_00_E01 {
    // Clase padre
class Persona {
    private final String nombre;
    private final int edad;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }
    
    public void mostrarEdad() {
        System.out.println("Tengo " + edad + " años");
    }
}

// Clase hija 1
class Estudiante extends Persona {
    private final String institucion;
    
    public Estudiante(String nombre, int edad, String institucion) {
        super(nombre, edad);
        this.institucion = institucion;
    }
    
    public void estudiar() {
        System.out.println(nombre + " está estudiando en " + institucion);
    }
    
    public void mostrarInstitucion() {
        System.out.println("Institución: " + institucion);
    }
}

// Clase hija 2
class Empleado extends Persona {
    private final String puesto;
    
    public Empleado(String nombre, int edad, String puesto) {
        super(nombre, edad);
        this.puesto = puesto;
    }
    
    public void trabajar() {
        System.out.println(nombre + " está trabajando como " + puesto);
    }
    
    public void mostrarPuesto() {
        System.out.println("Puesto: " + puesto);
    }
}

// Clase hija 3
class Jubilado extends Persona {
    private final String motivo;
    
    public Jubilado(String nombre, int edad, String motivo) {
        super(nombre, edad);
        this.motivo = motivo;
    }
    
    public void descansar() {
        System.out.println(nombre + " está disfrutando de su jubilación debido a " + motivo);
    }
    
    public void mostrarMotivo() {
        System.out.println("Motivo de jubilación: " + motivo);
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear objetos de cada clase
        Persona persona = new Persona("Juan", 30);
        Estudiante estudiante = new Estudiante("Maria", 20, "Universidad X");
        Empleado empleado = new Empleado("Carlos", 40, "Gerente de Ventas");
        Jubilado jubilado = new Jubilado("Elena", 65, "Jubilación por edad");

        // Usar métodos de las clases
        persona.saludar();
        persona.mostrarEdad();
        
        estudiante.saludar();
        estudiante.mostrarInstitucion();
        estudiante.estudiar();
        
        empleado.saludar();
        empleado.mostrarPuesto();
        empleado.trabajar();
        
        jubilado.saludar();
        jubilado.mostrarMotivo();
        jubilado.descansar();
    }
}

}
