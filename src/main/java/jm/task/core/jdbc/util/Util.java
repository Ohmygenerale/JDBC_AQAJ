package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static Connection con = null;
    private static Util instance = null;

    private Util() {
        try {
            if (null == con || con.isClosed()) {
                Properties props = getProps();
                con = DriverManager
                        .getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Util getInstance() {
        if (null == instance) {
            instance = new Util();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    private static Properties getProps() throws IOException {
        Properties props = new Properties();
        try (InputStream in = Util.class.getResourceAsStream("/database.properties")) {
            props.load(in);
            return props;
        } catch (IOException e) {
            throw new IOException("Database config file not found", e);
        }
    }
}
