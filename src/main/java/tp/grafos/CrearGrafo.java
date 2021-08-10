package tp.grafos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import tp.App.App;

public class CrearGrafo extends JComponent{
	List<String> lista;
	Integer i=80;
	public CrearGrafo(List<String> lista) {
		this.lista = lista;
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d= (Graphics2D) g.create();
		dibujarCirculo(g2d);
	}
	private void dibujarCirculo(Graphics2D g2d) {
		
		for(String e: lista) {
		Ellipse2D.Double elipse = new Ellipse2D.Double(i, 70, 30, 30);
		g2d.setBackground(Color.black);
		g2d.drawString(e, i+12, 90);
		g2d.drawString("->", i+30, 90);
		g2d.draw(elipse);
		i+=40;
		}

	}
}
