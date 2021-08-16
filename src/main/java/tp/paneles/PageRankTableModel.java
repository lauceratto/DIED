package tp.paneles;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.table.AbstractTableModel;

import tp.dominio.Transporte;
import tp.gestores.GestorEstacion;
import tp.grafos.Grafos;

public class PageRankTableModel extends AbstractTableModel{
	private GestorEstacion gestorE = new GestorEstacion();
	private Grafos grafo = new Grafos();
	Map<Object,Object> page = grafo.pageRank(gestorE.getEstaciones());
	
	public PageRankTableModel() {
	//	this.datos =  object;
	}
	private String[] nombreColumnas = {"Estacion", "Page Rank"};
	public Map<Object,Object> datos;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return page.size();
	}
	public String getColumnName(int col) {
        return nombreColumnas[col];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		return null;
	}

}
