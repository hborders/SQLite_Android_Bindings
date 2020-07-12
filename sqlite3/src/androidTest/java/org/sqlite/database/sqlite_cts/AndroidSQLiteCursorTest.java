package org.sqlite.database.sqlite_cts;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidSQLiteCursorWrapper;
import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteCursorWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

import java.io.File;

public class AndroidSQLiteCursorTest extends SQLiteCursorTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        SQLiteCursor
        > {
    public AndroidSQLiteCursorTest() {
        super(SQLiteCursor.class);
    }

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

    @Override
    protected SQLiteCursorWrapper getCursor(SQLiteCursor sqliteCursor) {
        return new AndroidSQLiteCursorWrapper(sqliteCursor);
    }

    @Override
    protected SQLiteCursor getGenericCursor() {
        return (SQLiteCursor) mDatabase.query(TABLE_NAME, null, null,
                null, null, null, null);
    }
}
