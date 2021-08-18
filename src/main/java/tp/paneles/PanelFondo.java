package tp.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {

	protected String fileFondo;

	public  PanelFondo() {
		super();
		this.fileFondo = "tp/App/Fondo.png";
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension tam = getSize();
		ImageIcon imagen = new ImageIcon( new ImageIcon(getClass().getResource("/tp/App/Fondo.png")).getImage());
		g.drawImage(imagen.getImage(), 0,0, tam.width, tam.height, null);
	}
}
