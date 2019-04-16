
import resources.DbConnectionHelper;
import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.Random;




import java.sql.*;

public class DbConnection extends DbConnectionHelper
{
    protected String dbHost = "localhost";
    protected String dbPort = "3306";
    protected String dbUser = "root";
    protected String dbPass = "";		//"1234qwer!";
    protected String dbName = "semestr";
    
    Connection dbConnection;

    // Methods
    // œÓ‰ÍÎ˛˜ÂÌËÂ Í ¡ƒ
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost +
                ":" + dbPort + "/" + dbName +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");
        this.dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return this.dbConnection;
    }
    
    public  ArrayList<Position> getAllPosition() {
      ArrayList<Position> result = new ArrayList<>();
      Statement statement = null;
      ResultSet resSet = null;
      String id ="";
      String position = "";
      String sql = "SELECT * FROM position ";
      try {
          statement = this.getDbConnection().createStatement();
          statement.setFetchSize(100);
          resSet = statement.executeQuery(sql);

          while (resSet.next()) {
              id = resSet.getString("ID_Position");
              position = resSet.getString("PositionName");
              result.add(new Position(id,position));
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } finally {
          try {
              this.dbConnection.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      return result;
  }


	  public  ArrayList<Position> checkPosition(String pos) {
	      ArrayList<Position> result = new ArrayList<>();
	      Statement statement = null;
	      ResultSet resSet = null;
	      String id ="";
	      String position = "";
	      String sql = "SELECT * FROM position  WHERE PositionName = '" + pos +"'";
	      try {
	          statement = this.getDbConnection().createStatement();
	          statement.setFetchSize(100);
	          resSet = statement.executeQuery(sql);
	
	          while (resSet.next()) {
	              id = resSet.getString("ID_Position");
	              position = resSet.getString("PositionName");
	              result.add(new Position(id,position));
	          }
	      } catch (SQLException e) {
	          e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	          e.printStackTrace();
	      } finally {
	          try {
	              this.dbConnection.close();
	          } catch (SQLException e) {
	              e.printStackTrace();
	          }
	      }
	      return result;
	  }

    
    public int checkUser(String username, String password) {
        String sql = "{? = call findUser(?,?)}";
        int outputValue = 0;
        try {
            CallableStatement stmt = this.getDbConnection().prepareCall(sql);
            stmt.registerOutParameter(1, Types.INTEGER);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.execute();
            outputValue = stmt.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                this.dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outputValue;
    }
    

    public int checkCurrentPosition(String pos) {
        Statement statement = null;
        ResultSet resSet = null;
        String id ="";
        String position = "";
        String sql = "SELECT * FROM position  WHERE PositionName = '" + pos +"'";
        try {
            statement = this.getDbConnection().createStatement();
            statement.setFetchSize(100);
            resSet = statement.executeQuery(sql);

            while (resSet.next()) {
                id = resSet.getString("ID_Position");
                position = resSet.getString("PositionName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                this.dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(id.equals(""))
            return 0;
        else
            return 1;
    }

    
    public int checkCurrentPosition(Integer ID_Position) {
        Statement statement = null;
        ResultSet resSet = null;
        String id ="";
        String position = "";
        String sql = "SELECT * FROM position  WHERE ID_Position = '" + ID_Position.toString() +"'";
        try {
            statement = this.getDbConnection().createStatement();
            statement.setFetchSize(100);
            resSet = statement.executeQuery(sql);

            while (resSet.next()) {
                id = resSet.getString("ID_Position");
                position = resSet.getString("PositionName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                this.dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(id.equals(""))
            return 0;
        else
            return 1;
    }

    public void delCurPos(String pos) {
      PreparedStatement  pstmt  = null;
      ResultSet resSet = null;
      String sql = "DELETE FROM position WHERE PositionName = ?";
      try {
          pstmt  = this.getDbConnection().prepareStatement(sql);
          pstmt .setString(1, pos);
          pstmt .executeUpdate();

      } catch (SQLException e) {
          e.printStackTrace();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } finally {
          try {
              this.dbConnection.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

  }
    
	public void testMain(Object[] args) 
	{
		// Õ≈Œ¡’Œƒ»ÃŒ —ƒ≈À¿“‹: ‚ÒÚ‡‚¸ÚÂ Á‰ÂÒ¸ ÍÓ‰
	}
	
	public void print(){
		System.out.println("test class");
	}
}

