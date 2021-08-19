package tp.paneles;

import javax.swing.JPanel;

import tp.App.App;
import tp.gestores.GestorEstacion;
import tp.grafos.Grafos;

import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelInformacion extends PanelFondo {
	private JTable table;
	private GestorEstacion gestorE = new GestorEstacion();
	private Grafos grafo = new Grafos();
	private Integer a = 190;
	public PanelInformacion(App app) {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("PAGE RANK");
		lblNewLabel.setBounds(254, 163, 95, 14);
		add(lblNewLabel);
		
		Map<Object, Object> pageRank;
		pageRank= grafo.pageRank(gestorE.getEstaciones());
		
		List<String> listaOrdenada = new ArrayList<String>();
		for (Entry<Object, Object> entry : pageRank.entrySet()) {
			   listaOrdenada.add((String) entry.getKey());
				//System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
			}
			
			Collections.reverse(listaOrdenada);
			
		for (String lista : listaOrdenada) {
		
			JLabel lbl1 = new JLabel("Estacion: " +lista);
			lbl1.setBounds(254, a, 300, 14);
			add(lbl1);
			//System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
	        a+=20;
	    }
		JLabel lblFlujoMaximo = new JLabel("FLUJO MAXIMO");
		lblFlujoMaximo.setBounds(820, 163, 102, 14);
		add(lblFlujoMaximo);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(684, 188, 331, 300);
		add(scrollPane_1_1);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(848, 610, 89, 23);
		btnNewButton.addActionListener(l -> {
			this.setVisible(false);
			app.setContentPane(new PanelEstacionMultimodal(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnNewButton);

	}
}
