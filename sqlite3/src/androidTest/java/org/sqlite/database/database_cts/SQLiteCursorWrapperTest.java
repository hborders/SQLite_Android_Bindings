package org.sqlite.database.database_cts;


import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteDatabaseWrapper;

public final class SQLiteCursorWrapperTest extends CursorWrapperTest<
        SQLiteDatabase,
        SQLiteCursorDriver,
        SQLiteQuery
        > {
    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteCursorDriver,
            SQLiteQuery
            > openOrCreateDatabase(String path) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(path, null)
        );
    }
}
