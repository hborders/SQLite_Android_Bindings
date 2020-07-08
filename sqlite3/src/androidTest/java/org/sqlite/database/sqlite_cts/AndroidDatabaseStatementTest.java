package org.sqlite.database.sqlite_cts;

import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

import java.io.File;

public final class AndroidDatabaseStatementTest extends DatabaseStatementTest<
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
            > openOrCreateDatabase(File f) {
        return new AndroidSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(f, null)
        );
    }
}
