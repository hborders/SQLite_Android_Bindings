package org.sqlite.database.sqlite_cts;

import android.database.Cursor;

import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.sqlite.SQLiteCursor;
import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDatabase.CursorFactory;
import org.sqlite.database.sqlite.SQLiteProgram;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.sqlite.SQLiteStatement;
import org.sqlite.database.wrapper.DatabaseUtilsWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseFlags;
import org.sqlite.database.wrapper.SQLiteDatabaseUtilsWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteDatabaseWrapper;

import java.io.File;

public final class SQLiteSQLiteDatabaseTest extends SQLiteDatabaseTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        CursorFactory,
        SQLiteSQLiteDatabaseTest.MockSQLiteCursor,
        SQLiteProgram,
        DatabaseUtils.InsertHelper
        > {

    public SQLiteSQLiteDatabaseTest() {
        super(
                MockSQLiteCursor.class,
                new SQLiteDatabaseFlags() {
                    @Override
                    public int getCreateIfNecessary() {
                        return SQLiteDatabase.CREATE_IF_NECESSARY;
                    }

                    @Override
                    public int getOpenReadonly() {
                        return SQLiteDatabase.OPEN_READONLY;
                    }

                    @Override
                    public int getEnableWriteAheadLogging() {
                        return SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
                    }
                }
        );
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
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > openDatabase(String path, CursorFactory factory, int flags) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openDatabase(path, factory, flags)
        );
    }

    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > openDatabaseWithNullErrorHandler(String path, CursorFactory factory, int flags) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openDatabase(path, factory, flags, null)
        );
    }

    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > openOrCreateDatabase(String path, CursorFactory factory) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(path, factory)
        );
    }

    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > openOrCreateDatabase(File f, CursorFactory factory) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(f, factory)
        );
    }

    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > create(CursorFactory factory) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.create(factory)
        );
    }

    @Override
    protected SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery,
            CursorFactory
            > openOrCreateDatabaseWithNullErrorHandler(String path, CursorFactory factory) {
        return new SQLiteSQLiteDatabaseWrapper(
                SQLiteDatabase.openOrCreateDatabase(path, factory, null)
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
    protected CursorFactory createCursorFactory() {
        return new CursorFactory() {
            public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery,
                                    String editTable, SQLiteQuery query) {
                return new MockSQLiteCursor(db, masterQuery, editTable, query);
            }
        };
    }

    @Override
    protected boolean deleteDatabase(File f) {
        return SQLiteDatabase.deleteDatabase(f);
    }

    @Override
    protected String findEditTable(String tables) {
        return SQLiteDatabase.findEditTable(tables);
    }

    @Override
    protected void releaseMemory() {
        SQLiteDatabase.releaseMemory();
    }

    public static final class MockSQLiteCursor extends SQLiteCursor {
        public MockSQLiteCursor(SQLiteDatabase db, SQLiteCursorDriver driver,
                                String editTable, SQLiteQuery query) {
            super(db, driver, editTable, query);
        }
    }
}
