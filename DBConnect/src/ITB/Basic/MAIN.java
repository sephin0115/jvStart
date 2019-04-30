package ITB.Basic;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MAIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConn dbConn = new DBConn();
		dbConn.connectDB();
		
		Object[] obj = new Object[1];
		obj[0] = "1000";
		ResultSet rs = null;
		
		try {
			rs = dbConn.excute("UP_ITB_JAVA_TEST_S", obj);
			while(rs.next()) {
				System.out.println(rs.getString("CD_COMPANY") + "|" + rs.getString("ID_USER") +"|" + rs.getString("PW"));				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
	        if(rs != null){ try{ rs.close(); }catch(SQLException e){} }	        
	        if(dbConn != null){ try{ dbConn.con.close(); }catch(SQLException e){} }
	    }	    	
	}

}
