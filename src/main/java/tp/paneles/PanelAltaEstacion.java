package tp.paneles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import tp.App.App;
import tp.Exceptions.EstacionException;
import tp.Exceptions.TransporteException;
import tp.dominio.EstacionMultimodal;
import tp.dominio.Transporte;
import tp.gestores.GestorEstacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class PanelAltaEstacion extends PanelFondo {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JTextField textID;
	public JTextField textNombre;
	public JTextField textHorarioApertura;
	public JTextField textHorarioCierre;
	public GestorEstacion gestorE = new GestorEstacion();
	
	public PanelAltaEstacion(App app) {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Alta de Estacion Multimodal");
		lblNewLabel.setBounds(535, 84, 347, 30);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(616, 167, 71, 20);
		lblNombre.setBackground(Color.BLACK);
		add(lblNombre);
		
		textID = new JTextField();
		textID.setBounds(525, 167, 44, 19);
		textID.setColumns(10);
		add(textID);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBackground(Color.BLACK);
		lblId.setBounds(471, 167, 44, 20);
		add(lblId);
		textNombre = new JTextField();
		textNombre.setBounds(697, 167, 185, 21);
		textNombre.setColumns(10);
		add(textNombre);
		
		JLabel lblHorarioApertura = new JLabel("Horario apertura");
		lblHorarioApertura.setBackground(Color.BLACK);
		lblHorarioApertura.setBounds(471, 227, 102, 20);
		add(lblHorarioApertura);
		
		textHorarioApertura = new JTextField();
		textHorarioApertura.setColumns(10);
		textHorarioApertura.setBounds(583, 227, 53, 19);
		add(textHorarioApertura);
		
		JLabel lblNewLabel_1 = new JLabel("Hs.");
		lblNewLabel_1.setBounds(646, 230, 31, 14);
		add(lblNewLabel_1);
		
		JLabel lblHorarioCierre = new JLabel("Horario cierre");
		lblHorarioCierre.setBackground(Color.BLACK);
		lblHorarioCierre.setBounds(698, 227, 102, 20);
		add(lblHorarioCierre);
		
		textHorarioCierre = new JTextField();
		textHorarioCierre.setColumns(10);
		textHorarioCierre.setBounds(810, 227, 53, 19);
		add(textHorarioCierre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hs.");
		lblNewLabel_1_1.setBounds(873, 230, 46, 14);
		add(lblNewLabel_1_1);

		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.setIcon(new ImageIcon(PanelAltaEstacion.class.getResource("/tp/App/guardar.png")));
		btnGuardar.setBounds(562, 301, 147, 35);
		btnGuardar.addActionListener(e -> {
			String id = this.textID.getText();
			String nombre = this.textNombre.getText();
			String apertura = this.textHorarioApertura.getText();
			String cierre = this.textHorarioCierre.getText();
			
			try {
				EstacionMultimodal estacion = new EstacionMultimodal(id,nombre,apertura,cierre,true);
				gestorE.crearEstacion(estacion);
			}catch(EstacionException e1) {
				e1.printStackTrace();
			};
		});
		add(btnGuardar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(729, 302, 134, 32);
		btnCancelar.addActionListener(e -> {
			this.setVisible(false);
			app.setContentPane(new PanelEstacionMultimodal(app));
			app.pack();
			app.revalidate();
			app.repaint();
			app.setSize(1020, 720);
			app.setLocationRelativeTo(null);
			app.setExtendedState(app.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		});
		add(btnCancelar);
	}

}
