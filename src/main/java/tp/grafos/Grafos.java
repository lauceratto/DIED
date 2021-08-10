package tp.grafos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;
import tp.dominio.Transporte;
import tp.dominio.Trayecto;
import tp.gestores.GestorEstacion;
import tp.gestores.GestorTransporte;
import tp.gestores.GestorTrayecto;

public class Grafos {
	private List<EstacionMultimodal> estaciones;
	private List<Ruta> rutas;
	private List<String> est;
	private GestorTrayecto gestorT = new GestorTrayecto();
	private GestorEstacion gestorE = new GestorEstacion();
	private GestorTransporte gestorTransp = new GestorTransporte();
	
	public Grafos() {
		this.estaciones = new ArrayList<EstacionMultimodal>();
		this.rutas = new ArrayList<Ruta>();
	}
	
	public Integer gradoEntrada(EstacionMultimodal estacion){
		Integer res = 0;
		List<Trayecto> trayectos = gestorT.obtenerTrayectos();
		for(Trayecto arista : trayectos){
			if(arista.getEstacionDestino().equals(estacion.getNombre())) {
				++res;
			}
		}
		return res;
	}
	
	public List<String> pageRank() {	
		estaciones = gestorE.getEstacionesDisponibles();
		HashMap<EstacionMultimodal,Integer> map = new HashMap<EstacionMultimodal,Integer>();
		List<String> lista = new ArrayList<>();
		for(EstacionMultimodal e: estaciones) {
			map.put(e, gradoEntrada(e));
		}
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(entry -> {
			lista.add(entry.getKey().getNombre());
			//System.out.println(entry.getKey().getNombre()+" "+entry.getValue());
		});
		Collections.reverse(lista);
//		for(String l: lista) {
//			System.out.println(l);
//		}
		return lista;
	}
			

	private List<String> obtenerNodoVecino(String estacion){ 
		List<String> salida = new ArrayList<String>();
		List<Trayecto> trayectos = new ArrayList<Trayecto>();
		trayectos = gestorT.obtenerTrayectos();
			for(Trayecto enlace : trayectos){
				if( enlace.getEstacionOrigen().equals(estacion)){
					salida.add(enlace.getEstacionDestino());
						
				}
			}
		return salida;
	}
	
	 public List<List<String>> caminos(EstacionMultimodal v1,EstacionMultimodal v2){
	    	List<List<String>>salida = new ArrayList<List<String>>();
	    	List<String> visitados = new ArrayList<String>();
	    	visitados.add(v1.getNombre());
	    	buscarCaminosAux(v1.getNombre(),v2.getNombre(),visitados,salida);
	    	
	    	return salida;
	    }
	 
	 private void buscarCaminosAux(String v1,String v2, List<String> visitados, List<List<String>> todos) { 
	    	List<String> adyacentes = this.obtenerNodoVecino(v1); // OBTENER NODOS ADYACENTES 
	    	List<String> copiaVisitados = null;
	    	
	    	for(String ad: adyacentes) {
	    		copiaVisitados = visitados.stream().collect(Collectors.toList());
	    		if(ad.equals(v2)) {
	    			copiaVisitados.add(ad);
					todos.add(new ArrayList<String>(copiaVisitados));
//					System.out.println("Camino!: " +copiaVisitados.toString());
	    		}else {
	    			if(!copiaVisitados.contains(ad)) {
	    				copiaVisitados.add(ad);
	        			this.buscarCaminosAux(ad,v2, copiaVisitados, todos);
	    			}
	    		}
	    	}
	    }
	 
	
}
