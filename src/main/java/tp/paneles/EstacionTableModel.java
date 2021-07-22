package tp.paneles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.dominio.EstacionMultimodal;
import tp.dominio.Transporte;

public class EstacionTableModel extends AbstractTableModel{

	public EstacionTableModel(List<EstacionMultimodal> object) {
		this.datosEst =  object;
	}
	private String[] nombreColumnas = {"Id","Nombre", "Apertura","Cierre", "Estado"};
	public List<EstacionMultimodal> datosEst;
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datosEst.size();
	}
	public String getColumnName(int col) {
        return nombreColumnas[col];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		EstacionMultimodal e = datosEst.get(rowIndex);
		
		switch(columnIndex) {
		case 0: 
			return e.getId();
		case 1: 
			return e.getNombre();
		case 2:
			return e.getHorarioApertura();
		case 3:
			return e.getHorarioCierre();
		case 4:
			if(e.getEstado().equals(true))	return "Operativa";
			else	return "En Mantenimiento";
		}
		return null;
	}

}
