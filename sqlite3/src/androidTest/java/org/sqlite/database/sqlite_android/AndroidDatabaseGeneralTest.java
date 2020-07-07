package org.sqlite.database.sqlite_android;

import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.DefaultDatabaseErrorHandlerWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

public class AndroidDatabaseGeneralTest extends DatabaseGeneralTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery
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
    protected DefaultDatabaseErrorHandlerWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery
            > createDefaultDatabaseErrorHandler() {
        final DefaultDatabaseErrorHandler defaultDatabaseErrorHandler =
                new DefaultDatabaseErrorHandler();
        return new DefaultDatabaseErrorHandlerWrapper<
                SQLiteDatabase,
                SQLiteStatement,
                SQLiteCursorDriver,
                SQLiteQuery
                >() {
            @Override
            public void onCorruption(SQLiteDatabaseWrapper<
                    SQLiteDatabase,
                    SQLiteStatement,
                    SQLiteCursorDriver,
                    SQLiteQuery
                    > dbObj) {
                defaultDatabaseErrorHandler.onCorruption(dbObj.getSQLiteDatabase());
            }
        };
    }
}
