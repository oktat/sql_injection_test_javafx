package lan.zold.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserSource {
  
  final boolean PREPARED = false;

  Database database;
  Connection conn;
  public UserSource(Database database) {
    this.database = database;    
  }
  public boolean login(String user, String pass) {
    try {
      if (PREPARED) {
        return tryLoginPrepared(user, pass);
      }else {
        return tryLogin(user, pass);
      }      
    } catch (SQLException e) {
      System.err.println("Hiba! A lekérdezés sikertelen!");
      System.err.println(e.getMessage());
      return false;
    }
  }
  public boolean tryLogin(String user, String pass) throws SQLException {
    conn = database.connect();
    String sql = "select user, pass from users where user = '" + user + "' and pass = '" + pass + "'";
    System.out.println(sql);
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql);        
    if (rs.next()) {
      return true;
    }
    return false;
  }

  public boolean tryLoginPrepared(String user, String pass) throws SQLException {
    conn = database.connect();
    String sql = "select user, pass from users where user = ? and pass = ?";
    PreparedStatement ps = conn.prepareStatement(sql);

    ps.setString(1, user);
    ps.setString(2, pass);
    System.out.println(ps.toString());
    ResultSet rs = ps.executeQuery();
    
    if (rs.next()) {
      return true;
    }
    return false;
  }


}
