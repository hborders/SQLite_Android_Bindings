package org.sqlite.database.wrapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.ParcelFileDescriptor;

import java.io.PrintStream;

public interface DatabaseUtilsWrapper<
        SQLiteDatabaseType,
        SQLiteStatementType extends SQLiteProgramType,
        SQLiteCursorDriverType,
        SQLiteQueryType,
        SQLiteProgramType,
        InsertHelperType
        > {
    void bindObjectToProgram(SQLiteStatementWrapper<SQLiteStatementType> prog, int index,
                             Object value);
    void appendEscapedSQLString(StringBuilder sb, String sqlString);
    String sqlEscapeString(String value);
    void appendValueToSql(StringBuilder sql, Object value);
    String getCollationKey(String name);
    String getHexCollationKey(String name);
    void dumpCursor(Cursor cursor);
    void dumpCursor(Cursor cursor, PrintStream stream);
    void dumpCursor(Cursor cursor, StringBuilder sb);
    String dumpCursorToString(Cursor cursor);
    void dumpCurrentRow(Cursor cursor);
    void dumpCurrentRow(Cursor cursor, PrintStream stream);
    void dumpCurrentRow(Cursor cursor, StringBuilder sb);
    String dumpCurrentRowToString(Cursor cursor);
    void cursorStringToContentValues(Cursor cursor, String field, ContentValues values);
    void cursorStringToInsertHelper(Cursor cursor, String field,
                                    InsertHelperWrapper<InsertHelperType> inserter, int index);
    void cursorStringToContentValues(Cursor cursor, String field,
                                     ContentValues values, String key);
    void cursorIntToContentValues(Cursor cursor, String field, ContentValues values);
    void cursorIntToContentValues(Cursor cursor, String field, ContentValues values,
                                  String key);
    void cursorLongToContentValues(Cursor cursor, String field, ContentValues values);
    void cursorLongToContentValues(Cursor cursor, String field, ContentValues values, String key);
    void cursorDoubleToCursorValues(Cursor cursor, String field, ContentValues values);
    void cursorDoubleToContentValues(Cursor cursor, String field, ContentValues values, String key);
    void cursorRowToContentValues(Cursor cursor, ContentValues values);
    long queryNumEntries(SQLiteDatabaseWrapper<
            SQLiteDatabaseType,
            SQLiteStatementType,
            SQLiteCursorDriverType,
            SQLiteQueryType
            > db, String table) throws SQLiteExceptionWrapper;
    long queryNumEntries(SQLiteDatabaseWrapper<
            SQLiteDatabaseType,
            SQLiteStatementType,
            SQLiteCursorDriverType,
            SQLiteQueryType
            >  db, String table, String selection);
    long queryNumEntries(SQLiteDatabaseWrapper<
            SQLiteDatabaseType,
            SQLiteStatementType,
            SQLiteCursorDriverType,
            SQLiteQueryType
            >  db, String table, String selection,
                         String[] selectionArgs);
    long longForQuery(SQLiteDatabaseWrapper<
            SQLiteDatabaseType,
            SQLiteStatementType,
            SQLiteCursorDriverType,
            SQLiteQueryType
            >  db, String query, String[] selectionArgs) throws SQLiteDoneExceptionWrapper;
    long longForQuery(SQLiteStatementWrapper<SQLiteStatementType> prog,
                      String[] selectionArgs) throws SQLiteDoneExceptionWrapper;
    String stringForQuery(SQLiteDatabaseWrapper<
            SQLiteDatabaseType,
            SQLiteStatementType,
            SQLiteCursorDriverType,
            SQLiteQueryType
            >  db, String query, String[] selectionArgs) throws SQLiteDoneExceptionWrapper;
    String stringForQuery(SQLiteStatementWrapper<SQLiteStatementType> prog, String[] selectionArgs);
    ParcelFileDescriptor blobFileDescriptorForQuery(
            SQLiteStatementWrapper<SQLiteStatementType> prog,
            String[] selectionArgs) throws SQLiteDoneExceptionWrapper;
    void createDbFromSqlStatements(
            Context context, String dbName, int dbVersion, String sqlStatements);
}
