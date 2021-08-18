package tp.paneles;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.App.App;
import tp.App.Login;
import tp.Exceptions.TransporteException;
import tp.dominio.Transporte;
import tp.gestores.GestorTransporte;
import javax.swing.JRadioButton;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class PanelEdicionTransporte extends PanelFondo {
	private GestorTransporte gestorT = new GestorTransporte();
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> comboColor;
	public PanelEdicionTransporte(Transporte transporte, App app) {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Nombre (*)");
		lblNewLabel.setBounds(530, 140, 192, 13);
		add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setText(transporte.getNombre());
		txtNombre.setBounds(690, 140, 178, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		List<Transporte> transportes = new ArrayList<Transporte>();
		transportes = gestorT.getTransportes();
		comboColor = new JComboBox<String>();
		comboColor.setBounds(690, 200, 178, 22);
		for(Transporte est : transportes) {
			this.comboColor.addItem(est.getColor());
		}
		comboColor.setSelectedItem(transporte.getColor());
		add(comboColor);
		
		JLabel lblNewLabel_1 = new JLabel("Color (*)");
		lblNewLabel_1.setBounds(530, 200, 82, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setBounds(530, 265, 59, 14);
		add(lblNewLabel_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Activa");
		rdbtnNewRadioButton.setBounds(688, 261, 82, 23);
		buttonGroup.add(rdbtnNewRadioButton);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No activa");
		rdbtnNewRadioButton_1.setBounds(775, 261, 109, 23);
		buttonGroup.add(rdbtnNewRadioButton_1);
		add(rdbtnNewRadioButton_1);
		if(transporte.getEstado()==true) {
			rdbtnNewRadioButton.setSelected(true);
		}else {
			rdbtnNewRadioButton_1.setSelected(true);
		}
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(601, 340, 89, 23);
		btnNewButton.addActionListener(e -> {
//			String id = lblNewLabel_4.getText();
			//VERIFICAR EL NOMBRE
			String nombre = this.txtNombre.getText();
			String color = comboColor.getSelectedItem().toString();
			Boolean estado = false;
			if(rdbtnNewRadioButton.isSelected()==true) {
				estado = true;
			}
			try {
				Integer id = gestorT.obtenerIdPorNombre(transporte.getNombre());
				gestorT.actulizarTransporte(id, nombre, color,estado);
			}catch(TransporteException t) {
				t.printStackTrace();
			};
			
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
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(745, 340, 89, 23);
		btnNewButton_1.addActionListener(e -> {
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
		add(btnNewButton_1);
	}
}
