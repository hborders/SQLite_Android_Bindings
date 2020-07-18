package org.sqlite.database.sqlite_cts;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidDatabaseUtilsWrapper;
import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.DatabaseUtilsWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseFlags;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

import java.io.File;

public final class AndroidSQLiteDatabaseTest extends SQLiteDatabaseTest<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        CursorFactory,
        AndroidSQLiteDatabaseTest.MockSQLiteCursor,
        SQLiteProgram,
        DatabaseUtils.InsertHelper
        > {

    public AndroidSQLiteDatabaseTest() {
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
        return new AndroidSQLiteDatabaseWrapper(
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
        return new AndroidSQLiteDatabaseWrapper(
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
        return new AndroidSQLiteDatabaseWrapper(
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
        return new AndroidSQLiteDatabaseWrapper(
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
        return new AndroidSQLiteDatabaseWrapper(
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
        return new AndroidSQLiteDatabaseWrapper(
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
        return new AndroidSQLiteDatabaseWrapper(
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
        return new AndroidDatabaseUtilsWrapper();
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
