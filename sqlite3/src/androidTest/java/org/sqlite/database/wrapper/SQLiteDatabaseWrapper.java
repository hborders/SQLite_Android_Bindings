package org.sqlite.database.wrapper;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;

import java.util.List;
import java.util.Locale;

public interface SQLiteDatabaseWrapper<
        SQLiteDatabaseType,
        SQLiteCursorDriverType,
        SQLiteQueryType
        > {
    interface CursorFactoryWrapper<
            SQLiteDatabaseType,
            SQLiteCursorDriverType,
            SQLiteQueryType
            > {
        Cursor newCursor(SQLiteDatabaseType db,
                         SQLiteCursorDriverType masterQuery, String editTable,
                         SQLiteQueryType query);
    }

    void close();

    void beginTransaction();
    void beginTransactionNonExclusive();
    void beginTransactionWithListener(SQLiteTransactionListenerWrapper transactionListener);
    void beginTransactionWithListenerNonExclusive(SQLiteTransactionListenerWrapper transactionListener);
    void endTransaction();
    void setTransactionSuccessful();
    boolean inTransaction();
    boolean isDbLockedByCurrentThread();
    boolean yieldIfContendedSafely();
    boolean yieldIfContendedSafely(long sleepAfterYieldDelay);
    int getVersion();
    void setVersion(int version);
    long getMaximumSize();
    long setMaximumSize(long numBytes);
    long getPageSize();
    void setPageSize(long numBytes);
    SQLiteStatementWrapper compileStatement(String sql) throws SQLExceptionWrapper;
    Cursor query(boolean distinct, String table, String[] columns,
                 String selection, String[] selectionArgs, String groupBy,
                 String having, String orderBy, String limit);
    Cursor query(boolean distinct, String table, String[] columns,
                 String selection, String[] selectionArgs, String groupBy,
                 String having, String orderBy, String limit, CancellationSignal cancellationSignal);
    Cursor queryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabaseType,
                    SQLiteCursorDriverType,
                    SQLiteQueryType
                    > cursorFactory,
            boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit);
    Cursor queryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabaseType,
                    SQLiteCursorDriverType,
                    SQLiteQueryType
                    > cursorFactory,
            boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit, CancellationSignal cancellationSignal);
    Cursor query(String table, String[] columns, String selection,
                 String[] selectionArgs, String groupBy, String having,
                 String orderBy);
    Cursor query(String table, String[] columns, String selection,
                 String[] selectionArgs, String groupBy, String having,
                 String orderBy, String limit);
    Cursor rawQuery(String sql, String[] selectionArgs);
    Cursor rawQuery(String sql, String[] selectionArgs,
                    CancellationSignal cancellationSignal);
    Cursor rawQueryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabaseType,
                    SQLiteCursorDriverType,
                    SQLiteQueryType
                    > cursorFactory, String sql, String[] selectionArgs,
            String editTable);
    Cursor rawQueryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabaseType,
                    SQLiteCursorDriverType,
                    SQLiteQueryType
                    > cursorFactory, String sql, String[] selectionArgs,
            String editTable, CancellationSignal cancellationSignal);
    long insert(String table, String nullColumnHack, ContentValues values);
    long insertOrThrow(String table, String nullColumnHack, ContentValues values)
            throws SQLExceptionWrapper;
    long replace(String table, String nullColumnHack, ContentValues initialValues);
    long replaceOrThrow(String table, String nullColumnHack,
                        ContentValues initialValues) throws SQLExceptionWrapper;
    long insertWithOnConflict(String table, String nullColumnHack,
                              ContentValues initialValues, int conflictAlgorithm);
    int delete(String table, String whereClause, String[] whereArgs);
    int update(String table, ContentValues values, String whereClause, String[] whereArgs);
    int updateWithOnConflict(String table, ContentValues values,
                             String whereClause, String[] whereArgs, int conflictAlgorithm);
    void execSQL(String sql) throws SQLExceptionWrapper;
    void execSQL(String sql, Object[] bindArgs) throws SQLExceptionWrapper;
    void validateSql(String sql, CancellationSignal cancellationSignal);
    boolean isReadOnly();
    boolean isOpen();
    boolean needUpgrade(int newVersion);
    String getPath();
    void setLocale(Locale locale);
    void setMaxSqlCacheSize(int cacheSize);
    void setForeignKeyConstraintsEnabled(boolean enable);
    boolean enableWriteAheadLogging();
    void disableWriteAheadLogging();
    boolean isWriteAheadLoggingEnabled();
    List<Pair<String, String>> getAttachedDbs();
}
