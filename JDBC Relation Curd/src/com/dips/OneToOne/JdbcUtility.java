package com.dips.OneToOne;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Database object to load drivers and perform queries
 *  @author RAHUL MOUNDEKAR
 */
public class JdbcUtility {

    private static Connection con=null;
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String ConnectionString = "jdbc:mysql://localhost:3306/jdbc";
    private static final String user = "root";
    private static final String pwd = "root";

    /**
     * create Database object
     */
    public JdbcUtility() {
    }

    /**
     * to load the database base driver
     * @return a database connection
     * @throws SQLException throws an exception if an error occurs
     */
    public static Connection loadDriver() throws SQLException {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        con = DriverManager.getConnection(ConnectionString, user, pwd);
        return con;
    }

    /**
     * to get a result set of a query
     * @param query custom query
     * @return a result set of custom query
     * @throws SQLException throws an exception if an error occurs
     */
    public static ResultSet getResultSet(String query) throws SQLException {
        con = loadDriver();
        ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        rs = st.executeQuery();
        return rs;
    }

    /**
     * to run an update query such as update, delete
     * @param query custom query
     * @return 
     * @throws SQLException throws an exception if an error occurs
     */
    public static int runQuery(String query) throws SQLException {
        con = loadDriver();
        //ResultSet rs;
        PreparedStatement st = con.prepareStatement(query);
        return st.executeUpdate();
    }
    
    public static boolean insertOperation(String query) throws SQLException{
    	con=loadDriver();
    	PreparedStatement st=con.prepareStatement(query);
    	return st.execute();
    }
    
    public static void close() throws SQLException
    {
    	con.close();
    }
    
}