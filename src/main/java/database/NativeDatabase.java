package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NativeDatabase {
    public void connectionDatabase() throws SQLException {
        var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/subscriptions?useSSL=false&useLegacyDatetimeCode=false", "root", "");

        try (connection) {
            var statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("insert into subscription values ()");

            while (resultSet.next()) {
                System.out.println(resultSet.getRow());
            }
        } catch (Exception ex) {
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    public void except() {
        try {
            throw new Exception("Exception");
        } catch (Exception ex) {
            System.out.println("Catch");
        } finally {
            System.out.println("Finally");
        }
    }
}
