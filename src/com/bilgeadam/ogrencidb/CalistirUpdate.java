package com.bilgeadam.ogrencidb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CalistirUpdate {
    public static void main(String[] args)  throws SQLException {
        Connection conn = null;
        Statement st = null;



        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/odb", "postgres", "postgres");
            st = conn.createStatement();

            int sonuc = st.executeUpdate("update ogrenci set ad ='Gökay' where no=3");

            if (sonuc>0)
                System.out.println("Başarılı");
            else
                System.out.println("Başarısız");



        }
        catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            st.close();
            conn.close();
        }
    }
}