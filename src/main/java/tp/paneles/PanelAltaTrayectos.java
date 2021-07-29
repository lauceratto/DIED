package tp.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class PanelAltaTrayectos extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelAltaTrayectos() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Linea de Transporte");
		lblNewLabel.setBounds(407, 146, 143, 14);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(573, 142, 117, 22);
		add(comboBox);
		
		table = new JTable();
	//	table.setModel(modeloTabla);
		table.setBounds(416, 408, 728, -250);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(289, 192);
		scrollPane.setLocation(401, 204);
		this.add(scrollPane);
		
		JButton btnNewButton = new JButton("Agregar Trayecto");
		btnNewButton.setBounds(741, 237, 143, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitar Trayecto");
		btnNewButton_1.setBounds(741, 283, 143, 23);
		add(btnNewButton_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(436, 448, 89, 23);
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(573, 448, 89, 23);
		add(btnCancelar);
		
		


	}
}
