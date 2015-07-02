package daverosen.com;
////////////////////////////////////////////////////////////////////////
// Purpose:
//      Testing out database connections and expanding libraries
//
// Initial Date:
//      6/2/2015
//
// Author:
//      Dave Rosen
////////////////////////////////////////////////////////////////////////

public class Main {

    public static void main(String[] args) {
        DBConnection dbc = new DBConnection();

        /////////////////////////////
        // MSSQL
        /////////////////////////////
        dbc.name = "BPMDB";
        dbc.dbCapabilities = "BusinessSpace";
        dbc.type = "SQL Server";
        dbc.hostname = "10.120.20.131";
        dbc.portNumber = "1433";
        dbc.databaseName = "BPMDB";
        dbc.schema = "BPMDB";
        dbc.sqlServerWinAuth = "true";

        dbc.db_userid = "sa";
        dbc.db_password = "test123!";
        System.out.println (dbc.checkDBConnection());

        dbc.db_userid = "foo";
        System.out.println (dbc.checkDBConnection());

        /////////////////////////////
        // DB2
        /////////////////////////////
        dbc.portNumber = "50000";
        dbc.databaseName = "BPMDB";
        dbc.db_userid = "dbadmin";
        dbc.db_password = "dbadmin";
        dbc.type = "DB2";
        System.out.println (dbc.checkDBConnection());
        dbc.db_userid = "foo";
        System.out.println (dbc.checkDBConnection());


        /////////////////////////////
        // Oracle
        /////////////////////////////
        dbc.portNumber = "1521";
        dbc.databaseName = "XE";
        dbc.db_userid = "SYSTEM";
        dbc.db_password = "test123!";
        dbc.type = "Oracle";
        System.out.println (dbc.checkDBConnection());
        dbc.db_userid = "foo";
        System.out.println (dbc.checkDBConnection());
    }
}
