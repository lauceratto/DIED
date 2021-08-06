package tp.gestores;

import javax.swing.JOptionPane;

import tp.Exceptions.BoletoException;
import tp.dao.BoletoDAO;
import tp.dominio.Boleto;

public class GestorBoleto {
	private BoletoDAO dao = new BoletoDAO();
	public GestorBoleto() {
		
	}
	public Boleto crearBoleto(Boleto boleto) throws BoletoException{
		if(boleto.getNombre().isEmpty() || boleto.getCorreo().isEmpty()) {
			JOptionPane.showMessageDialog(null, "No pueden haber campos nulos", "Advertencia", 0);
			}else {
				Boleto b = new Boleto();
				b.setNroBoleto(boleto.getNroBoleto());
				b.setNombre(boleto.getNombre());
				b.setCorreo(boleto.getCorreo());
				b.setFecha(boleto.getFecha());
				b.setCamino(boleto.getCamino());
				b.setCosto(boleto.getCosto());
				b.setDestino(boleto.getDestino());
				b.setOrigen(boleto.getOrigen());
				dao.guardar(b);
				JOptionPane.showMessageDialog(null,"El boleto ha sido comprado con exito!");
			return b;
			}
		return boleto;
	}
	

}
