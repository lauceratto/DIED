package tp.paneles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.dominio.Transporte;


public class TransporteTableModel extends AbstractTableModel {
	
	public TransporteTableModel(List<Transporte> object) {
		this.datosTransp =  object;
	}
	private String[] nombreColumnas = {"Nombre", "Color", "Estado"};
	public List<Transporte> datosTransp;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.nombreColumnas.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datosTransp.size();
	}
	public String getColumnName(int col) {
        return nombreColumnas[col];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Transporte t = datosTransp.get(rowIndex);
		
		switch(columnIndex) {
		case 0: 
			return t.getNombre();
		case 1: 
			return t.getColor();
		case 2:
			if(t.getEstado().equals(true))	return "Activo";
			else	return "No activo";
		}
		return null;
	}

}
