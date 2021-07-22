package tp.App;

import java.awt.Font;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


import tp.dao.conexionDAO;
import tp.paneles.PanelEstacionMultimodal;
import tp.paneles.PanelInicio;
import tp.paneles.PanelTransporte;

public class App extends JFrame{
	
	JMenuBar menuBar;
	JMenu menuArchivo;
	JMenuItem menuItemSalir;
	JPanel panel = new JPanel();
	JButton botonInicio;
	JButton botonEstacion;
	
public App() {
	
}

public void armarApp() {
	
	this.menuBar = new JMenuBar();
	this.menuArchivo = new JMenu("Inicio");
	this.menuItemSalir = new JMenuItem("Salir");
	this.menuItemSalir.addActionListener( e -> System.exit(0));
	this.menuArchivo.add(menuItemSalir);
	menuBar.add(this.menuArchivo);
	this.setJMenuBar(menuBar);
	
	this.botonInicio = new JButton("Inicio");
	
	this.botonInicio.addActionListener(e -> {
		this.setContentPane(new PanelInicio(this));
		this.pack();
		this.revalidate();
		this.repaint();
		this.setSize(1020, 720);
		this.setLocationRelativeTo(null);
		this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	});
	this.panel.add(this.botonInicio);

	this.add(this.panel);
}

	
	public static void main(String[] args) {
	 Login log = new Login();
	 log.armarLogin();
	 log.setVisible(true);
	}
}
