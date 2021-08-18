package tp.paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import tp.App.App;
import tp.App.Login;
import tp.Exceptions.TransporteException;
import tp.dominio.Transporte;
import tp.gestores.GestorTransporte;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class PanelAltaTransporte extends PanelFondo {
	private JTextField textField;
	private GestorTransporte gestorT = new GestorTransporte();
	private JTextField textField_1;
	private JComboBox<String> comboColor;
	public PanelAltaTransporte(App app) {
		//setTitle("ALTA DE TRANSPORTE");
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Nombre (*)");
		lblNewLabel.setBounds(530, 140, 192, 13);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(690, 140, 178, 19);
		add(textField);
		textField.setColumns(10);
		
		List<Transporte> transportes = new ArrayList<Transporte>();
		transportes = gestorT.getTransportes();
		comboColor = new JComboBox<String>();
		comboColor.setBounds(690, 200, 178, 22);
		for(Transporte est : transportes) {
			this.comboColor.addItem(est.getColor());
		}
		comboColor.setSelectedItem(null);	
		add(comboColor);
		
		JLabel lblNewLabel_1 = new JLabel("Color (*)");
		lblNewLabel_1.setBounds(530, 200, 82, 14);
		add(lblNewLabel_1);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setIcon(new ImageIcon(PanelAltaEstacion.class.getResource("/tp/App/guardar.png")));
		btnGuardar.setBounds(585, 329, 147, 41);
		btnGuardar.addActionListener(e -> {
			String nombre = this.textField.getText();
			String color = comboColor.getSelectedItem().toString();
			try {
				Transporte transporte = new Transporte(nombre,color, false);
				gestorT.crearTransporte(transporte);
			}catch(TransporteException t) {
				t.printStackTrace();
			};
			
			
		});
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(761, 329, 117, 41);
		btnCancelar.addActionListener(e -> {
			int n = JOptionPane.showConfirmDialog( null, "Desea cancelar la operacion?", "Mensaje", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				app.setContentPane(new PanelTransporte(app));
				app.pack();
				app.revalidate();
				app.repaint();
				app.setSize(1020, 720);
				app.setLocationRelativeTo(null);
				app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				
				}
		});
		add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("Por defecto se establece que el estado del transporte no est\u00E1 activo !");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(556, 267, 343, 31);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(*) Datos obligatorios");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_3.setBounds(263, 376, 142, 14);
		add(lblNewLabel_3);
		
		

	}
}
