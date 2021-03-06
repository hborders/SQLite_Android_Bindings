package org.sqlite.database.database_cts;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;

import org.sqlite.database.wrapper.AndroidInsertHelperWrapper;
import org.sqlite.database.wrapper.AndroidSQLiteDatabaseWrapper;
import org.sqlite.database.wrapper.InsertHelperWrapper;
import org.sqlite.database.wrapper.SQLiteDatabaseWrapper;

public class AndroidDatabaseUtils_InsertHelperTest extends DatabaseUtils_InsertHelperTest<
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
    protected InsertHelperWrapper createInsertHelper(
            SQLiteDatabaseWrapper<
                    SQLiteDatabase,
                    SQLiteStatement,
                    SQLiteCursorDriver,
                    SQLiteQuery,
                    CursorFactory
                    > database, String tableName) {
        return new AndroidInsertHelperWrapper(
                new DatabaseUtils.InsertHelper(
                        database.getSQLiteDatabase(), tableName
                )
        );
    }
}
