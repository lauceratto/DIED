package tp.App;

import java.awt.Font;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import tp.dao.conexionDAO;
import tp.paneles.PanelInicio;

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
	JLabel lblNewLabel = new JLabel("INTEGRANTES");
	lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 16));
	lblNewLabel.setBounds(450, 230, 145, 23);
	add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("BAGNAROL, BAUTISTA                   bautista_bagnarol@hotmail.com");
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblNewLabel_1.setBounds(470, 250, 389, 23);
	add(lblNewLabel_1);
	
	JLabel lblNewLabel_1_1 = new JLabel("ROA, MARIA SOLEDAD                   msoleroa@gmail.com");
	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblNewLabel_1_1.setBounds(470, 270, 389, 23);
	add(lblNewLabel_1_1);
	
	JLabel lblNewLabel_1_1_1 = new JLabel("CERATTO, LAUTARO                      lauceratto@gmail.com");
	lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	lblNewLabel_1_1_1.setBounds(470, 290, 389, 27);
	add(lblNewLabel_1_1_1);

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
	 EntityManagerFactory emf = conexionDAO.getInstance();
	 EntityManager man = emf.createEntityManager();
	 Login log = new Login();
	 log.armarLogin();
	 log.setVisible(true);
	 man.close();
	}
}
