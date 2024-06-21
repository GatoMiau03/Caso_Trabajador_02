package modelo;

import Datos.ListaDeTrabajadores;
import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ListaDeTrabajadores listaDeTrabajadores;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.listaDeTrabajadores = new ListaDeTrabajadores();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarTrabajador(Trabajador trabajador) {
		listaDeTrabajadores.agregarTrabajador(trabajador);
	}

	public void eliminarTrabajador(String rut) {
		listaDeTrabajadores.getTrabajadores().removeIf(trabajador -> trabajador.getRut().equals(rut));
	}

	public Trabajador buscarTrabajador(String rut) {
		for (Trabajador trabajador : listaDeTrabajadores.getTrabajadores()) {
			if (trabajador.getRut().equals(rut)) {
				return trabajador;
			}
		}
		return null;
	}

	public void mostrarTrabajadores() {
		for (Trabajador trabajador : listaDeTrabajadores.getTrabajadores()) {
			System.out.println(trabajador.getNombreCompleto() + " - RUT: " + trabajador.getRut() + " - Isapre: " + trabajador.getIsapre() + " - AFP: " + trabajador.getAfp());
		}
	}

	public ArrayList<Trabajador> getListaDeTrabajadores() {
		return listaDeTrabajadores.getTrabajadores();
	}
}
