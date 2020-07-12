package org.sqlite.database.sqlite_cts;

import org.sqlite.database.wrapper.AndroidSQLiteClosableWrapper;
import org.sqlite.database.wrapper.SQLiteClosableWrapper;

public final class AndroidSQLiteClosableTest extends SQLiteClosableTest {
    @Override
    protected SQLiteClosableWrapper createSQLiteClosableWrapper() {
        return new AndroidSQLiteClosableWrapper();
    }
}
