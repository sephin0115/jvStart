package ITB.Basic;

import java.sql.ResultSet;

@SuppressWarnings("serial")
public class DataTable extends DataTableModel{
	public int rowCount = 0;
	public int colCount = 0;
	
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getColCount() {
		return colCount;
	}
	public void setColCount(int colCount) {
		//aaa
		this.colCount = colCount;
	}
	
	public Object[] Row = new Object[rowCount];
	public Object[][] DataTable = new Object[rowCount][colCount];	
	

	public void SetCol(String ColName , int ColCount)
	{
		colName = new String[ColCount];
		for(int i = 1 ; i <ColCount ; i++)
		{			
			colName[i] = ColName;
		}
		System.out.println(colName);
	}
	
	public Object[][] SetDataTable(ResultSet _rs)
	{
		try {
			rs = _rs;
			rsmd = _rs.getMetaData();
			rs.last(); //Ŀ���� ��ġ�� ���� �ڷ� �̵�
			rowCount = rs.getRow(); //���� Ŀ���� Row Index ���� ����
			colCount = rsmd.getColumnCount();
			colName = new String[colCount];
			DataTable = new Object[rowCount][colCount];
			
			rs.beforeFirst();
			//rs.first(); //Ŀ�� ��ġ�� ù������ ����
			int iRow =0;
			System.out.println("�迭������");
			while(rs.next())
			{
				iRow = rs.getRow();
				for(int iCol = 0 ; iCol < colCount  ; iCol ++)
				{					
					DataTable[iRow-1][iCol] = rs.getObject(iCol+1);
				}
			}
			
			System.out.println(DataTable);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return DataTable;
	}
	
}
