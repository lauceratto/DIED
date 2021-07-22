package tp.paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import tp.App.App;
import tp.gestores.GestorTransporte;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class PanelTrayecto extends JFrame {

	private GestorTransporte gestorT = new GestorTransporte(); 
	private TrayectoTableModel modeloTabla;
	private JTable table;

	public PanelTrayecto() {
		setTitle("TRAYECTOS");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(150, 150, 430, 400);
//		JPanel contentPane = new JPanel();
//		setBorder(new EmptyBorder(10, 10, 10, 10));
//		setContentPane(contentPane);
		setLayout(null);
		
		modeloTabla = new TrayectoTableModel(gestorT.getTransportes());
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.setBounds(299, 110, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(299, 144, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		table = new JTable(modeloTabla);
		addCheckBox(1, table);
		table.setBounds(28, 40, 217, 239);
		getContentPane().add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(250, 175);
		scrollPane.setLocation(21, 62);
		getContentPane().add(scrollPane);
		

	}
	public void addCheckBox(Integer column, JTable table) {
		TableColumn c = table.getColumnModel().getColumn(column);
		c.setCellEditor(table.getDefaultEditor(Boolean.class));
		c.setCellRenderer(table.getDefaultRenderer(Boolean.class));
	}
	
	public Boolean isSelected(Integer row, Integer column, JTable table) {
		return table.getValueAt(row, column) != null;
	}
}
