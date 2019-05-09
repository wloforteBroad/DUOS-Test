package stepDefinitions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import managers.FileReaderManager;

public class MySQLDBHelper {
	// JDBC driver name and database URL
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = FileReaderManager.getInstance().getConfigReader().getDbUrl();

	// Database credentials
	private static final String USER = FileReaderManager.getInstance().getConfigReader().getDbUser();
	private static final String PASS = FileReaderManager.getInstance().getConfigReader().getDbPass();
	private static final String DATABASE = "consent";

	private Connection conn = null;
	private Statement stmt = null;

	public MySQLDBHelper() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void open() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (SQLException ex) {
			Logger.getLogger(MySQLDBHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void close() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException ex) {
			Logger.getLogger(MySQLDBHelper.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
