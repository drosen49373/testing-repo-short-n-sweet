package daverosen.com;

import java.sql.*;

public class DBConnection {
    String name;
    String dbCapabilities;
    String type;
    String hostname;
    String portNumber;
    String databaseName;
    String schema;
    String sqlServerWinAuth;

    String db_userid;
    String db_password;

    public DBConnection() {
    }

    public String toString() {
        return "\tDatabase Property name: " + name + '\n'+
                "\t\tdbCapabilities: " + dbCapabilities + '\n'+
                "\t\ttype: " + type + '\n'+
                "\t\thostname: " + hostname + '\n'+
                "\t\tportNumber: " + portNumber + '\n'+
                "\t\tdatabaseName: " + databaseName + '\n'+
                "\t\tschema: " + schema + '\n'+
                "\t\tsqlServerWinAuth: " + sqlServerWinAuth + '\n'+
                "\t\tdb_userid: " + db_userid + '\n'+
                "\t\tdb_password: " + db_password + '\n';
    }

    public String checkDBConnection () {
        if (type.equals("SQL Server")) {
            return (checkMSSQLConnection());
		} else if (type.equals("DB2")) {
			return (checkDB2Connection());
		} else if (type.equals("Oracle")) {
			return (checkOracleConnection());
        } else {
            return ("FAIL -- Database type "+type+" not recognized.");
        }
    }

    private String checkMSSQLConnection () {
        Connection myConn = null;

        String dbURL="jdbc:sqlserver://"+hostname+":"+portNumber+";DatabaseName="+databaseName;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            myConn = DriverManager.getConnection(dbURL, db_userid, db_password);
            return ("MSSQL Database connection SUCCESSFUL!");
        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println("************************************\nFAILED TO CONNECT:\n"+toString()+"************************************");
            return ("MSSQL Database connection FAILED!");
        }
    }

    private String checkDB2Connection () {
        Connection myConn = null;

        String dbURL="jdbc:db2://"+hostname+":"+portNumber+"/"+databaseName;

        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            myConn = DriverManager.getConnection(dbURL, db_userid, db_password);
            return ("DB2 Database connection SUCCESSFUL!");
        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println("************************************\nFAILED TO CONNECT:\n"+toString()+"************************************");
            return ("DB2 Database connection FAILED!");
        }
    }

    private String checkOracleConnection () {
        Connection myConn = null;

        String dbURL="jdbc:oracle:thin:@"+hostname+":"+portNumber+":"+databaseName;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            myConn = DriverManager.getConnection(dbURL, db_userid, db_password);
            return ("Oracle Database connection SUCCESSFUL!");
        } catch (SQLException e) {
            //e.printStackTrace();
            //System.out.println("************************************\nFAILED TO CONNECT:\n"+toString()+"************************************");
            return ("Oracle Database connection FAILED!");
        }
    }
}
