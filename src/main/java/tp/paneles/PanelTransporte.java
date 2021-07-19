package tp.paneles;


import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;

import tp.App.App;
import tp.dominio.Transporte;
import tp.gestores.GestorTransporte;

import javax.swing.JScrollPane;

public class PanelTransporte extends JPanel {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textNombre;
	private JTextField textColor;
	private JTable table;
	private TransporteTableModel modeloTabla;
	private GestorTransporte gestorT = new GestorTransporte(); 
	private TableRowSorter trs, trs1, trs2;

	
	public PanelTransporte(App app) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar transportes");
		lblNewLabel.setBounds(671, 10, 198, 30); 
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAlta.setBounds(517, 587, 103, 20);
		btnAlta.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelAltaTransporte(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnAlta);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Calibri", Font.BOLD, 14));
		btnBaja.setBounds(630, 587, 104, 20);
		btnBaja.addActionListener(e -> {
			JOptionPane.showMessageDialog( null, "Lo sentimos. Esta opción no disponible en este momento", "Advertencia", 0);
		});
		add(btnBaja);
		
		JButton btnEdicion = new JButton("Edicion");
		btnEdicion.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEdicion.setBounds(744, 587, 104, 20);
		btnEdicion.addActionListener(e -> {
		if(table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Ninguna fila seleccionada");
		}else {
			String nombre = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 0));
		//	System.out.println(nombre);
			String color = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 1));
			String estado = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 2));
			Boolean estado1;
			if(estado=="Activo"){
				estado1 = true;
			}else {
				estado1 = false;
			}
			Transporte transp = new Transporte(nombre, color, estado1);
			this.setVisible(false);
			app.setContentPane(new PanelEdicionTransporte(transp, app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			
		}
		});
		add(btnEdicion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBackground(Color.BLACK);
		lblNombre.setBounds(468, 62, 71, 20);
		add(lblNombre);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBackground(Color.BLACK);
		lblColor.setBounds(468, 124, 71, 20);
		add(lblColor);
		
		textNombre = new JTextField();
		textNombre.setBounds(549, 62, 185, 19);
		add(textNombre);
		textNombre.setColumns(10);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(549, 124, 185, 21);
		add(textColor);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(468, 184, 71, 20);
		add(lblEstado);
		
		JRadioButton rdbtnActiva = new JRadioButton("Activa");
		buttonGroup.add(rdbtnActiva);
		rdbtnActiva.setBounds(560, 184, 93, 21);
		add(rdbtnActiva);
		
		JRadioButton rdbtnNoActiva = new JRadioButton("No activa");
		buttonGroup.add(rdbtnNoActiva);
		rdbtnNoActiva.setBounds(655, 184, 115, 21);
		add(rdbtnNoActiva);

		modeloTabla = new TransporteTableModel(gestorT.getTransportes());
		table = new JTable();
		table.setModel(modeloTabla);
		table.setBounds(416, 408, 728, -250);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(700, 300);
		scrollPane.setLocation(468, 264);
		this.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Resultados");
		lblNewLabel_1.setBounds(468, 239, 127, 14);
		add(lblNewLabel_1);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Calibri", Font.BOLD, 14));
		btnLimpiar.setBounds(950, 186, 104, 20);
		btnLimpiar.addActionListener(e -> {
			this.setVisible(false);		
			app.setContentPane(new PanelTransporte(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnLimpiar);

		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Calibri", Font.BOLD, 14));
		btnBuscar.setBounds(1064, 186, 104, 20);
		
		btnBuscar.addActionListener(e -> {
		
//			if(textNombre.getText() != "" || textColor.getText() !="") {
//			
//				trs = new TableRowSorter(modeloTabla);
//				table.setRowSorter(trs);
//				trs.setRowFilter(RowFilter.regexFilter(textNombre.getText(), 0));
//
//			}
//		
//			if(textColor.getText() != "") {
//				trs1 = new TableRowSorter(modeloTabla);
//				table.setRowSorter(trs1);
//				trs1.setRowFilter(RowFilter.regexFilter(textColor.getText(), 1));
//				}
//			if(buttonGroup.getSelection() != null) {
//				trs2 = new TableRowSorter(modeloTabla);
//				table.setRowSorter(trs2);
//				if(buttonGroup.getSelection().equals("Activa")) trs2.setRowFilter(RowFilter.regexFilter("Activa", 2));
//				else trs2.setRowFilter(RowFilter.regexFilter("No activa", 2));
//			}
//		
			 filtro (textNombre.getText(), modeloTabla, 0);
		     filtro (textColor.getText(), modeloTabla, 1);
		});
		add(btnBuscar);

		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(1064, 668, 89, 23);
		add(btnNewButton);
		
		JButton btnTrayecto = new JButton("Trayecto");
		btnTrayecto.setFont(new Font("Calibri", Font.BOLD, 14));
		btnTrayecto.setBounds(858, 587, 104, 20);
		btnTrayecto.addActionListener(e -> {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Ninguna fila seleccionada");
			}else {
			
			}
		});
		add(btnTrayecto);
	}
	public void filtro(String consulta, TransporteTableModel jtableBuscar, int NColumna){
		TableRowSorter tr = new TableRowSorter(jtableBuscar);
		table.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(consulta, NColumna));
}
}
