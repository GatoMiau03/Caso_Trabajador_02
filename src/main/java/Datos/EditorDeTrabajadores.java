package Datos;

import modelo.Trabajador;
import java.util.ArrayList;
import java.util.Scanner;

public class EditorDeTrabajadores {
    private ArrayList<Trabajador> listaTrabajadores;

    public EditorDeTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }

    public void agregarTrabajador(Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Isapre: ");
        String isapre = scanner.nextLine();
        System.out.print("AFP: ");
        String afp = scanner.nextLine();

        Trabajador nuevoTrabajador = new Trabajador(nombre, apellido, rut, isapre, afp);
        listaTrabajadores.add(nuevoTrabajador);
        System.out.println("Trabajador agregado correctamente.");
    }

    public void editarTrabajador(Scanner scanner) {
        System.out.print("Ingrese el RUT del trabajador que desea editar: ");
        String rutBuscado = scanner.nextLine();
        Trabajador trabajadorEncontrado = null;
        for (Trabajador trabajador : listaTrabajadores) {
            if (trabajador.getRut().equals(rutBuscado)) {
                trabajadorEncontrado = trabajador;
                break;
            }
        }

        if (trabajadorEncontrado != null) {
            System.out.println("Trabajador encontrado. Ingrese los nuevos datos:");
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();
            trabajadorEncontrado.setNombre(nuevoNombre);

            System.out.print("Nuevo apellido: ");
            String nuevoApellido = scanner.nextLine();
            trabajadorEncontrado.setApellido(nuevoApellido);

            System.out.print("Nueva isapre: ");
            String nuevaIsapre = scanner.nextLine();
            trabajadorEncontrado.setIsapre(nuevaIsapre);

            System.out.print("Nueva AFP: ");
            String nuevaAfp = scanner.nextLine();
            trabajadorEncontrado.setAfp(nuevaAfp);

            System.out.println("Datos del trabajador actualizados correctamente.");
        } else {
            System.out.println("Trabajador no encontrado.");
        }
    }

    public void eliminarTrabajador(Scanner scanner) {
        System.out.print("Ingrese el RUT del trabajador que desea eliminar: ");
        String rutBuscado = scanner.nextLine();

        Trabajador trabajadorAEliminar = null;

        for (Trabajador trabajador : listaTrabajadores) {
            if (trabajador.getRut().equals(rutBuscado)) {
                trabajadorAEliminar = trabajador;
                break;
            }
        }

        if (trabajadorAEliminar != null) {
            listaTrabajadores.remove(trabajadorAEliminar);
            System.out.println("Trabajador eliminado correctamente.");
        } else {
            System.out.println("Trabajador no encontrado.");
        }
    }

    public void buscarTrabajador(Scanner scanner) {
        System.out.print("Ingrese el RUT del trabajador que desea buscar: ");
        String rutBuscado = scanner.nextLine();

        for (Trabajador trabajador : listaTrabajadores) {
            if (trabajador.getRut().equals(rutBuscado)) {
                System.out.println("Trabajador encontrado: " + trabajador.getNombreCompleto());
                return;
            }
        }

        System.out.println("Trabajador no encontrado.");
    }
}
