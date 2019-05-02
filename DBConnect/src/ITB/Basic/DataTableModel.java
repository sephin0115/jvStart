package ITB.Basic;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
class DataTableModel extends AbstractTableModel {
	
	String[] colName = null;
	public Object[][] DataTable = null;	
	ResultSetMetaData rsmd = null;
	ResultSet rs = null;
	
	int rowCount = 0;
	int colCount = 0;
	
	public String[] getColName() {
		return colName;
	}
	public void setColName(String[] colName) {
		this.colName = colName;
	}
	public Object[][] getRowData() {
		return DataTable;
	}
	public void setRowData(Object[][] rowData) {
		this.DataTable = rowData;
	}
	
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
	public int getColumnCount()
    {
        return colName.length;
    }

    public int getRowCount()
    {
        return rowCount;
    }

    public String getColumnName(int col)
    {
        return colName[col];
    }
    
    public int getColCount() {
		return colCount;
	}
    
	public void setColCount(int colCount) {
		this.colCount = colCount;
	}
	
	
	
    /// cell 값 가져오기(AbstractTableModel.getValueAt 구현 
	public Object getValueAt(int row,int col)
	{
		return DataTable[row][col];
	}
	
}
