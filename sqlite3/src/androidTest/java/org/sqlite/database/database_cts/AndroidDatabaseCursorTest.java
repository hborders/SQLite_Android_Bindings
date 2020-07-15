package org.sqlite.database.database_cts;


import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

public final class AndroidDatabaseCursorTest extends DatabaseCursorTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        CursorFactory,
        SQLiteCursor
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
    protected SetSelectionArguments createSetSelectionArguments(final SQLiteCursor cursor) {
        return new SetSelectionArguments() {
            @Override
            public void setSelectionArguments(String[] arguments) {
                cursor.setSelectionArguments(arguments);
            }
        };
    }

    @Override
    protected CursorFactory createCursorFactory(final BeforeRequery<SQLiteCursor> beforeRequery) {
        return new CursorFactory() {
            @Override
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery,
                                    String editTable, SQLiteQuery query) {
                return new SQLiteCursor(db, masterQuery, editTable, query) {
                    @Override
                    public boolean requery() {
                        beforeRequery.beforeRequery(this);
                        return super.requery();
                    }
                };
            }
        };
    }
}
