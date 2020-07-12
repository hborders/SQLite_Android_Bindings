package org.sqlite.database.sqlite_cts;

import org.sqlite.database.wrapper.SQLiteClosableWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteClosableWrapper;

public class SQLiteSQLiteClosableTest extends SQLiteClosableTest {
    @Override
    protected SQLiteClosableWrapper createSQLiteClosableWrapper() {
        return new SQLiteSQLiteClosableWrapper();
    }
}
