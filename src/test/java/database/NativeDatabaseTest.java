package database;

import org.junit.Test;

import java.sql.SQLException;

public class NativeDatabaseTest {
    @Test
    public void shouldRun() throws SQLException {
        new NativeDatabase().connectionDatabase();
    }

    @Test
    public void shouldExcept() throws SQLException {
        new NativeDatabase().except();
    }
}
