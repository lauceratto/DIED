package tp.paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tp.dominio.EstacionMultimodal;
import tp.gestores.GestorEstacion;
import tp.gestores.GestorTrayecto;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelAgregarEstacion extends JFrame {
	private GestorEstacion gestorE = new GestorEstacion(); 
	private JComboBox<String> comboBox;
	private GestorTrayecto gestorT = new GestorTrayecto();

	public PanelAgregarEstacion(String nombreTransporte) {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(281, 94, 89, 23);
		btnGuardar.addActionListener(l -> {
			//Conectar las estaciones como si fueran nodos. GRAFOS
			//Guardar en base de datos
			String nombreEstacion = comboBox.getSelectedItem().toString();
			//System.out.println(nombreEstacion);
			//Se guardan los trayectos a los que l
			gestorT.guardarTrayecto(nombreEstacion,nombreTransporte);
			
		});
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(281, 140, 89, 23);
		add(btnCancelar);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(91, 115, 121, 22);
		List<EstacionMultimodal> estaciones = new ArrayList<EstacionMultimodal>();
		estaciones = gestorE.getEstaciones();
		for(EstacionMultimodal est : estaciones) {
			this.comboBox.addItem(est.getNombre());
		}
		this.comboBox.setSelectedItem(null);
		add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Estacion");
		lblNewLabel.setBounds(91, 98, 62, 14);
		add(lblNewLabel);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
		
		
	}

}
