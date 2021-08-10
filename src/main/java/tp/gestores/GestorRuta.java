package tp.gestores;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
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
	
//	public List<Ruta> getRutas(String origen,String destino) {
//		List<Ruta> e =  new ArrayList<Ruta>();
//		for(Ruta rt: this.dao.getRutas(origen,destino)) {
//			Ruta edto = new Ruta();
//			edto.setCantMaxPasajeros(rt.getCantMaxPasajeros());
//			edto.setDestino(rt.getDestino());
//			edto.setOrigen(rt.getOrigen());
//			edto.setCosto(rt.getCosto());
//			edto.setDistancia(rt.getDistancia());
//			edto.setDuracion(rt.getDuracion());
//			edto.setEstado(rt.getEstado());
//			edto.setNombreTransporte(rt.getNombreTransporte());
//			e.add(edto);
//		}
//		return e;
//	}
	public List<Ruta> getRutas() {
		List<Ruta> e =  new ArrayList<Ruta>();
		for(Ruta rt: this.dao.getRutas()) {
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
	public Number[] obtenerMenorDistancia(String origen,String destino) {
		List<Ruta> rutas = getRutas();
		cam = grafo.caminos(new EstacionMultimodal(origen), new EstacionMultimodal(destino));
		Number[] aux = new Number[4];
		Double aux2=0.0;
		Double[] distancia = new Double[cam.size()];
		Double[] duracion = new Double[cam.size()];
		Double[] costo = new Double[cam.size()];
		for(int k=0;k<cam.size();k++) {
			duracion[k] = 0.0;
			costo[k]= 0.0;
			distancia[k] = 0.0;
		}
		
		for(int i=0;i<cam.size();i++) {
			for(int j=1;j<cam.get(i).size();j++) {
				for(Ruta r: rutas) {
					if(r.getOrigen().equals(cam.get(i).get(j-1)) && r.getDestino().equals(cam.get(i).get(j))) {
						costo[i] += r.getCosto();
						duracion[i] += r.getDuracion();
						distancia[i] += r.getDistancia();
					 }
				 }	 

			 }
			aux2 = duracion[i];
			aux[0] = i;
			aux[1] = aux2;
			aux[2] = costo[i];
			aux[3] = distancia[i];
		}
		
		for(int l=0;l<duracion.length;l++) {
			if(duracion[l]<aux2) {
				aux2=duracion[l];
				aux[0] = l;
				aux[1] = aux2;
				aux[2] = costo[l];
				aux[3] = distancia[l];
			}
		}
		return aux;
		
	}

	public Number[] obtenerMasBarato(String origen,String destino) {
		List<Ruta> rutas = getRutas();
		cam = grafo.caminos(new EstacionMultimodal(origen), new EstacionMultimodal(destino));
		Number[] aux = new Number[4];
		Double aux2=0.0;
		Double[] distancia = new Double[cam.size()];
		Double[] duracion = new Double[cam.size()];
		Double[] costo = new Double[cam.size()];
		for(int k=0;k<cam.size();k++) {
			duracion[k] = 0.0;
			costo[k]= 0.0;
			distancia[k] = 0.0;
		}
		
		for(int i=0;i<cam.size();i++) {
			for(int j=1;j<cam.get(i).size();j++) {
				for(Ruta r: rutas) {
					if(r.getOrigen().equals(cam.get(i).get(j-1)) && r.getDestino().equals(cam.get(i).get(j))) {
						costo[i] += r.getCosto();
						duracion[i] += r.getDuracion();
						distancia[i] += r.getDistancia();
					 }
				 }	 

			 }
			aux2 = costo[i];
			aux[0] = i;
			aux[1] = aux2;
			aux[2] = duracion[i];
			aux[3] = distancia[i];
		}
		
		for(int l=0;l<costo.length;l++) {
			if(costo[l]<aux2) {
				aux2=costo[l];
				aux[0] = l;
				aux[1] = aux2;
				aux[2] = duracion[l];
				aux[3] = distancia[l];
			}
		}
		return aux;
		
		
	}

	public Number[] obtenerMasRapido(String origen,String destino) {
		List<Ruta> rutas = getRutas();
		cam = grafo.caminos(new EstacionMultimodal(origen), new EstacionMultimodal(destino));
		Number[] aux = new Number[4];
		Double aux2=0.0;
		Double[] distancia = new Double[cam.size()];
		Double[] duracion = new Double[cam.size()];
		Double[] costo = new Double[cam.size()];
		for(int k=0;k<cam.size();k++) {
			duracion[k] = 0.0;
			costo[k]= 0.0;
			distancia[k] = 0.0;
		}
		
		for(int i=0;i<cam.size();i++) {
			for(int j=1;j<cam.get(i).size();j++) {
				for(Ruta r: rutas) {
					if(r.getOrigen().equals(cam.get(i).get(j-1)) && r.getDestino().equals(cam.get(i).get(j))) {
						costo[i] += r.getCosto();
						duracion[i] += r.getDuracion();
						distancia[i] += r.getDistancia();
					 }
				 }	 

			 }
			aux2 = distancia[i];
			aux[0] = i;
			aux[1] = aux2;
			aux[2] = duracion[i];
			aux[3] = costo[i];
		}
		
		for(int l=0;l<distancia.length;l++) {
			if(distancia[l]<aux2) {
				aux2=distancia[l];
				aux[0] = l;
				aux[1] = aux2;
				aux[2] = duracion[l];
				aux[3] = costo[l];
			}
		}
		return aux;
		
		
	}


}
