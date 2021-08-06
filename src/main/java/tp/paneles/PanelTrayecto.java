package tp.paneles;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tp.App.App;
import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;
import tp.dominio.Transporte;
import tp.dominio.Trayecto;
import tp.gestores.GestorEstacion;
import tp.gestores.GestorRuta;
import tp.gestores.GestorTransporte;
import tp.gestores.GestorTrayecto;
import tp.grafos.Grafos;

import java.awt.Font;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextArea;

public class PanelTrayecto extends JPanel {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GestorEstacion gestorE = new GestorEstacion(); 
	private GestorTransporte gestorTran = new GestorTransporte();
	private GestorTrayecto gestorT = new GestorTrayecto();
	private GestorRuta gestorR = new GestorRuta();
	private JComboBox<String> comboBoxOrigen;
	private JComboBox<String> comboBoxDestino;
	private Grafos grafo = new Grafos();
	private JComboBox<String> comboBoxTransporte;
	private List<List<String>> cam;
	
	
	public PanelTrayecto(App app) {
		setLayout(null);
		
		comboBoxOrigen = new JComboBox<String>();
		comboBoxOrigen.setBounds(507, 202, 131, 22);
		List<String> estaciones = new ArrayList<String>();
		estaciones = grafo.pageRank();
		for(String est : estaciones) {
			this.comboBoxOrigen.addItem(est);
		}
		this.comboBoxOrigen.setSelectedItem(null);
		add(comboBoxOrigen);
		
		JLabel lblOrigen = new JLabel("ORIGEN");
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setBounds(425, 206, 72, 14);
		
		add(lblOrigen);
		
		JLabel lblDestino = new JLabel("DESTINO");
		lblDestino.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestino.setBounds(710, 206, 92, 14);
		add(lblDestino);
		
		comboBoxDestino = new JComboBox<String>();
		comboBoxDestino.setBounds(812, 202, 131, 22);
		for(String est : estaciones) {
			this.comboBoxDestino.addItem(est);
		}
		this.comboBoxDestino.setSelectedItem(null);
		add(comboBoxDestino);
		
		JLabel lblNewLabel_7 = new JLabel("Camino a seguir");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(436, 513, 107, 22);
		lblNewLabel_7.setVisible(false);
		add(lblNewLabel_7);

		JRadioButton rdbtnMasRapido = new JRadioButton("M\u00E1s r\u00E1pido");
		rdbtnMasRapido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMasRapido.setBounds(710, 513, 97, 23);
		rdbtnMasRapido.setVisible(false);
		buttonGroup.add(rdbtnMasRapido);
		add(rdbtnMasRapido);

		JRadioButton rdbtnDistancia = new JRadioButton("Menor distancia");
		rdbtnDistancia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnDistancia.setBounds(836, 513, 126, 22);
		rdbtnDistancia.setVisible(false);
		buttonGroup.add(rdbtnDistancia);
		add(rdbtnDistancia);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("M\u00E1s barato");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(576, 513, 109, 23);
		rdbtnNewRadioButton_2.setVisible(false);
		buttonGroup.add(rdbtnNewRadioButton_2);
		add(rdbtnNewRadioButton_2);
		
		JLabel lblNewLabel = new JLabel("Lista de Trayectos");
		lblNewLabel.setBounds(436, 328, 120, 14);
		lblNewLabel.setVisible(false);
		add(lblNewLabel);
		
		JButton btnComprarBoleto = new JButton("Comprar Boleto");
		btnComprarBoleto.setVisible(false);
		btnComprarBoleto.setBounds(616, 586, 168, 23);
		btnComprarBoleto.addActionListener(l -> {
			if(cam.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No se puede comprar un boleto para el cual no existe trayecto");
			}else {
				String camino;
				if(rdbtnDistancia.isSelected()) {
					camino = "Menor distancia";
				}else if(rdbtnMasRapido.isSelected()) {
					camino = "Mas rapido";
				}else {
					camino = "Mas barato";
				}
				this.setVisible(false);
				app.setContentPane(new PanelCrearBoleto(camino,cam,app,comboBoxOrigen.getSelectedItem().toString(),comboBoxDestino.getSelectedItem().toString()));
				app.pack();
				app.revalidate();
				app.repaint();
				app.setSize(1020, 720);
				app.setLocationRelativeTo(null);
				app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			}
		});
		
		add(btnComprarBoleto);
		
		JButton btnVerTrayectos = new JButton("Ver Trayectos");
		btnVerTrayectos.setBounds(537, 294, 147, 23);
		btnVerTrayectos.addActionListener(l -> {
			Grafos grafo = new Grafos();
			grafo.pageRank();
			if(comboBoxOrigen.getSelectedItem()==null || comboBoxDestino.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null, "No puede haber campos nulos");
			}else {
				
				String origen = comboBoxOrigen.getSelectedItem().toString();
				String destino = comboBoxDestino.getSelectedItem().toString();

				cam = grafo.caminos(new EstacionMultimodal(origen), new EstacionMultimodal(destino));

				List<List<String>> lista = null;
				
				if(cam.isEmpty()) {
					JOptionPane.showMessageDialog(null,"No existen caminos que unan las 2 estaciones");
				}else {
					lblNewLabel_7.setVisible(true);
					btnComprarBoleto.setVisible(true);
					lblNewLabel.setVisible(true);
					rdbtnMasRapido.setVisible(true);
					rdbtnDistancia.setVisible(true);
					rdbtnNewRadioButton_2.setVisible(true);
					Integer i=0;
					while(i<cam.size()) {
						System.out.println(cam.get(i));
						//modeloTabla.setValueAt(cam.get(i), i, 0);	
						lista = cam;
						i++;
					}
					TrayectoTableModel modeloTabla = new TrayectoTableModel(lista);
					JTable table = new JTable();
					table.setModel(modeloTabla);
					table.setBounds(416, 408, 728, -250);
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setSize(490, 130);
					scrollPane.setLocation(453, 353);
					this.add(scrollPane);
				}
				
			}	
		});
		add(btnVerTrayectos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(725, 294, 147, 23);
		btnCancelar.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelInicio(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnCancelar);
		
				
		
		
	}
//	public Double obtenerPrecio() {
//		Double costo = 0.0;
//		List<Ruta> rutas = new ArrayList<Ruta>();
//		rutas = gestorR.getRutas();
//		for(List<String> a: cam) {
//			for(Ruta e: rutas) {
//				if(a.contains(e.getDestino())) {
//					costo += e.getCosto();
//				}
//			}
//			
//		}
//		return costo;
//	}
}

