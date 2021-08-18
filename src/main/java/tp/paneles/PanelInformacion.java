package tp.paneles;

import javax.swing.JPanel;

import tp.App.App;
import tp.gestores.GestorEstacion;
import tp.grafos.Grafos;

import javax.swing.JScrollPane;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelInformacion extends PanelFondo {
	private JTable table;
	private GestorEstacion gestorE = new GestorEstacion();
	private Grafos grafo = new Grafos();
	public PanelInformacion(App app) {
		setLayout(null);
		
		PageRankTableModel modeloTabla = new PageRankTableModel();		
		table = new JTable();
		table.setModel(modeloTabla);
		table.setBounds(200, 200, 500, 500);
		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setLocation(132, 188);
		scrollPane_1.setSize(331,300);
		add(scrollPane_1);
		
		JLabel lblNewLabel = new JLabel("PAGE RANK");
		lblNewLabel.setBounds(254, 163, 95, 14);
		add(lblNewLabel);
		
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
