package tp.paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import tp.App.App;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class PanelInicio extends PanelFondo{
	
	public PanelInicio(App app) {
		
		setLayout(null);
		
		
		JButton btnNewButton = new JButton("TRANSPORTE");
		btnNewButton.setIcon(new ImageIcon(PanelInicio.class.getResource("/tp/App/transporte.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(823, 278, 185, 41);
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
		
		JButton btnEstacionMultimodal = new JButton("ESTACION MULTIMODAL");
		btnEstacionMultimodal.setIcon(new ImageIcon(PanelInicio.class.getResource("/tp/App/estacion.png")));
		btnEstacionMultimodal.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEstacionMultimodal.setBounds(253, 279, 260, 40);
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
		
		JButton btnTrayecto = new JButton(" BOLETO");
		btnTrayecto.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrayecto.setIcon(new ImageIcon(PanelInicio.class.getResource("/tp/App/boleto.png")));
		btnTrayecto.setBounds(574, 278, 185, 41);
		btnTrayecto.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelTrayecto(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnTrayecto);
		
		
	}

}
