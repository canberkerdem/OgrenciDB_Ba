package com.bilgeadam.ogrencidb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CalistirSelect {
    public static void main(String[] args) {

        try
        {
            //Class.forName ile jdbc driverın ilgili classını gösteriyoruz
            Class.forName("org.postgresql.Driver");

            //Connection objesi oluşturuyruz.
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/odb","postgres","postgres");



            //Statemen ile sql sorgusu yazabiliriz.
            Statement st = conn.createStatement();

            //Select sonucu ResultSet'e atılır.
            ResultSet rs = st.executeQuery("select no,ad,soyad,kredi from ogrenci order by kredi desc ");

            while(rs.next())
            {

                System.out.print("No:"+rs.getInt("no"));
                System.out.print(" Ad:"+rs.getString(2));
                System.out.print(" Soyad:"+rs.getString(3));
                System.out.print(" Kredi:"+rs.getDouble(4));
                System.out.println();
            }



            st.close();
            rs.close();
            conn.close();

        } catch (Exception e) {
            System.err.println("HATA"+e.getMessage());
        }
    }
}
