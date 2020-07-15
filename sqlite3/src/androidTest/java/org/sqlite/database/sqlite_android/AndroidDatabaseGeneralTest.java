package org.sqlite.database.sqlite_android;

import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.DefaultDatabaseErrorHandlerWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

public class AndroidDatabaseGeneralTest extends DatabaseGeneralTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        CursorFactory
        > {
    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
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
            SQLiteQuery,
            CursorFactory
            > createDefaultDatabaseErrorHandler() {
        final DefaultDatabaseErrorHandler defaultDatabaseErrorHandler =
                new DefaultDatabaseErrorHandler();
        return new DefaultDatabaseErrorHandlerWrapper<
                SQLiteDatabase,
                SQLiteStatement,
                SQLiteCursorDriver,
                SQLiteQuery,
                CursorFactory
                >() {
            @Override
            public void onCorruption(SQLiteDatabaseWrapper<
                    SQLiteDatabase,
                    SQLiteStatement,
                    SQLiteCursorDriver,
                    SQLiteQuery,
                    CursorFactory
                    > dbObj) {
                defaultDatabaseErrorHandler.onCorruption(dbObj.getSQLiteDatabase());
            }
        };
    }
}
