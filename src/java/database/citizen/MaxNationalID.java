package database.citizen;

import database.Connect;
import database.connection.ConnectDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MaxNationalID {

    public int get(String tempNationalID) {
        Connection conn = null;
        Statement stmt = null;
        int maximumid = 0;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(ConnectDetails.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(ConnectDetails.DB_URL, ConnectDetails.USER, ConnectDetails.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT max(national_id) as maximum FROM citizen where national_id like '" + tempNationalID + "%' ";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            //String email_C = null;
            while (rs.next()) {
                //Retrieve by column name
                maximumid = rs.getInt("maximum");
            }

            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return maximumid;
    }
}
