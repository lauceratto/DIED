package tp.paneles;

import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;

import java.time.LocalDate;
import java.util.List;

import tp.App.App;
import tp.Exceptions.BoletoException;
import tp.dominio.Boleto;
import tp.gestores.GestorBoleto;
import javax.swing.JFrame;


public class PanelCrearBoleto extends JPanel {
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private GestorBoleto gestorB = new GestorBoleto();
	private JTextField textOrigen;
	private JTextField textDestino;


	public PanelCrearBoleto(String camino,List<List<String>> cam, App app,String origen, String destino, Double costo) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Boleto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(617, 44, 59, 22);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nro. Boleto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(400, 180, 73, 14);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(559, 174, 49, 20);
		add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Correo electr\u00F3nico");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(400, 304, 118, 14);
		add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(558, 298, 172, 20);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(400, 351, 59, 14);
		add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(558, 345, 118, 20);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Fecha venta");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(400, 391, 73, 14);
		add(lblNewLabel_4);

		LocalDate hoy = LocalDate.now();
		textField_3 = new JTextField();
		textField_3.setText(" " + hoy);
		textField_3.setBounds(558, 389, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);

		
		JLabel lblNewLabel_8 = new JLabel("Costo");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(400, 420, 46, 14);
		add(lblNewLabel_8);

		textField_4 = new JTextField("$"+costo);
		textField_4.setBounds(557, 420, 86, 20);
		textField_4.setEditable(false);
		add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(471, 480, 89, 23);
		btnNewButton_1.addActionListener(l -> {
			this.setVisible(false);
			app.setContentPane(new PanelTrayecto(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnNewButton_1);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblOrigen.setBounds(400, 238, 73, 23);
		add(lblOrigen);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDestino.setBounds(679, 239, 73, 14);
		add(lblDestino);
		
		JButton btnNewButton = new JButton("Registrar venta");
		btnNewButton.addActionListener(e -> {
			String correo = this.textField_1.getText();
			String nombre = this.textField_2.getText();
			String id = this.textField.getText();
			
						
			try {
				Boleto boleto = new Boleto(id,costo,correo, nombre, hoy,camino,origen, destino); 
				gestorB.crearBoleto(boleto);
			}catch(BoletoException b) {
				b.printStackTrace();
			}
		});
		btnNewButton.setBounds(646, 480, 126, 23);
		add(btnNewButton);
		
		textOrigen = new JTextField(origen);
		textOrigen.setEditable(false);
		textOrigen.setColumns(10);
		textOrigen.setBounds(559, 240, 59, 20);
		add(textOrigen);
		
		textDestino = new JTextField(destino);
		textDestino.setEditable(false);
		textDestino.setColumns(10);
		textDestino.setBounds(779, 240, 59, 20);
		add(textDestino);

	}
	
}
