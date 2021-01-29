package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    
    private Connection conn = null;
    private String url = "";
    
    public DataBase(String url){
        this.url = "jdbc:sqlite:" + url;
    }

    public void connect() {
        try {
            // creamos una conexión a la BD
            conn = DriverManager.getConnection(url);
            System.out.println("Connexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getString("first_name") + "\t" +
                rs.getString("last_name") + "\t" +
                rs.getString("city") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("La conexión no ha sido establecida, primero conecte con la base de datos");
        }
    }
    
    public void createNewTable(String table){
        String sql = "CREATE TABLE IF NOT EXISTS " + table + " (\n"
                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " mail text NOT NULL);";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println("La conexión no ha sido establecida, primero conecte con la base de datos");
        }
    }
    
}
