package tp.paneles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.dominio.Transporte;

public class TrayectoTableModel extends AbstractTableModel {

	public TrayectoTableModel(List<Transporte> object) {
		this.datosTray =  object;
	}
	private String[] nombreColumnas = {"Nombre","Seleccionar"};
	public List<Transporte> datosTray;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datosTray.size();
	}
	public String getColumnName(int col) {
        return nombreColumnas[col];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Transporte t = datosTray.get(rowIndex);
		
		switch(columnIndex) {
		case 0: 
			return t.getNombre();
		}	
		return null;
	}
}
