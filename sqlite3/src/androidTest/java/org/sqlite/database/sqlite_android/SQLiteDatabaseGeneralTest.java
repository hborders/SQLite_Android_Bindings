package org.sqlite.database.sqlite_android;

import android.database.Cursor;
import android.test.suitebuilder.annotation.MediumTest;

import org.sqlite.database.DefaultDatabaseErrorHandler;
import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDatabase.CursorFactory;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.sqlite.SQLiteStatement;
import org.sqlite.database.wrapper.DefaultDatabaseErrorHandlerWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.SQLiteSQLiteDatabaseWrapper;

public class SQLiteDatabaseGeneralTest extends DatabaseGeneralTest<
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
        return new SQLiteSQLiteDatabaseWrapper(
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

    @MediumTest
    public void testCustomFunctionNoReturn() {
        mDatabase
                .getSQLiteDatabase()
                .addCustomFunction(
                        "emptyFunction",
                        1,
                        new SQLiteDatabase.CustomFunction() {
                            @Override
                            public void callback(String[] args) {
                                return;
                            }
                        });
        Cursor cursor = mDatabase.rawQuery("SELECT emptyFunction(3.14)", null);
        // always empty regardless of if sqlite3_result_null is called or not
        cursor.moveToFirst();
        assertSame(null, cursor.getString(0));
    }
}
