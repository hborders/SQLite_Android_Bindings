package org.sqlite.database.database_cts;

import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDatabase.CursorFactory;
import org.sqlite.database.sqlite.SQLiteProgram;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.sqlite.SQLiteStatement;
import org.sqlite.database.wrapper.DatabaseUtilsWrapper;
import org.sqlite.database.wrapper.InsertHelperWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseUtilsWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteInsertHelperWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteDatabaseWrapper;

public final class SQLiteDatabaseUtilsTest extends DatabaseUtilsTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        CursorFactory,
        SQLiteProgram,
        DatabaseUtils.InsertHelper
        > {
    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > openOrCreateDatabase(String path) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(path, null)
        );
    }

    @Override
    protected DatabaseUtilsWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory,
            SQLiteProgram,
            DatabaseUtils.InsertHelper
            > createDatabaseUtils() {
        return new SQLiteDatabaseUtilsWrapper();
    }

    @Override
    protected InsertHelperWrapper<DatabaseUtils.InsertHelper> createInsertHelper(
            SQLiteDatabaseWrapper<
                    SQLiteDatabase,
                    SQLiteStatement,
                    SQLiteCursorDriver,
                    SQLiteQuery,
                    CursorFactory
                    > database, String tableName) {
        return new SQLiteInsertHelperWrapper(
                new DatabaseUtils.InsertHelper(database.getSQLiteDatabase(), tableName)
        );
    }
}
