package Datos;

import modelo.Trabajador;

import java.util.ArrayList;

public class ListaDeTrabajadores {
    private ArrayList<Trabajador> trabajadores;

    public ListaDeTrabajadores() {
        this.trabajadores = new ArrayList<>();
        trabajadores.add(new Trabajador("Carlos", "Perez", "12345678-9", "IsapreA", "AFP1"));
        trabajadores.add(new Trabajador("Diego", "Beñaldo", "98765432-1", "IsapreB", "AFP2"));
        trabajadores.add(new Trabajador("David", "Jara", "11111111-1", "IsapreC", "AFP3"));
    }

    public void agregarTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }
}
