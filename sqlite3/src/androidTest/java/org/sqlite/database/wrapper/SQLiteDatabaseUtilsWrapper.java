package org.sqlite.database.wrapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;

import org.sqlite.database.DatabaseUtils;
import org.sqlite.database.sqlite.SQLiteCursorDriver;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteDoneException;
import org.sqlite.database.sqlite.SQLiteException;
import org.sqlite.database.sqlite.SQLiteProgram;
import org.sqlite.database.sqlite.SQLiteQuery;
import org.sqlite.database.sqlite.SQLiteStatement;

import java.io.PrintStream;

public final class SQLiteDatabaseUtilsWrapper implements DatabaseUtilsWrapper<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery,
        SQLiteProgram,
        DatabaseUtils.InsertHelper
        > {
    @Override
    public void bindObjectToProgram(SQLiteStatementWrapper<SQLiteStatement> prog, int index,
                                    Object value) {
        DatabaseUtils.bindObjectToProgram(prog.getSQLiteStatement(), index, value);
    }

    @Override
    public void appendEscapedSQLString(StringBuilder sb, String sqlString) {
        DatabaseUtils.appendEscapedSQLString(sb, sqlString);
    }

    @Override
    public String sqlEscapeString(String value) {
        return DatabaseUtils.sqlEscapeString(value);
    }

    @Override
    public void appendValueToSql(StringBuilder sql, Object value) {
        DatabaseUtils.appendValueToSql(sql, value);
    }

    @Override
    public String getCollationKey(String name) {
        return DatabaseUtils.getCollationKey(name);
    }

    @Override
    public String getHexCollationKey(String name) {
        return DatabaseUtils.getHexCollationKey(name);
    }

    @Override
    public void dumpCursor(Cursor cursor) {
        DatabaseUtils.dumpCursor(cursor);
    }

    @Override
    public void dumpCursor(Cursor cursor, PrintStream stream) {
        DatabaseUtils.dumpCursor(cursor, stream);
    }

    @Override
    public void dumpCursor(Cursor cursor, StringBuilder sb) {
        DatabaseUtils.dumpCursor(cursor, sb);
    }

    @Override
    public String dumpCursorToString(Cursor cursor) {
        return DatabaseUtils.dumpCursorToString(cursor);
    }

    @Override
    public void dumpCurrentRow(Cursor cursor) {
        DatabaseUtils.dumpCurrentRow(cursor);
    }

    @Override
    public void dumpCurrentRow(Cursor cursor, PrintStream stream) {
        DatabaseUtils.dumpCurrentRow(cursor, stream);
    }

    @Override
    public void dumpCurrentRow(Cursor cursor, StringBuilder sb) {
        DatabaseUtils.dumpCurrentRow(cursor, sb);
    }

    @Override
    public String dumpCurrentRowToString(Cursor cursor) {
        return DatabaseUtils.dumpCurrentRowToString(cursor);
    }

    @Override
    public void cursorStringToContentValues(Cursor cursor, String field, ContentValues values) {
        DatabaseUtils.cursorStringToContentValues(cursor, field, values);
    }

    @Override
    public void cursorStringToInsertHelper(Cursor cursor, String field,
                                           InsertHelperWrapper<DatabaseUtils.InsertHelper> inserter,
                                           int index) {
        DatabaseUtils.cursorStringToInsertHelper(cursor, field, inserter.getInsertHelper(), index);
    }

    @Override
    public void cursorStringToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        DatabaseUtils.cursorStringToContentValues(cursor, field, values, key);
    }

    @Override
    public void cursorIntToContentValues(Cursor cursor, String field, ContentValues values) {
        DatabaseUtils.cursorIntToContentValues(cursor, field, values);
    }

    @Override
    public void cursorIntToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        DatabaseUtils.cursorIntToContentValues(cursor, field, values, key);
    }

    @Override
    public void cursorLongToContentValues(Cursor cursor, String field, ContentValues values) {
        DatabaseUtils.cursorLongToContentValues(cursor, field, values);
    }

    @Override
    public void cursorLongToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        DatabaseUtils.cursorLongToContentValues(cursor, field, values, key);
    }

    @Override
    public void cursorDoubleToCursorValues(Cursor cursor, String field, ContentValues values) {
        DatabaseUtils.cursorDoubleToCursorValues(cursor, field, values);
    }

    @Override
    public void cursorDoubleToContentValues(Cursor cursor, String field, ContentValues values, String key) {
        DatabaseUtils.cursorDoubleToContentValues(cursor, field, values, key);
    }

    @Override
    public void cursorRowToContentValues(Cursor cursor, ContentValues values) {
        DatabaseUtils.cursorRowToContentValues(cursor, values);
    }

    @Override
    public long queryNumEntries(SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery
            > db, String table) throws SQLiteExceptionWrapper {
        try {
            return DatabaseUtils.queryNumEntries(db.getSQLiteDatabase(), table);
        } catch (SQLiteException wrapped) {
            throw new SQLiteExceptionWrapper(wrapped);
        }
    }

    @Override
    public long queryNumEntries(SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery
            > db, String table, String selection) {
        return DatabaseUtils.queryNumEntries(db.getSQLiteDatabase(), table, selection);
    }

    @Override
    public long queryNumEntries(SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery
            > db, String table, String selection,
                                String[] selectionArgs) {
        return DatabaseUtils.queryNumEntries(db.getSQLiteDatabase(), table, selection, selectionArgs);
    }

    @Override
    public long longForQuery(SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery
            >  db, String query, String[] selectionArgs) throws SQLiteDoneExceptionWrapper {
        try {
            return DatabaseUtils.longForQuery(db.getSQLiteDatabase(), query, selectionArgs);
        } catch (SQLiteDoneException wrapped) {
            throw new SQLiteDoneExceptionWrapper(wrapped);
        }
    }

    @Override
    public long longForQuery(SQLiteStatementWrapper<SQLiteStatement> prog,
                             String[] selectionArgs) throws SQLiteDoneExceptionWrapper {
        try {
            return DatabaseUtils.longForQuery(prog.getSQLiteStatement(), selectionArgs);
        } catch (SQLiteDoneException wrapped) {
            throw new SQLiteDoneExceptionWrapper(wrapped);
        }
    }

    @Override
    public String stringForQuery(SQLiteDatabaseWrapper<
            SQLiteDatabase,
            SQLiteStatement,
            SQLiteCursorDriver,
            SQLiteQuery
            > db, String query, String[] selectionArgs) throws SQLiteDoneExceptionWrapper {
        try {
            return DatabaseUtils.stringForQuery(db.getSQLiteDatabase(), query, selectionArgs);
        } catch (SQLiteDoneException wrapped) {
            throw new SQLiteDoneExceptionWrapper(wrapped);
        }
    }

    @Override
    public String stringForQuery(
            SQLiteStatementWrapper<SQLiteStatement> prog, String[] selectionArgs) {
        return DatabaseUtils.stringForQuery(prog.getSQLiteStatement(), selectionArgs);
    }

    @Override
    public ParcelFileDescriptor blobFileDescriptorForQuery(
            SQLiteStatementWrapper<SQLiteStatement> prog,
            String[] selectionArgs) throws SQLiteDoneExceptionWrapper {
        try {
            return DatabaseUtils.blobFileDescriptorForQuery(
                    prog.getSQLiteStatement(), selectionArgs
            );
        } catch (SQLiteDoneException wrapped) {
            throw new SQLiteDoneExceptionWrapper(wrapped);
        }
    }

    @Override
    public void createDbFromSqlStatements(Context context, String dbName, int dbVersion,
                                          String sqlStatements) {
        DatabaseUtils.createDbFromSqlStatements(context, dbName, dbVersion, sqlStatements);
    }
}
