package tp.paneles;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import tp.App.App;
import tp.dominio.EstacionMultimodal;

import tp.gestores.GestorEstacion;
import tp.gestores.GestorRuta;
import tp.gestores.GestorTransporte;
import tp.gestores.GestorTrayecto;
import tp.grafos.CrearGrafo;
import tp.grafos.Grafos;

import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class PanelTrayecto extends JPanel {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GestorRuta gestorR = new GestorRuta();
	private JComboBox<String> comboBoxOrigen;
	private JComboBox<String> comboBoxDestino;
	private Grafos grafo = new Grafos();
	private List<List<String>> cam;
	private Integer num=0;
	private Double valor=0.0;
	private Double costo=0.0;
	private Double dist = 0.0;

	public PanelTrayecto(App app) {
		setLayout(null);
		
		comboBoxOrigen = new JComboBox<String>();
		comboBoxOrigen.setBounds(507, 177, 131, 22);
		List<String> estaciones = new ArrayList<String>();
		estaciones = grafo.pageRank();
		for(String est : estaciones) {
			this.comboBoxOrigen.addItem(est);
		}
		this.comboBoxOrigen.setSelectedItem(null);
		add(comboBoxOrigen);
		
		JLabel lblOrigen = new JLabel("ORIGEN");
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setBounds(425, 181, 72, 14);
		
		add(lblOrigen);
		
		JLabel lblDestino = new JLabel("DESTINO");
		lblDestino.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestino.setBounds(710, 181, 92, 14);
		add(lblDestino);
		
		comboBoxDestino = new JComboBox<String>();
		comboBoxDestino.setBounds(810, 177, 131, 22);
		for(String est : estaciones) {
			this.comboBoxDestino.addItem(est);
		}
		this.comboBoxDestino.setSelectedItem(null);
		add(comboBoxDestino);
		
		JLabel lblNewLabel_7 = new JLabel("Camino a seguir");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(441, 234, 107, 22);
		add(lblNewLabel_7);

		JRadioButton rdbtnMasRapido = new JRadioButton("M\u00E1s r\u00E1pido");
		rdbtnMasRapido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMasRapido.setBounds(687, 234, 97, 23);
		buttonGroup.add(rdbtnMasRapido);
		add(rdbtnMasRapido);

		JRadioButton rdbtnDistancia = new JRadioButton("Menor distancia");
		rdbtnDistancia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnDistancia.setBounds(810, 234, 126, 22);
		buttonGroup.add(rdbtnDistancia);
		add(rdbtnDistancia);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("M\u00E1s barato");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBounds(572, 234, 109, 23);
		buttonGroup.add(rdbtnNewRadioButton_2);
		add(rdbtnNewRadioButton_2);
		
		JButton btnComprarBoleto = new JButton("Comprar Boleto");
		btnComprarBoleto.setVisible(false);
		btnComprarBoleto.setBounds(616, 348, 168, 23);
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
				app.setContentPane(new PanelCrearBoleto(camino,cam,app,comboBoxOrigen.getSelectedItem().toString(),comboBoxDestino.getSelectedItem().toString(),costo));
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
				if(cam.isEmpty()) {
					JOptionPane.showMessageDialog(null,"No existen caminos que unan las 2 estaciones");
				}else {
					lblNewLabel_7.setVisible(true);
					btnComprarBoleto.setVisible(true);
					JFrame mvn= new JFrame("Ventana del grafo");
					mvn.setBounds(0,0, 400, 400);
					if(buttonGroup.isSelected(null)) {
						
						mvn.setContentPane(new CrearGrafo(cam.get(0)));
						
					}else if(rdbtnDistancia.isSelected()) {
						Number[] list = gestorR.obtenerMenorDistancia(origen, destino);
						num = (Integer) list[0];
						valor= (Double) list[1];
						costo = (Double) list[2];
						dist = (Double) list[3];
						mvn.setContentPane(new CrearGrafo(cam.get(num)));
						JLabel lbl = new JLabel("Duracion aprox. "+valor+" min.");
						JLabel lbl1 = new JLabel("Costo aprox. $"+costo);
						JLabel lbl2 = new JLabel("Distancia aprox. "+dist+" km.");
						lbl.setBounds(60, 120, 170, 14);
						lbl1.setBounds(60, 140, 170, 14);
						lbl2.setBounds(60, 160, 170, 14);
						mvn.add(lbl);
						mvn.add(lbl1);
						mvn.add(lbl2);
					}
					else if(rdbtnMasRapido.isSelected()) {
						Number[] list = gestorR.obtenerMasRapido(origen, destino);
						num = (Integer) list[0];
						dist = (Double) list[1];
						valor = (Double) list[2];
						costo = (Double) list[3];
						mvn.setContentPane(new CrearGrafo(cam.get(num)));
						JLabel lbl = new JLabel("Duracion aprox. "+valor+" min.");
						JLabel lbl1 = new JLabel("Costo aprox. $"+costo);
						JLabel lbl2 = new JLabel("Distancia aprox. "+dist+" km.");
						lbl.setBounds(60, 120, 170, 14);
						lbl1.setBounds(60, 140, 170, 14);
						lbl2.setBounds(60, 160, 170, 14);
						mvn.add(lbl);
						mvn.add(lbl1);
						mvn.add(lbl2);
					}else if(rdbtnNewRadioButton_2.isSelected()) {
						Number[] list = gestorR.obtenerMasBarato(origen, destino);
						num = (Integer) list[0];
						costo = (Double) list[1];
						valor = (Double) list[2];
						dist = (Double) list[3];
						mvn.setContentPane(new CrearGrafo(cam.get(num)));
						JLabel lbl = new JLabel("Duracion aprox. "+valor+" min.");
						JLabel lbl1 = new JLabel("Costo aprox. $"+costo);
						JLabel lbl2 = new JLabel("Distancia aprox. "+dist+" km.");
						lbl.setBounds(60, 120, 170, 14);
						lbl1.setBounds(60, 140, 170, 14);
						lbl2.setBounds(60, 160, 170, 14);
						mvn.add(lbl);
						mvn.add(lbl1);
						mvn.add(lbl2);
					}
					mvn.setVisible(true);

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
		
		JLabel lblNewLabel = new JLabel("Si no se selecciona ning\u00FAn camino, se establecer\u00E1 uno por defecto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(557, 269, 340, 14);
		add(lblNewLabel);
		
				
		
		
	}
}

