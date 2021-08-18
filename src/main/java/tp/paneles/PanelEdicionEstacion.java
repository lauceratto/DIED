package tp.paneles;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import tp.App.App;
import tp.dominio.EstacionMultimodal;
import tp.gestores.GestorEstacion;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PanelEdicionEstacion extends PanelFondo {
	
	private GestorEstacion gestorE = new GestorEstacion();
	private JTextField textNombre;
	private JTextField textID;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public Boolean est = false;
	
	public PanelEdicionEstacion(EstacionMultimodal estacion, App app) {
		setLayout(null);
		JLabel lblColor = new JLabel("Nombre");
		lblColor.setBounds(653, 198, 71, 20);
		lblColor.setBackground(Color.BLACK);
		add(lblColor);
		
		textID = new JTextField();
		textID.setBounds(579, 198, 44, 19);
		textID.setText(estacion.getId());
		add(textID);
		textID.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(734, 198, 149, 21);
		textNombre.setText(estacion.getNombre());
		textNombre.setColumns(10);
		add(textNombre);
		
		JLabel lblHorarioApertura = new JLabel("Horario apertura");
		lblHorarioApertura.setBackground(Color.BLACK);
		lblHorarioApertura.setBounds(467, 244, 102, 20);
		add(lblHorarioApertura);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setText(estacion.getHorarioApertura());
		textField.setBounds(579, 244, 53, 19);
		add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Hs.");
		lblNewLabel_1.setBounds(642, 247, 31, 14);
		add(lblNewLabel_1);
		
		JLabel lblHorarioCierre = new JLabel("Horario cierre");
		lblHorarioCierre.setBackground(Color.BLACK);
		lblHorarioCierre.setBounds(698, 244, 102, 20);
		add(lblHorarioCierre);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText(estacion.getHorarioCierre());
		textField_1.setBounds(809, 244, 53, 19);
		add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hs.");
		lblNewLabel_1_1.setBounds(872, 247, 46, 14);
		add(lblNewLabel_1_1);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBackground(Color.BLACK);
		lblEstado.setBounds(471, 287, 71, 20);
		add(lblEstado);
		
		JRadioButton rdbtnOperativa = new JRadioButton("Operativa");
		rdbtnOperativa.setBounds(605, 286, 109, 23);
		buttonGroup.add(rdbtnOperativa);
		add(rdbtnOperativa);
		
		JRadioButton rdbtnEnMantenimiento = new JRadioButton("En Mantenimiento");
		rdbtnEnMantenimiento.setBounds(742, 286, 141, 23);
		buttonGroup.add(rdbtnEnMantenimiento);
		add(rdbtnEnMantenimiento);
	
		if(estacion.getEstado()==true) {
			rdbtnOperativa.setSelected(true);
			est = true;
			
		}else {
			rdbtnEnMantenimiento.setSelected(true);
			est=false;
		}
		JLabel lblID = new JLabel("Id");
		lblID.setBackground(Color.BLACK);
		lblID.setBounds(467, 198, 44, 20);
		add(lblID);
		
		JLabel lblNewLabel = new JLabel("EDICION DE ESTACION");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel.setBounds(577, 77, 306, 50);
		add(lblNewLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(534, 352, 89, 23);
		btnGuardar.addActionListener(l -> {
			String id = this.textID.getText();
			String nombre= this.textNombre.getText();
			String ap= this.textField.getText();
			String ci= this.textField_1.getText();
			
			
			if(rdbtnOperativa.isSelected()==false) {
				est=false;
			}else {
				est=true;
			}
			EstacionMultimodal estac = new EstacionMultimodal(id,nombre,ap,ci,est); 
			
			
			if(estacion.getEstado()==true && est==false) {
				//CAMBIA DE OPERATIVA A EN MANTENIMIENTO
				//GUARDAR EN EL HISTORIAL LA FECHA Y EL ID DE LA ESTACION
				
				LocalDate inicio = LocalDate.now();
				gestorE.guardarEnHistorial(inicio,null,null,estac.getId());

			}else {
				LocalDate fin = LocalDate.now();
				gestorE.actualizarHistorial(null,fin,null,estacion.getId());
				
			}
			gestorE.actualizarEstacion(estac);
			this.setVisible(false);
			app.setContentPane(new PanelEstacionMultimodal(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			
		});
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(711, 352, 89, 23);
		btnCancelar.addActionListener(l -> {
			int n = JOptionPane.showConfirmDialog( null, "Desea cancelar la operacion?", "Mensaje", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				this.setVisible(false);
				app.setContentPane(new PanelEstacionMultimodal(app));
				app.pack();
				app.revalidate();
				app.repaint();
				app.setSize(1020, 720);
				app.setLocationRelativeTo(null);
				app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				}
		});
		
		add(btnCancelar);
	}
}
