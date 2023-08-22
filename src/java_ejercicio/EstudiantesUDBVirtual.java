
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_ejercicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class EstudiantesUDBVirtual {
    
    private List<String> estudiantesCarnet;
    private Map<String, String> estudiantes;

    public EstudiantesUDBVirtual() {
        estudiantesCarnet = new ArrayList<>();
        estudiantes = new HashMap<>();
    }

    public void ingresarAlumno() {
        String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet del alumno:");
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del alumno:");
        
        if (estudiantesCarnet.contains(carnet)) {
            JOptionPane.showMessageDialog(null, "El alumno ya se encuentra ingresado");
        } else {
            estudiantesCarnet.add(carnet);
            estudiantes.put(carnet, nombre);
            JOptionPane.showMessageDialog(null, "Alumno ingresado exitosamente");
        }
    }

    public void buscarAlumno() {
        String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet del alumno a buscar:");
        
        if (estudiantesCarnet.contains(carnet)) {
            String nombre = estudiantes.get(carnet);
            JOptionPane.showMessageDialog(null, "Carnet: " + carnet + ", Nombre: " + nombre);
        } else {
            JOptionPane.showMessageDialog(null, "Alumno no encontrado, no se puede mostrar");
        }
    }

    public void eliminarAlumno() {
        String carnet = JOptionPane.showInputDialog(null, "Ingrese el carnet del alumno a eliminar:");
        
        if (estudiantesCarnet.contains(carnet)) {
            estudiantesCarnet.remove(carnet);
            estudiantes.remove(carnet);
            JOptionPane.showMessageDialog(null, "Alumno eliminado exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Alumno no encontrado, no se puede eliminar");
        }
    }

    public void mostrarAlumnos() {
        StringBuilder sb = new StringBuilder();
        
        for (String carnet : estudiantesCarnet) {
            String nombre = estudiantes.get(carnet);
            sb.append("Carnet: ").append(carnet).append(", Nombre: ").append(nombre).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static void main(String[] args) {
        EstudiantesUDBVirtual programa = new EstudiantesUDBVirtual();
        
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Seleccione una opción:\n"
                    + "1. Ingresar alumno\n"
                    + "2. Buscar alumno\n"
                    + "3. Eliminar alumno\n"
                    + "4. Mostrar todos los alumnos\n"
                    + "5. Salir"
            );
            
            switch (opcion) {
                case "1":
                    programa.ingresarAlumno();
                    break;
                case "2":
                    programa.buscarAlumno();
                    break;
                case "3":
                    programa.eliminarAlumno();
                    break;
                case "4":
                    programa.mostrarAlumnos();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        }
    }
}