package org.sqlite.database.database_cts;

import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.wrapper.InsertHelperWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteInsertHelperWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteDatabaseWrapper;

public class SQLiteDatabaseUtils_InsertHelperTest extends DatabaseUtils_InsertHelperTest<
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

    @Override
    protected InsertHelperWrapper createInsertHelper(
            SQLiteDatabaseWrapper<
                    SQLiteDatabase,
                    SQLiteCursorDriver,
                    SQLiteQuery
                    > database, String tableName) {
        return new SQLiteInsertHelperWrapper(
                new DatabaseUtils.InsertHelper(
                        database.getSQLiteDatabase(), tableName
                )
        );
    }
}
