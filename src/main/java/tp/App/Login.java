package tp.App;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import tp.dao.conexionDAO;
import tp.dominio.Usuario;
import tp.paneles.PanelEdicionTransporte;
import tp.paneles.PanelEstacionMultimodal;
import tp.paneles.PanelTrayecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public Login() {
		setMinimumSize(new Dimension(300, 350));
		setLocation(600, 200);
		
	}
	public void armarLogin() {
		setTitle("Inicio de sesi\u00F3n");
		Usuario u = new Usuario();
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(30, 48, 46, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(30, 73, 206, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(30, 110, 97, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(30, 133, 206, 20);
		add(textField_1);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBounds(38, 197, 89, 23);
		btnNewButton.addActionListener(e -> {
		//	if(textField.getText().equals(u.getNombre()) && textField_1.getText().equals(u.getContraseña())) {
				App app = new App();
				 app.setTitle("Sistema de Gestión Transporte Multimodal");
				 app.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				 app.armarApp();
				 app.setLocationRelativeTo(null);
				 app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				 app.setVisible(true);
				 this.setVisible(false);
//			}else {
//				JOptionPane.showMessageDialog(null, "La contraseña y/o el usuario son incorrectos");
//			}
			
		});
		add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(137, 197, 89, 23);
		btnCancelar.addActionListener(l -> {
			System.exit(0);
		});
		add(btnCancelar);
	}
}
