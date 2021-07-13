package tp.App;

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

public class App extends JFrame{
	
	JMenuBar menuBar;
	JMenu menuArchivo;
	JMenuItem menuItemSalir;
	JPanel panel = new JPanel();
	
	
public App() {
	
}

private void armarApp() {
	
	this.menuBar = new JMenuBar();
	this.menuArchivo = new JMenu("Inicio");
	this.menuItemSalir = new JMenuItem("Salir");
	this.menuItemSalir.addActionListener( e -> System.exit(0));
	this.menuArchivo.add(menuItemSalir);
	menuBar.add(this.menuArchivo);
	this.setJMenuBar(menuBar);
	
}

	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = conexionDAO.getInstance();
		EntityManager man = emf.createEntityManager(); 
		man.getTransaction().begin();
		 App app = new App();
		 app.setTitle("Sistema de Gesti�n Transporte Multimodal");
		 app.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		 app.armarApp();
		 app.setLocationRelativeTo(null);
		 app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		 app.setVisible(true);
		man.getTransaction().commit();
	    man.close();
	   
	}
}
