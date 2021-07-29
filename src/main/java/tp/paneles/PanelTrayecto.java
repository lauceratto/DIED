package tp.paneles;

import javax.swing.JFrame;

import javax.swing.JPanel;

import tp.App.App;
import tp.dominio.EstacionMultimodal;
import tp.gestores.GestorEstacion;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PanelTrayecto extends JPanel {

	private GestorEstacion gestorE = new GestorEstacion(); 
	private JComboBox<String> comboBoxOrigen;
	private JComboBox<String> comboBoxDestino;

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
		
		JButton btnVerTrayectos = new JButton("Ver Trayectos");
		btnVerTrayectos.setBounds(541, 317, 147, 23);
		add(btnVerTrayectos);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(734, 317, 147, 23);
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
}
