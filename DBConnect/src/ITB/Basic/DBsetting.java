package ITB.Basic;

import java.sql.*;
import sun.misc.*;

public class DBsetting {
	
	private String strServerIP;
	private String strServerPort;
	
	private String strSqlConnect;
	private String connectionUrl;
	private String strDBName;
	private String strID;
	private String strPW;
	
	public void SettingServer()
	{
		this.connectionUrl = "jdbc:sqlserver://" + strServerIP + strServerPort + ";" +"databaseName="+strDBName+";";
	}
	
	/*
	 * public void SettingServer(String _serverIP , String _serverPort , String
	 * _DBName , String _strID , String _strPW) { this.strServerIP = _serverIP;
	 * this.strServerPort = ":" + _serverPort; this.strSqlConnect =
	 * this.strServerIP+this.strServerPort; this.strDBName = _DBName; this.strID =
	 * _strID; this.strPW = _strPW; //"jdbc:sqlserver://localhost:1433;" +
	 * "databaseName=디비이름;";//(db서버가 따로 존재한다면 로컬호스트:포트번호 대신 서버아이피:포트번호 를 입력하면된다.
	 * this.connectionUrl = "jdbc:sqlserver://" + strServerIP + strServerPort + ";"
	 * +"databaseName="+strDBName+";"; System.out.println(connectionUrl); }
	 */
	public String getStrServerIP() {
		return strServerIP;
	}

	public void setStrServerIP(String strServerIP) {
		this.strServerIP = strServerIP;
	}

	public String getStrServerPort() {
		return strServerPort;
	}

	public void setStrServerPort(String strServerPort) {
		this.strServerPort = strServerPort;
	}

	public String getStrSqlConnect() {
		return strSqlConnect;
	}

	public void setStrSqlConnect(String strSqlConnect) {
		this.strSqlConnect = strSqlConnect;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String getStrDBName() {
		return strDBName;
	}

	public void setStrDBName(String strDBName) {
		this.strDBName = strDBName;
	}

	public String getStrID() {
		return strID;
	}

	public void setStrID(String strID) {
		this.strID = strID;
	}

	public String getStrPW() {
		return strPW;
	}

	public void setStrPW(String strPW) {
		this.strPW = strPW;
	}
	
	
	

}
