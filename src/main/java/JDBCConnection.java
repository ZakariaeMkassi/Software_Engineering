import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCConnection {

    private static JDBCConnection connection = null;

    private String url = "jdbc:postgresql://dumbo.inf.h-brs.de/zmkass2s";

    private Connection conn;

    private String login = "demouser";

    private String password = "demouser";

    public static JDBCConnection getInstance() throws DatabaseLayerException {

        if ( connection == null ) {
            connection = new JDBCConnection();
        }
        return connection;

    }

    private JDBCConnection() throws DatabaseLayerException {
        this.initConnection();

    }


    public void initConnection() throws DatabaseLayerException {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("cant open Connection");
        }
        this.openConnection();

    }

    public void openConnection() throws DatabaseLayerException {

        try {
            Properties props = new Properties();
            props.setProperty("user", "zmkass2s" );
            props.setProperty("password", "zmkass2s" );


            this.conn = DriverManager.getConnection(this.url, props);

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new DatabaseLayerException( "Fehler bei Zugriff auf die DB! Sichere Verbindung vorhanden!?" );
        }
    }

    public Statement getStatement() throws DatabaseLayerException {

        try {
            if ( this.conn.isClosed() ) {
                this.openConnection();
            }

            return this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public PreparedStatement getPreparedStatement(String sql  ) throws DatabaseLayerException {
        try {
            if ( this.conn.isClosed() ) {
                this.openConnection();
            }

            return this.conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void closeConnection(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
