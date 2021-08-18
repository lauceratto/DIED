package tp.paneles;

import javax.swing.JPanel;

import tp.App.App;
import tp.Exceptions.EstacionException;
import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;
import tp.dominio.Trayecto;
import tp.gestores.GestorEstacion;
import tp.gestores.GestorRuta;
import tp.gestores.GestorTrayecto;
import tp.grafos.Grafos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class PanelAltaTrayecto extends JPanel {
	
	public JTable table;
	private JTextField textField;
	private JTextField textDistancia;
	private JTextField textDuracion;
	private JTextField textCosto;
	private JComboBox<String> comboBoxOrigen;
	private JComboBox<String> comboBoxDestino;
	private GestorTrayecto gestorT = new GestorTrayecto();
	private GestorEstacion gestorE = new GestorEstacion();
	private GestorRuta gestorR = new GestorRuta();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Double distancia;
	private Double duracion;
	private JSpinner cantPasj;
	private JRadioButton rdbtnActiva;
	private JRadioButton rdbtnNoActiva;
	private Grafos grafo = new Grafos();
	
	public PanelAltaTrayecto(String nombreTransporte,App app) {
		setLayout(null);
		
		JLabel lblTransporte = new JLabel("Transporte");
		lblTransporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTransporte.setBounds(504, 84, 120, 27);
		add(lblTransporte);

		textField = new JTextField(nombreTransporte);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setEnabled(false);
		textField.setBounds(665, 89, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Estacion Origen");
		lblNewLabel_1.setBounds(504, 164, 99, 14);
		add(lblNewLabel_1);
		
		comboBoxOrigen = new JComboBox<String>();
		comboBoxOrigen.setBounds(665, 160, 108, 22);

		Map<Object, Object> estaciones = grafo.pageRank(gestorE.getEstacionesDisponibles());
		List<String> listaOrdenada = new ArrayList<String>();
		for (Entry<Object, Object> entry : estaciones.entrySet()) {
			   listaOrdenada.add((String) entry.getKey());
				//System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
			}
			
			Collections.reverse(listaOrdenada);
		for(String em : listaOrdenada) {
			this.comboBoxOrigen.addItem(em);
		}
		this.comboBoxOrigen.setSelectedItem(null);
		add(comboBoxOrigen);
		
		JLabel lblNewLabel_2 = new JLabel("Estacion Destino");
		lblNewLabel_2.setBounds(823, 164, 99, 14);
		add(lblNewLabel_2);
		
		comboBoxDestino = new JComboBox<String>();
		comboBoxDestino.setBounds(980, 160, 108, 22);

		for(String em : listaOrdenada) {
			this.comboBoxDestino.addItem(em);
		}
		this.comboBoxDestino.setSelectedItem(null);
		add(comboBoxDestino);
		
		JLabel lblNewLabel_3 = new JLabel("Distancia (Km)");
		lblNewLabel_3.setBounds(504, 235, 87, 14);
		add(lblNewLabel_3);
		
		textDistancia = new JTextField();
		textDistancia.setBounds(665, 232, 86, 20);
		add(textDistancia);
		textDistancia.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Duracion (Min)");
		lblNewLabel_4.setBounds(823, 235, 87, 14);
		add(lblNewLabel_4);
		
		textDuracion = new JTextField();
		textDuracion.setColumns(10);
		textDuracion.setBounds(980, 232, 86, 20);
		add(textDuracion);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad Max. de pasajeros");
		lblNewLabel_5.setBounds(504, 314, 189, 14);
		add(lblNewLabel_5);
		cantPasj = new JSpinner();
		cantPasj.setBounds(665, 315, 46, 20);
		add(cantPasj);
		
		JLabel lblNewLabel_6 = new JLabel("Costo ");
		lblNewLabel_6.setBounds(823, 314, 69, 14);
		add(lblNewLabel_6);
		
		textCosto = new JTextField();
		textCosto.setBounds(980, 311, 86, 20);
		add(textCosto);
		textCosto.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setBounds(504, 385, 61, 14);
		add(lblNewLabel_7);
		
		rdbtnActiva = new JRadioButton("Activa");
		rdbtnActiva.setBounds(665, 381, 109, 23);
		buttonGroup.add(rdbtnActiva);
		add(rdbtnActiva);
		
		rdbtnNoActiva = new JRadioButton("No activa");
		rdbtnNoActiva.setBounds(823, 381, 109, 23);
		buttonGroup.add(rdbtnNoActiva);
		add(rdbtnNoActiva);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setIcon(new ImageIcon(PanelAltaEstacion.class.getResource("/tp/App/guardar.png")));
		btnGuardar.setBounds(616, 457, 135, 35);
		btnGuardar.addActionListener(e -> {
			distancia = Double.parseDouble(this.textDistancia.getText().trim());
			duracion = Double.parseDouble(this.textDuracion.getText().trim());
			Double costo = Double.parseDouble(this.textCosto.getText().trim());
			String origen = comboBoxOrigen.getSelectedItem().toString();
			String destino = comboBoxDestino.getSelectedItem().toString();
			Integer cantPasajeros = (Integer) this.cantPasj.getValue();
			
			Boolean estado = false;
			if(rdbtnActiva.isSelected()) estado = true;
				else estado = false;
			try {
				Ruta ruta = new Ruta(nombreTransporte,origen,destino,distancia, duracion, cantPasajeros, estado, costo);
				gestorR.crearRuta(ruta);
				gestorT.guardarTrayecto(origen, destino, nombreTransporte);
				int n = JOptionPane.showConfirmDialog( null, "Desea crear una nueva ruta?", "Mensaje", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					limpiarformulario();
				}else {
					this.setVisible(false);
					app.setContentPane(new PanelTransporte(app));
					app.pack();
					app.revalidate();
					app.repaint();
					app.setSize(1020, 720);
					app.setLocationRelativeTo(null);
					app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				}
			}catch(EstacionException e1) {
				e1.printStackTrace();
			};
						
		});
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(813, 457, 109, 35);
		btnCancelar.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelTransporte(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnCancelar);
		
		
	}
	public void limpiarformulario() {
		this.textDistancia.setText("");
		this.textDuracion.setText("");
		this.textCosto.setText("");
		this.comboBoxOrigen.setSelectedItem(null);
		this.comboBoxDestino.setSelectedItem(null);
		this.cantPasj.setValue(0);
		this.rdbtnActiva.setSelected(false);
		this.rdbtnNoActiva.setSelected(false);
	}
}
