package org.sqlite.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;

import java.util.List;
import java.util.Locale;

public class AndroidSQLiteDatabaseWrapper implements SQLiteDatabaseWrapper {
    private static final class AndroidCursorFactory implements SQLiteDatabase.CursorFactory {
        private final CursorFactoryWrapper cursorFactoryWrapper;

        private AndroidCursorFactory(CursorFactoryWrapper cursorFactoryWrapper) {
            this.cursorFactoryWrapper = cursorFactoryWrapper;
        }

        @Override
        public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery,
                                String editTable, SQLiteQuery query) {
            return cursorFactoryWrapper.newCursor(db, masterQuery, editTable, query);
        }
    }

    @Override
    public void beginTransaction() {

    }

    @Override
    public void beginTransactionNonExclusive() {

    }

    @Override
    public void beginTransactionWithListener(SQLiteTransactionListenerWrapper transactionListener) {

    }

    @Override
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListenerWrapper transactionListener) {

    }

    @Override
    public void endTransaction() {

    }

    @Override
    public void setTransactionSuccessful() {

    }

    @Override
    public boolean inTransaction() {
        return false;
    }

    @Override
    public boolean isDbLockedByCurrentThread() {
        return false;
    }

    @Override
    public boolean yieldIfContendedSafely() {
        return false;
    }

    @Override
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    @Override
    public void setVersion(int version) {

    }

    @Override
    public long getMaximumSize() {
        return 0;
    }

    @Override
    public long setMaximumSize(long numBytes) {
        return 0;
    }

    @Override
    public long getPageSize() {
        return 0;
    }

    @Override
    public void setPageSize(long numBytes) {

    }

    @Override
    public SQLiteStatementWrapper compileStatement(String sql) throws SQLExceptionWrapper {
        return null;
    }

    @Override
    public Cursor query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return null;
    }

    @Override
    public Cursor query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit, CancellationSignal cancellationSignal) {
        return null;
    }

    @Override
    public Cursor queryWithFactory(CursorFactoryWrapper cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return null;
    }

    @Override
    public Cursor queryWithFactory(CursorFactoryWrapper cursorFactory, boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit, CancellationSignal cancellationSignal) {
        return null;
    }

    @Override
    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return null;
    }

    @Override
    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        return null;
    }

    @Override
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return null;
    }

    @Override
    public Cursor rawQuery(String sql, String[] selectionArgs, CancellationSignal cancellationSignal) {
        return null;
    }

    @Override
    public Cursor rawQueryWithFactory(CursorFactoryWrapper cursorFactory, String sql, String[] selectionArgs, String editTable) {
        return null;
    }

    @Override
    public Cursor rawQueryWithFactory(CursorFactoryWrapper cursorFactory, String sql, String[] selectionArgs, String editTable, CancellationSignal cancellationSignal) {
        return null;
    }

    @Override
    public long insert(String table, String nullColumnHack, ContentValues values) {
        return 0;
    }

    @Override
    public long insertOrThrow(String table, String nullColumnHack, ContentValues values) throws SQLExceptionWrapper {
        return 0;
    }

    @Override
    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        return 0;
    }

    @Override
    public long replaceOrThrow(String table, String nullColumnHack, ContentValues initialValues) throws SQLExceptionWrapper {
        return 0;
    }

    @Override
    public long insertWithOnConflict(String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm) {
        return 0;
    }

    @Override
    public int delete(String table, String whereClause, String[] whereArgs) {
        return 0;
    }

    @Override
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        return 0;
    }

    @Override
    public int updateWithOnConflict(String table, ContentValues values, String whereClause, String[] whereArgs, int conflictAlgorithm) {
        return 0;
    }

    @Override
    public void execSQL(String sql) throws SQLExceptionWrapper {

    }

    @Override
    public void execSQL(String sql, Object[] bindArgs) throws SQLExceptionWrapper {

    }

    @Override
    public void validateSql(String sql, CancellationSignal cancellationSignal) {

    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public boolean needUpgrade(int newVersion) {
        return false;
    }

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public void setMaxSqlCacheSize(int cacheSize) {

    }

    @Override
    public void setForeignKeyConstraintsEnabled(boolean enable) {

    }

    @Override
    public boolean enableWriteAheadLogging() {
        return false;
    }

    @Override
    public void disableWriteAheadLogging() {

    }

    @Override
    public boolean isWriteAheadLoggingEnabled() {
        return false;
    }

    @Override
    public List<Pair<String, String>> getAttachedDbs() {
        return null;
    }
}
