package ITB.Basic;

import ITB.Basic.DBsetting;
import java.sql.*;
import sun.misc.*;

public class DBConn {
	Connection con = null;
	Statement stmt = null;
	CallableStatement ctmt = null;
	ResultSet rs = null;
	DBsetting newDB = new DBsetting();	
	//DB ����
	public void connectDB()
	{					
		newDB.setStrServerIP("61.251.180.143");
		newDB.setStrServerPort("");
		newDB.setStrID("NEOE");
		newDB.setStrPW("NEOE");
		newDB.setStrDBName("NEOE");
		newDB.SettingServer();		
		System.out.println(newDB.getConnectionUrl());		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Okay");
			con = DriverManager.getConnection(newDB.getConnectionUrl(),newDB.getStrID() , newDB.getStrPW());
			System.out.println("Connection Made");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			
		}
	}
	
	//���ν��� ȣ�� 
	//conn.prepareCall("{call db��.���ν�����(?,?,?)}");
	public ResultSet excute(String strProc , Object[] obj) throws SQLException
	{
		try {
			String str = "";
			str = "{call " +newDB.getStrDBName() +"."+strProc+"(";
			
			// �������� �Ű����� ����! obj�迭�� ����ŭ!
			for (int i = 0 ; i < obj.length ; i++)
			{
				str = str + "?,";
			}
			str = str.substring(0, str.length() - 1);
			str = str + ")}";
			
			ctmt = con.prepareCall(str);
			// �Ű����� ����
			for (int i = 0 ; i < obj.length ; i++)
			{
				ctmt.setObject(i + 1, obj[i]);
			}
			System.out.println(str);
			
			
			ctmt.execute();
			rs = ctmt.getResultSet();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 			
		
		return rs;	
			
	}
	
	public ResultSet excuteQuery(String _sql) throws SQLException
	{
		try {
			String sql = _sql;
			stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY , ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(sql);
						
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;		
	}
		

}
