package tp.paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tp.App.App;
import tp.App.Login;
import tp.dominio.EstacionMultimodal;
import tp.dominio.Transporte;
import tp.gestores.GestorEstacion;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelEstacionMultimodal extends JPanel {

	private GestorEstacion gestorE = new GestorEstacion();
	private JTextField textNombre;
	private JTextField textColor;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public PanelEstacionMultimodal(App app) {
		setLayout(null);
	
		JLabel lblNewLabel = new JLabel("Listar Estaciones Multimodal");
		lblNewLabel.setBounds(616, 11, 300, 30);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JLabel lblColor = new JLabel("Nombre");
		lblColor.setBounds(617, 90, 71, 20);
		lblColor.setBackground(Color.BLACK);
		add(lblColor);
		
		textNombre = new JTextField();
		textNombre.setBounds(525, 90, 44, 19);
		add(textNombre);
		textNombre.setColumns(10);
		
		textColor = new JTextField();
		textColor.setBounds(698, 90, 185, 21);
		textColor.setColumns(10);
		add(textColor);
		
		JLabel lblHorarioApertura = new JLabel("Horario apertura");
		lblHorarioApertura.setBackground(Color.BLACK);
		lblHorarioApertura.setBounds(471, 143, 102, 20);
		add(lblHorarioApertura);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(583, 143, 53, 19);
		add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Hs.");
		lblNewLabel_1.setBounds(646, 146, 31, 14);
		add(lblNewLabel_1);
		
		JLabel lblHorarioCierre = new JLabel("Horario cierre");
		lblHorarioCierre.setBackground(Color.BLACK);
		lblHorarioCierre.setBounds(698, 143, 102, 20);
		add(lblHorarioCierre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(807, 143, 53, 19);
		add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hs.");
		lblNewLabel_1_1.setBounds(870, 146, 46, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBackground(Color.BLACK);
		lblEstado.setBounds(471, 189, 71, 20);
		add(lblEstado);
		
		JRadioButton rdbtnOperativa = new JRadioButton("Operativa");
		rdbtnOperativa.setBounds(583, 188, 109, 23);
		buttonGroup.add(rdbtnOperativa);
		add(rdbtnOperativa);
		
		JRadioButton rdbtnEnMantenimiento = new JRadioButton("En Mantenimiento");
		rdbtnEnMantenimiento.setBounds(698, 188, 141, 23);
		buttonGroup.add(rdbtnEnMantenimiento);
		add(rdbtnEnMantenimiento);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(1026, 188, 89, 23);
		add(btnNewButton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(927, 188, 89, 23);
		add(btnLimpiar);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBackground(Color.BLACK);
		lblResultados.setBounds(471, 233, 71, 20);
		add(lblResultados);
		
		EstacionTableModel modeloTabla = new EstacionTableModel(gestorE.getEstaciones());
		JTable table = new JTable();
		table.setModel(modeloTabla);
		table.setBounds(416, 408, 728, -250);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(647, 243);
		scrollPane.setLocation(468, 264);
		this.add(scrollPane);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBackground(Color.BLACK);
		lblId.setBounds(471, 90, 44, 20);
		add(lblId);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Calibri", Font.BOLD, 15));
		btnAlta.setBounds(509, 532, 89, 23);
		btnAlta.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelAltaEstacion(app));
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
		btnBaja.setBounds(616, 532, 89, 23);
		btnBaja.addActionListener(e -> {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Ninguna fila seleccionada");
			}else {
				int n = JOptionPane.showConfirmDialog( null, "Desea eliminar el transporte seleccionado?", "Mensaje", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION) {
					this.setVisible(false);
//					String nombre = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 1));
					String id = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 0));
					gestorE.eliminarEstacion(id);
					app.setContentPane(new PanelEstacionMultimodal(app));
					app.pack();
					app.revalidate();
					app.repaint();
					app.setSize(1020, 720);
					app.setLocationRelativeTo(null);
					app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					
					}
			}
		});
		add(btnBaja);
		
		JButton btnEdicion = new JButton("Edicion");
		btnEdicion.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEdicion.setBounds(722, 532, 89, 23);
		btnEdicion.addActionListener(e -> {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Ninguna fila seleccionada");
			}else {
				String id = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 0));
				String nombre = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 1));
				String apertura = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 2));
				String cierre = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 3));
				String estado = String.valueOf(modeloTabla.getValueAt(table.getSelectedRow(), 4));
				Boolean estado1;
				if(estado=="Operativa"){
					estado1 = true;
				}else {
					estado1 = false;
				}
				EstacionMultimodal est = new EstacionMultimodal(id,nombre,apertura,cierre, estado1);
				this.setVisible(false);
				app.setContentPane(new PanelEdicionEstacion(est, app));
				app.pack();
				app.revalidate();
				app.repaint();
				app.setSize(1020, 720);
				app.setLocationRelativeTo(null);
				app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				
			}
			});
		add(btnEdicion);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(1026, 532, 89, 23);
		btnCancelar.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelInicio(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnCancelar);
		
		JButton btnInformacion = new JButton("");
		btnInformacion.setIcon(new ImageIcon(PanelEstacionMultimodal.class.getResource("/tp/App/info.png")));
		btnInformacion.setBounds(1084, 37, 31, 30);
		btnInformacion.addActionListener(l -> {
			this.setVisible(false);
			app.setContentPane(new PanelInformacion(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnInformacion);
	}
}
