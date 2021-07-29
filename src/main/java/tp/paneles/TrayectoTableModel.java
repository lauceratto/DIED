package tp.paneles;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tp.dominio.EstacionMultimodal;


public class TrayectoTableModel  extends AbstractTableModel {
	public TrayectoTableModel() {
		
	}
	private String[] nombreColumnas = {"Estacion"};
	//public List<EstacionMultimodal> datosTransp;
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.nombreColumnas.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		//return datosTransp.size();
		return 0;
	}
	public String getColumnName(int col) {
        return nombreColumnas[col];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
//		EstacionMultimodal t = datosTransp.get(rowIndex);
//		
//		switch(columnIndex) {
//		case 0: 
//			return t.getNombre();
//		}
		return null;
		
	}
}
