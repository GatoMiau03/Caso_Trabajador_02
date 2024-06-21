package main;

import Datos.ListaDeTrabajadores;
import guis.VentanaMostrarDatos;

import javax.swing.*;

public class Launcher {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ListaDeTrabajadores listaDeTrabajadores = new ListaDeTrabajadores();
				VentanaMostrarDatos ventana = new VentanaMostrarDatos(listaDeTrabajadores);
			}
		});
	}
}
