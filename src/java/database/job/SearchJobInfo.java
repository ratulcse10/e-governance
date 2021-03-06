/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.job;

import database.connection.ConnectDetails;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Tazbeea Tazakka
 */
public class SearchJobInfo {

    public ArrayList<String> search(String national_id) {
        ArrayList<String> jobInfo = new ArrayList<String>();
        jobInfo.clear();
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName(ConnectDetails.JDBC_DRIVER);

            //STEP 3: Open a connection
            conn = DriverManager.getConnection(ConnectDetails.DB_URL, ConnectDetails.USER, ConnectDetails.PASS);

            //STEP 4: Execute a query
            stmt = conn.createStatement();

            String sql = "SELECT national_id,name_en,organization_name,job_id,joining_date,leaving_date,post,organization_id FROM job natural join citizen natural join organization where national_id='" + national_id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set

            while (rs.next()) {
                jobInfo.add(rs.getString("national_id"));
                jobInfo.add(rs.getString("name_en"));
                jobInfo.add(rs.getString("job_id"));
                jobInfo.add(rs.getString("organization_name"));
                jobInfo.add(rs.getString("joining_date"));
                jobInfo.add(rs.getString("leaving_date"));
                jobInfo.add(rs.getString("post"));
                jobInfo.add(rs.getString("organization_id"));
            }

            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return jobInfo;
    }

}
