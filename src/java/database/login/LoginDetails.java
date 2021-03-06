package database.login;

import database.connection.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDetails {

    public ArrayList<String> get(String email, String pass) {
        ArrayList<String> loginDetails = new ArrayList<String>();
        Connection conn = null;
        Statement stmt = null;
        boolean decision = false;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(ConnectDetails.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(ConnectDetails.DB_URL, ConnectDetails.USER, ConnectDetails.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT * FROM organization natural join type where email='" + email + "' and password='" + pass + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            String email_C = null;
            while (rs.next()) {
                //Retrieve by column name
                loginDetails.add(rs.getString("type_id"));
                loginDetails.add(rs.getString("organization_id"));
                loginDetails.add(rs.getString("organization_name"));
                loginDetails.add(rs.getString("email"));
            }

            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return loginDetails;
    }
}
