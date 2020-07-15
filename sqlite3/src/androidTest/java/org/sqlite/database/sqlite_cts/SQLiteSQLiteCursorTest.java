package org.sqlite.database.sqlite_cts;

import org.sqlite.database.sqlite.SQLiteCursor;
import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDatabase.CursorFactory;
import org.sqlite.database.sqlite.SQLiteDirectCursorDriver;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.sqlite.SQLiteStatement;
import org.sqlite.database.wrapper.SQLiteCursorWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteCursorWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteDatabaseWrapper;

import java.io.File;

public class SQLiteSQLiteCursorTest extends SQLiteCursorTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        CursorFactory,
        SQLiteCursor
        > {
    public SQLiteSQLiteCursorTest() {
        super(SQLiteCursor.class);
    }

    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > openOrCreateDatabase(File f) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(f, null)
        );
    }

    @Override
    protected SQLiteCursorWrapper getCursor(SQLiteCursor sqliteCursor) {
        return new SQLiteSQLiteCursorWrapper(sqliteCursor);
    }

    @Override
    protected SQLiteCursor getGenericCursor() {
        return (SQLiteCursor) mDatabase.query(TABLE_NAME, null, null,
                null, null, null, null);
    }

    public void testSQLiteCursorConstructor() {
        SQLiteDirectCursorDriver cursorDriver = new SQLiteDirectCursorDriver(
                mDatabase.getSQLiteDatabase(), TEST_SQL, TABLE_NAME, null);
        try {
            new SQLiteCursor(mDatabase.getSQLiteDatabase(), cursorDriver, TABLE_NAME, null);
            fail("constructor didn't throw IllegalArgumentException when SQLiteQuery is null");
        } catch (IllegalArgumentException e) {
        }
    }
}
