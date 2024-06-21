package guis;

import Datos.ListaDeTrabajadores;
import modelo.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaMostrarDatos extends JFrame {
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField rutTextField;
	private JTextField isapreTextField;
	private JTextField afpTextField;
	private ListaDeTrabajadores listaDeTrabajadores;

	public VentanaMostrarDatos(ListaDeTrabajadores listaDeTrabajadores) {
		this.listaDeTrabajadores = listaDeTrabajadores;

		setTitle("Gestión de Trabajadores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		nombreTextField = new JTextField(20);
		apellidoTextField = new JTextField(20);
		rutTextField = new JTextField(20);
		isapreTextField = new JTextField(20);
		afpTextField = new JTextField(20);

		JButton btnAgregar = new JButton("Agregar Trabajador");
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarTrabajador();
			}
		});

		JButton btnMostrar = new JButton("Mostrar Trabajadores");
		btnMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarTrabajadores();
			}
		});

		JPanel panel = new JPanel(new GridLayout(7, 2));
		panel.add(new JLabel("Nombre:"));
		panel.add(nombreTextField);
		panel.add(new JLabel("Apellido:"));
		panel.add(apellidoTextField);
		panel.add(new JLabel("RUT:"));
		panel.add(rutTextField);
		panel.add(new JLabel("Isapre:"));
		panel.add(isapreTextField);
		panel.add(new JLabel("AFP:"));
		panel.add(afpTextField);
		panel.add(btnAgregar);
		panel.add(btnMostrar);

		getContentPane().add(panel);
		pack(); // Ajustar automáticamente el tamaño del JFrame
		setLocationRelativeTo(null); // Centrar la ventana en la pantalla
		setVisible(true);
	}

	private void agregarTrabajador() {
		String nombre = nombreTextField.getText();
		String apellido = apellidoTextField.getText();
		String rut = rutTextField.getText();
		String isapre = isapreTextField.getText();
		String afp = afpTextField.getText();

		if (!nombre.isEmpty() && !apellido.isEmpty() && !rut.isEmpty() && !isapre.isEmpty() && !afp.isEmpty()) {
			Trabajador nuevoTrabajador = new Trabajador(nombre, apellido, rut, isapre, afp);
			listaDeTrabajadores.agregarTrabajador(nuevoTrabajador);
			JOptionPane.showMessageDialog(this, "Trabajador agregado correctamente");
			limpiarCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void mostrarTrabajadores() {
		ArrayList<Trabajador> trabajadores = listaDeTrabajadores.getTrabajadores();
		StringBuilder sb = new StringBuilder();
		sb.append("Lista de Trabajadores:\n");

		for (Trabajador trabajador : trabajadores) {
			sb.append("Nombre: ").append(trabajador.getNombre()).append(", ");
			sb.append("Apellido: ").append(trabajador.getApellido()).append(", ");
			sb.append("RUT: ").append(trabajador.getRut()).append(", ");
			sb.append("Isapre: ").append(trabajador.getIsapre()).append(", ");
			sb.append("AFP: ").append(trabajador.getAfp()).append("\n");
		}

		JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Trabajadores", JOptionPane.INFORMATION_MESSAGE);
	}

	private void limpiarCampos() {
		nombreTextField.setText("");
		apellidoTextField.setText("");
		rutTextField.setText("");
		isapreTextField.setText("");
		afpTextField.setText("");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ListaDeTrabajadores listaDeTrabajadores = new ListaDeTrabajadores();
				new VentanaMostrarDatos(listaDeTrabajadores);
			}
		});
	}
}
