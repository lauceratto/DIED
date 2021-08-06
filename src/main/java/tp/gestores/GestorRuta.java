package tp.gestores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



import tp.Exceptions.EstacionException;
import tp.dao.RutaDAO;
import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;
import tp.grafos.Grafos;

public class GestorRuta {
	private RutaDAO dao = new RutaDAO();
	private Grafos grafo = new Grafos();
	private List<List<String>> cam;

	public Ruta crearRuta(Ruta ruta) throws EstacionException {
		if(ruta.getOrigen().equals(ruta.getDestino())) {
			JOptionPane.showMessageDialog(null, "La estacion origen no puede ser igual a la estacion destino", "Advertencia", 0);
		}else {
			Ruta r = new Ruta();
			r.setNombreTransporte(ruta.getNombreTransporte());
			r.setOrigen(ruta.getOrigen());
			r.setDestino(ruta.getDestino());
			r.setCantMaxPasajeros(ruta.getCantMaxPasajeros());
			r.setCosto(ruta.getCosto());
			r.setDuracion(ruta.getDuracion());
			r.setDistancia(ruta.getDistancia());
			r.setEstado(ruta.getEstado());
			dao.guardar(r);
			JOptionPane.showMessageDialog(null,"La ruta se ha creado con exito!");
			
			return r;
		}
		return ruta;
	}
	
	public List<Ruta> getRutas(String origen,String destino) {
		List<Ruta> e =  new ArrayList<Ruta>();
		for(Ruta rt: this.dao.getRutas(origen,destino)) {
			Ruta edto = new Ruta();
			edto.setCantMaxPasajeros(rt.getCantMaxPasajeros());
			edto.setDestino(rt.getDestino());
			edto.setOrigen(rt.getOrigen());
			edto.setCosto(rt.getCosto());
			edto.setDistancia(rt.getDistancia());
			edto.setDuracion(rt.getDuracion());
			edto.setEstado(rt.getEstado());
			edto.setNombreTransporte(rt.getNombreTransporte());
			e.add(edto);
		}
		return e;
	}

	public void obtenerMenorDistancia(String origen,String destino) {
		List<Ruta> rutas = getRutas(origen,destino);
		cam = grafo.caminos(new EstacionMultimodal(origen), new EstacionMultimodal(destino));
		for(Ruta r: rutas) {
			for(int i=0;i<cam.size();i++) {
				for(int j=0;j<cam.get(i).size();j++) {
					 if(r.getOrigen().equals(cam.get(i).get(j))) {
//						 dist[j]
					 }
				 }	 
			 }
		}
//		return dist;

	}

	public void obtenerMasBarato(String origen,String destino) {
		// TODO Auto-generated method stub
		
	}

	public void obtenerMasRapido(String origen,String destino) {
		// TODO Auto-generated method stub
		
	}


}
