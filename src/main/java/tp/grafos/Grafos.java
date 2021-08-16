package tp.grafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


import tp.dominio.EstacionMultimodal;
import tp.dominio.Ruta;
import tp.dominio.Trayecto;
import tp.gestores.GestorEstacion;
import tp.gestores.GestorTransporte;
import tp.gestores.GestorTrayecto;

public class Grafos {
	private List<EstacionMultimodal> estaciones;
	private List<Ruta> rutas;
	private List<String> est;
	private GestorTrayecto gestorT = new GestorTrayecto();
	private List<Trayecto> trayectos = gestorT.obtenerTrayectos();

	
	public Grafos() {
		this.estaciones = new ArrayList<EstacionMultimodal>();
		this.rutas = new ArrayList<Ruta>();
	}
	
	 private Integer gradoSalida(EstacionMultimodal e){ 
		 Integer res =0; 
		 for(Trayecto t : this.trayectos){ 
			 if(t.getEstacionOrigen().equals(e.getNombre())) ++res; 
		 } 
		return res;
	 }
	 

	public Integer gradoEntrada(EstacionMultimodal estacion){
		Integer res = 0;
		for(Trayecto arista : this.trayectos){
			if(arista.getEstacionDestino().equals(estacion.getNombre())) {
				++res;
			}
		}
		return res;
	}

	public Map<Object, Object> pageRank(List<EstacionMultimodal> list) {	
		//estaciones = gestorE.getEstacionesDisponibles();
		HashMap<String,Double> pagerank = new HashMap<String,Double>();
		List<EstacionMultimodal> lista = new ArrayList<EstacionMultimodal>();
		Double pr=0.0; 
		for (EstacionMultimodal estacion : list) {
			 pagerank.put(estacion.getNombre(),(0.5/(double)list.size())); 
		} 	
		
		for(int i=0;i<list.size();i++) { 
			 for (EstacionMultimodal estacion :list) { 
				lista=obtenerNodosEntrantes(estacion); 
					 for (EstacionMultimodal pAdy :lista){
						 if(gradoSalida(pAdy).equals(0)) {
							 pr+=(pagerank.get(pAdy.getNombre())/1); 
						 }else {
							 pr+=(pagerank.get(pAdy.getNombre())/gradoSalida(pAdy)); 
						 }
					 }
					 pagerank.replace(estacion.getNombre(),pr.doubleValue()); 
					 pr=0.0; 
			}

		}

		Map<Object, Object> est = pagerank.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
				 Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new)); 

		
//		for (Entry<Object, Object> entry : est.entrySet()) {
//		   listaOrdenada.add((String) entry.getKey());
//			//System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
//		}
//		
//		Collections.reverse(listaOrdenada);
//		for(String l: listaOrdenada) {
//			System.out.println(l);
//		}
		return est;
	}
			

	private List<String> obtenerNodoVecino(String estacion){ 
		List<String> salida = new ArrayList<String>();
			for(Trayecto enlace : this.trayectos){
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
					//System.out.println("Camino!: " +copiaVisitados.toString());
	    		}else {
	    			if(!copiaVisitados.contains(ad)) {
	    				copiaVisitados.add(ad);
	        			this.buscarCaminosAux(ad,v2, copiaVisitados, todos);
	    			}
	    		}
	    	}
	    }
	 private List<EstacionMultimodal> obtenerNodosEntrantes(EstacionMultimodal e) {
		 List<EstacionMultimodal> estaciones = new ArrayList<EstacionMultimodal>();
		 
		 for (Trayecto t : this.trayectos) { 
			 if(t.getEstacionDestino().equals(e.getNombre())) {
				 if(!estaciones.contains(t.getEstacionOrigen())) estaciones.add(e); 
			 }
				
		} 
		 return estaciones;
	} 
	

	 
	
}
