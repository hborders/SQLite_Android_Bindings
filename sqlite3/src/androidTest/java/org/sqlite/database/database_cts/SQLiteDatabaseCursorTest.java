package org.sqlite.database.database_cts;

import android.database.Cursor;

import org.sqlite.database.sqlite.SQLiteCursor;
import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDatabase.CursorFactory;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.sqlite.SQLiteStatement;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteDatabaseWrapper;

public final class SQLiteDatabaseCursorTest extends DatabaseCursorTest<
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
        return new SQLiteSQLiteDatabaseWrapper(
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
