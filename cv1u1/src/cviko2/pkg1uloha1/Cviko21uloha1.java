/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviko2.pkg1uloha1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.util.Random;

/**
 *
 * @author Dominik
 */
public class Cviko21uloha1 {

    /**
     * @param args the command line arguments
     */
    private static String getRandString(){
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rnd = new Random();
        while (sb.length() < 6){
            int index = (int) (rnd.nextFloat() * CHARS.length());
            sb.append(CHARS.charAt(index));
        }
        String sbStr = sb.toString();
        return sbStr;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement st = con.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM kniha");
        cenaKnihy("After Eight", rs);
        String meno = getRandString();
        pridajKnihu(meno, 12.95, rs, st);
        Statement st1 = con.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT * FROM kniha");
        zlava("After Eight", rs1, st1);
    }
    
    public static double cenaKnihy(String meno, ResultSet rs) throws SQLException{
        while (rs.next()) {
            if(rs.getString(1).contains("kk")){
                return Double.parseDouble(rs.getString(3));
            }
        }
        System.out.println("Knihu nemáme.");
        return -1;
    }
    
    private static boolean pridajKnihu(String meno, Double cena, ResultSet rs, Statement st) throws SQLException {
        while (rs.next()){
            if(rs.getString(1).contains(meno)){
                return false;
            }
        }
        st.executeUpdate("INSERT INTO kniha (MENO,AUTOR,CENA) VALUES ('"+meno+"', '"+NULL+"', "+cena+")");  //radsej PreparedStatement ale nechcelo sa mi to posielat z mainu :D
        return true;
    }

    private static void zlava(String meno, ResultSet rs, Statement st) throws SQLException {
        while (rs.next()){
            if(rs.getString(1).contains(meno)){
                double zlava = Double.parseDouble(rs.getString(3)) * 0.80;
                st.executeUpdate("UPDATE kniha SET CENA = "+zlava+" WHERE MENO = '"+rs.getString(1)+"'");
            }
        }
    }
}
