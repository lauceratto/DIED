package tp.paneles;

import javax.swing.JPanel;

import tp.App.App;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;

public class PanelAltaTrayecto extends JPanel {
	public JTable table;
	private TrayectoTableModel modeloTabla;
	private JTextField textField;
	private JTextField textDistancia;
	private JTextField textDuracion;
	private JTextField textCantPasajeros;
	private JTextField textCosto;
	public PanelAltaTrayecto(String nombreTransporte,App app) {
		setLayout(null);
		
		JLabel lblTransporte = new JLabel("Transporte");
		lblTransporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTransporte.setBounds(548, 71, 120, 27);
		add(lblTransporte);
		
		JButton btnAgregar = new JButton("Agregar trayecto");
		btnAgregar.setBounds(931, 166, 153, 23);
		btnAgregar.addActionListener(l -> {
			PanelAgregarEstacion panel = new PanelAgregarEstacion(nombreTransporte);
			panel.setVisible(true);
		});
		add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar trayecto");
		btnEliminar.setBounds(931, 234, 153, 23);
		add(btnEliminar);
		
		modeloTabla = new TrayectoTableModel();
		table = new JTable();
		table.setModel(modeloTabla);
		table.setBounds(416, 408, 728, -250);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(321, 146);
		scrollPane.setLocation(548, 138);
		this.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Trayectos");
		lblNewLabel.setBounds(548, 125, 87, 14);
		add(lblNewLabel);
		
		textField = new JTextField(nombreTransporte);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setEnabled(false);
		textField.setBounds(730, 76, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Estacion Origen");
		lblNewLabel_1.setBounds(548, 318, 99, 14);
		add(lblNewLabel_1);
		
		JComboBox comboBoxOrgien = new JComboBox();
		comboBoxOrgien.setBounds(665, 314, 108, 22);
		add(comboBoxOrgien);
		
		JLabel lblNewLabel_2 = new JLabel("Estacion Destino");
		lblNewLabel_2.setBounds(823, 318, 99, 14);
		add(lblNewLabel_2);
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setBounds(931, 314, 108, 22);
		add(comboBoxDestino);
		
		JLabel lblNewLabel_3 = new JLabel("Distancia (Km)");
		lblNewLabel_3.setBounds(548, 361, 87, 14);
		add(lblNewLabel_3);
		
		textDistancia = new JTextField();
		textDistancia.setBounds(665, 358, 86, 20);
		add(textDistancia);
		textDistancia.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Duracion (Min)");
		lblNewLabel_4.setBounds(823, 361, 87, 14);
		add(lblNewLabel_4);
		
		textDuracion = new JTextField();
		textDuracion.setColumns(10);
		textDuracion.setBounds(931, 358, 86, 20);
		add(textDuracion);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad Max. de pasajeros");
		lblNewLabel_5.setBounds(548, 404, 153, 14);
		add(lblNewLabel_5);
		
		textCantPasajeros = new JTextField();
		textCantPasajeros.setBounds(730, 401, 86, 20);
		add(textCantPasajeros);
		textCantPasajeros.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Costo ");
		lblNewLabel_6.setBounds(853, 404, 69, 14);
		add(lblNewLabel_6);
		
		textCosto = new JTextField();
		textCosto.setBounds(931, 401, 86, 20);
		add(textCosto);
		textCosto.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setBounds(548, 445, 61, 14);
		add(lblNewLabel_7);
		
		JRadioButton rdbtnActiva = new JRadioButton("Activa");
		rdbtnActiva.setBounds(628, 441, 109, 23);
		add(rdbtnActiva);
		
		JRadioButton rdbtnNoActiva = new JRadioButton("No activa");
		rdbtnNoActiva.setBounds(750, 441, 109, 23);
		add(rdbtnNoActiva);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(665, 505, 89, 23);
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(833, 505, 89, 23);
		add(btnCancelar);
	}
}
