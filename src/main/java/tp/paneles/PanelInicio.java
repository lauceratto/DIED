package tp.paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tp.App.App;

import javax.swing.JButton;

public class PanelInicio extends JPanel {

	public PanelInicio(App app) {
		setLayout(null);
		
		JButton btnNewButton = new JButton("Transporte");
		btnNewButton.setBounds(408, 84, 135, 23);
		btnNewButton.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelTransporte(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnNewButton);
		
		JButton btnEstacionMultimodal = new JButton("Estacion Multimodal");
		btnEstacionMultimodal.setBounds(688, 84, 172, 23);
		btnEstacionMultimodal.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelEstacionMultimodal(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnEstacionMultimodal);
		
	}
}
