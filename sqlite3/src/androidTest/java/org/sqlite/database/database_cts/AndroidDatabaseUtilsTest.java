package org.sqlite.database.database_cts;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidDatabaseUtilsWrapper;
import org.sqlite.database.wrapper.AndroidInsertHelperWrapper;
import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.DatabaseUtilsWrapper;
import org.sqlite.database.wrapper.InsertHelperWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

public final class AndroidDatabaseUtilsTest extends DatabaseUtilsTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        SQLiteProgram,
        DatabaseUtils.InsertHelper
        > {
    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery
            > openOrCreateDatabase(String path) {
        return new AndroidSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(path, null)
        );
    }

    @Override
    protected DatabaseUtilsWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            SQLiteProgram,
            DatabaseUtils.InsertHelper
            > createDatabaseUtils() {
        return new AndroidDatabaseUtilsWrapper();
    }

    @Override
    protected InsertHelperWrapper<DatabaseUtils.InsertHelper> createInsertHelper(
            SQLiteDatabaseWrapper<
                    SQLiteDatabase,
                    SQLiteStatement,
                    SQLiteCursorDriver,
                    SQLiteQuery
                    > database, String tableName) {
        return new AndroidInsertHelperWrapper(
                new DatabaseUtils.InsertHelper(database.getSQLiteDatabase(), tableName)
        );
    }
}
