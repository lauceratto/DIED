package tp.paneles;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tp.App.App;
import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;
import tp.dominio.Transporte;
import tp.gestores.GestorEstacion;
import tp.gestores.GestorRuta;
import tp.gestores.GestorTransporte;
import tp.grafos.Grafos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import javax.swing.JTextArea;

public class PanelTrayecto extends JPanel {

	private GestorEstacion gestorE = new GestorEstacion(); 
	private GestorTransporte gestorTran = new GestorTransporte();
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
		List<EstacionMultimodal> estaciones = new ArrayList<EstacionMultimodal>();
		estaciones = gestorE.getEstaciones();
		for(EstacionMultimodal est : estaciones) {
			this.comboBoxOrigen.addItem(est.getNombre());
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
		for(EstacionMultimodal est : estaciones) {
			this.comboBoxDestino.addItem(est.getNombre());
		}
		this.comboBoxDestino.setSelectedItem(null);
		add(comboBoxDestino);
		
		JLabel lblNewLabel = new JLabel("Lista de Trayectos");
		lblNewLabel.setBounds(533, 373, 120, 14);
		lblNewLabel.setVisible(false);
		add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setVisible(false);
		textArea.setBounds(450, 360, 337, 82);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVisible(false);
		scrollPane.setSize(354, 91);
		scrollPane.setLocation(632, 411);
		this.add(scrollPane);
		
		JButton btnComprarBoleto = new JButton("Comprar Boleto");
		btnComprarBoleto.setVisible(false);
		btnComprarBoleto.setBounds(615, 510, 168, 23);
		btnComprarBoleto.addActionListener(l -> {
			if(cam.isEmpty()) {
				JOptionPane.showMessageDialog(null, "No se puede comprar un boleto para el cual no existe trayecto");
			}else {
				this.setVisible(false);
				app.setContentPane(new PanelCrearBoleto(comboBoxTransporte.getSelectedItem().toString(),cam,app,comboBoxOrigen.getSelectedItem().toString(),comboBoxDestino.getSelectedItem().toString()));
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
		btnVerTrayectos.setBounds(458, 317, 147, 23);
		btnVerTrayectos.addActionListener(l -> {
			
			if(comboBoxOrigen.getSelectedItem()==null || comboBoxDestino.getSelectedItem()==null || comboBoxTransporte.getSelectedItem()==null) {
				JOptionPane.showMessageDialog(null, "No puede haber campos nulos");
			}else {
				textArea.setVisible(true);
				btnComprarBoleto.setVisible(true);
				lblNewLabel.setVisible(true);
				scrollPane.setVisible(true);
			cam = grafo.caminos(new EstacionMultimodal(comboBoxOrigen.getSelectedItem().toString()), new EstacionMultimodal(comboBoxDestino.getSelectedItem().toString()),comboBoxTransporte.getSelectedItem().toString());
			textArea.setText(null); 
			for (int j = 0; j < cam.size(); j++) {
				textArea.append("Trayecto: -- > ");
				textArea.append(cam.get(j) + "\n");
			}
			}	
		});
		add(btnVerTrayectos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(796, 317, 147, 23);
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
		
		JLabel lblTransporte = new JLabel("TRANSPORTE");
		lblTransporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransporte.setBounds(566, 128, 98, 14);
		add(lblTransporte);
		
		comboBoxTransporte = new JComboBox<String>();
		comboBoxTransporte.setBounds(674, 124, 131, 22);
		List<Transporte> transporte = new ArrayList<Transporte>();
		transporte = gestorTran.getTransportes();
		for(Transporte est : transporte) {
			this.comboBoxTransporte.addItem(est.getNombre());
		}
		this.comboBoxTransporte.setSelectedItem(null);
		add(comboBoxTransporte);
		
		
		
		
		
		
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

