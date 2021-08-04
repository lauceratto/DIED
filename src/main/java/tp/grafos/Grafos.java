package tp.grafos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;
import tp.dominio.Trayecto;
import tp.gestores.GestorEstacion;
import tp.gestores.GestorTrayecto;

public class Grafos {
	private List<EstacionMultimodal> estaciones;
	private List<Ruta> rutas;
	private GestorTrayecto gestorT = new GestorTrayecto();
	private GestorEstacion gestorE = new GestorEstacion();
	
	public Grafos() {
		this.estaciones = new ArrayList<EstacionMultimodal>();
		this.rutas = new ArrayList<Ruta>();
	}

	private List<String> obtenerNodoVecino(String estacion, String nombreTransporte){ 
		List<String> salida = new ArrayList<String>();
		List<Trayecto> trayectos = new ArrayList<Trayecto>();
		trayectos = gestorT.obtenerTrayectos(nombreTransporte);
		estaciones = gestorE.getEstaciones();
		
//		for(EstacionMultimodal e : estaciones) {
//			if(e.getEstado().equals(true)) {
				for(Trayecto enlace : trayectos){
					if( enlace.getEstacionOrigen().equals(estacion)){
						salida.add(enlace.getEstacionDestino());
					}
				}
//			}
//		}
		return salida;
	}
	
	 public List<List<String>> caminos(EstacionMultimodal v1,EstacionMultimodal v2, String nombreTransporte){
	    	List<List<String>>salida = new ArrayList<List<String>>();
	    	List<String> visitados = new ArrayList<String>();
	    	visitados.add(v1.getNombre());
	    	buscarCaminosAux(v1.getNombre(),v2.getNombre(),visitados,salida, nombreTransporte);
	    	return salida;
	    }
	 
	 private void buscarCaminosAux(String v1,String v2, List<String> visitados, List<List<String>> todos, String nombreTransporte) { 
	    	List<String> adyacentes = this.obtenerNodoVecino(v1, nombreTransporte); // OBTENER NODOS ADYACENTES 
	    	List<String> copiaVisitados = null;
	    	
	    	for(String ad: adyacentes) {
	    		copiaVisitados = visitados.stream().collect(Collectors.toList());
	    		if(ad.equals(v2)) {
	    			copiaVisitados.add(ad);
					todos.add(new ArrayList<String>(copiaVisitados));
					System.out.println("Camino!: " +copiaVisitados.toString());
	    		}else {
	    			if(!copiaVisitados.contains(ad)) {
	    				copiaVisitados.add(ad);
	        			this.buscarCaminosAux(ad,v2, copiaVisitados, todos, nombreTransporte);
	    			}
	    		}
	    	}
	    }
}
