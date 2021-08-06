package tp.paneles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.dominio.Transporte;
import tp.dominio.Trayecto;

public class TrayectoTableModel extends AbstractTableModel {

	public TrayectoTableModel(List<List<String>> lista2) {
		this.lista =  lista2;
	}
	private String[] nombreColumnas = {"Estaciones", "Transporte/s"};
	public List<List<String>> lista;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}
	public String getColumnName(int col) {
        return nombreColumnas[col];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch(columnIndex) {
		case 0: 
			return this.lista.get(rowIndex);
		case 1:
			return "                            -";
	}
		return null;
	}
}
