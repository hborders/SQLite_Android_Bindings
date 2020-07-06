package org.sqlite.database.wrapper;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Pair;

import java.util.List;
import java.util.Locale;

public class AndroidSQLiteDatabaseWrapper implements SQLiteDatabaseWrapper<
        SQLiteDatabase,
        SQLiteStatement,
        SQLiteCursorDriver,
        SQLiteQuery
        > {
    private static final class AndroidCursorFactory implements SQLiteDatabase.CursorFactory {
        private final CursorFactoryWrapper<
                SQLiteDatabase,
                SQLiteCursorDriver,
                SQLiteQuery
                > cursorFactoryWrapper;

        private AndroidCursorFactory(
                CursorFactoryWrapper<
                        SQLiteDatabase,
                        SQLiteCursorDriver,
                        SQLiteQuery
                        > cursorFactoryWrapper) {
            this.cursorFactoryWrapper = cursorFactoryWrapper;
        }

        @Override
        public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery,
                                String editTable, SQLiteQuery query) {
            return cursorFactoryWrapper.newCursor(db, masterQuery, editTable, query);
        }
    }

    private final SQLiteDatabase sqliteDatabase;

    public AndroidSQLiteDatabaseWrapper(SQLiteDatabase sqliteDatabase) {
        this.sqliteDatabase = sqliteDatabase;
    }

    @Override
    public SQLiteDatabase getSQLiteDatabase() {
        return sqliteDatabase;
    }

    @Override
    public void close() {
        sqliteDatabase.close();
    }

    @Override
    public void beginTransaction() {
        sqliteDatabase.beginTransaction();
    }

    @Override
    public void beginTransactionNonExclusive() {
        sqliteDatabase.beginTransactionNonExclusive();
    }

    @Override
    public void beginTransactionWithListener(
            final SQLiteTransactionListenerWrapper transactionListener
    ) {
        sqliteDatabase.beginTransactionWithListener(new SQLiteTransactionListener() {
            @Override
            public void onBegin() {
                transactionListener.onBegin();
            }

            @Override
            public void onCommit() {
                transactionListener.onCommit();
            }

            @Override
            public void onRollback() {
                transactionListener.onRollback();
            }
        });
    }

    @Override
    public void beginTransactionWithListenerNonExclusive(
            final SQLiteTransactionListenerWrapper transactionListener
    ) {
        sqliteDatabase.beginTransactionWithListenerNonExclusive(new SQLiteTransactionListener() {
            @Override
            public void onBegin() {
                transactionListener.onBegin();
            }

            @Override
            public void onCommit() {
                transactionListener.onCommit();
            }

            @Override
            public void onRollback() {
                transactionListener.onRollback();
            }
        });
    }

    @Override
    public void endTransaction() {
        sqliteDatabase.endTransaction();
    }

    @Override
    public void setTransactionSuccessful() {
        sqliteDatabase.setTransactionSuccessful();
    }

    @Override
    public boolean inTransaction() {
        return sqliteDatabase.inTransaction();
    }

    @Override
    public boolean isDbLockedByCurrentThread() {
        return sqliteDatabase.isDbLockedByCurrentThread();
    }

    @Override
    public boolean yieldIfContendedSafely() {
        return sqliteDatabase.yieldIfContendedSafely();
    }

    @Override
    public boolean yieldIfContendedSafely(long sleepAfterYieldDelay) {
        return sqliteDatabase.yieldIfContendedSafely(sleepAfterYieldDelay);
    }

    @Override
    public int getVersion() {
        return sqliteDatabase.getVersion();
    }

    @Override
    public void setVersion(int version) {
        sqliteDatabase.setVersion(version);
    }

    @Override
    public long getMaximumSize() {
        return sqliteDatabase.getMaximumSize();
    }

    @Override
    public long setMaximumSize(long numBytes) {
        return sqliteDatabase.setMaximumSize(numBytes);
    }

    @Override
    public long getPageSize() {
        return sqliteDatabase.getPageSize();
    }

    @Override
    public void setPageSize(long numBytes) {
        sqliteDatabase.setPageSize(numBytes);
    }

    @Override
    public SQLiteStatementWrapper<SQLiteStatement> compileStatement(String sql) throws SQLExceptionWrapper {
        try {
            final SQLiteStatement sqliteStatement = sqliteDatabase.compileStatement(sql);
            return new SQLiteStatementWrapper<SQLiteStatement>() {
                @Override
                public void close() {
                    sqliteStatement.close();
                }

                @Override
                public SQLiteStatement getSQLiteStatement() {
                    return sqliteStatement;
                }

                @Override
                public void execute() {
                    sqliteStatement.execute();
                }

                @Override
                public int executeUpdateDelete() {
                    return sqliteStatement.executeUpdateDelete();
                }

                @Override
                public long executeInsert() {
                    return sqliteStatement.executeInsert();
                }

                @Override
                public long simpleQueryForLong() {
                    return sqliteStatement.simpleQueryForLong();
                }

                @Override
                public String simpleQueryForString() {
                    return sqliteStatement.simpleQueryForString();
                }

                @Override
                public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
                    return sqliteStatement.simpleQueryForBlobFileDescriptor();
                }
            };
        } catch (SQLException wrapped) {
            throw new SQLExceptionWrapper(wrapped);
        }
    }

    @Override
    public Cursor query(boolean distinct, String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having, String orderBy,
                        String limit) {
        return sqliteDatabase.query(
                distinct, table, columns, selection, selectionArgs, groupBy, having, orderBy, limit
        );
    }

    @Override
    public Cursor query(boolean distinct, String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having, String orderBy,
                        String limit, CancellationSignal cancellationSignal) {
        return sqliteDatabase.query(
                distinct, table, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit, cancellationSignal
        );
    }

    @Override
    public Cursor queryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabase,
                    SQLiteCursorDriver,
                    SQLiteQuery
                    > cursorFactory, boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy,
            String having, String orderBy, String limit) {
        return sqliteDatabase.queryWithFactory(
                new AndroidCursorFactory(cursorFactory),
                distinct, table, columns,
                selection, selectionArgs, groupBy,
                having, orderBy, limit
        );
    }

    @Override
    public Cursor queryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabase,
                    SQLiteCursorDriver,
                    SQLiteQuery
                    > cursorFactory, boolean distinct, String table, String[] columns,
            String selection, String[] selectionArgs, String groupBy, String having,
            String orderBy, String limit, CancellationSignal cancellationSignal) {
        return sqliteDatabase.queryWithFactory(
                new AndroidCursorFactory(cursorFactory),
                distinct, table, columns,
                selection, selectionArgs, groupBy,
                having, orderBy, limit, cancellationSignal
        );
    }

    @Override
    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having, String orderBy) {
        return sqliteDatabase.query(
                table, columns, selection, selectionArgs, groupBy, having, orderBy
        );
    }

    @Override
    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs,
                        String groupBy, String having, String orderBy, String limit) {
        return sqliteDatabase.query(
                table, columns, selection, selectionArgs, groupBy, having, orderBy, limit
        );
    }

    @Override
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return sqliteDatabase.rawQuery(sql, selectionArgs);
    }

    @Override
    public Cursor rawQuery(
            String sql, String[] selectionArgs, CancellationSignal cancellationSignal
    ) {
        return sqliteDatabase.rawQuery(sql, selectionArgs, cancellationSignal);
    }

    @Override
    public Cursor rawQueryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabase,
                    SQLiteCursorDriver,
                    SQLiteQuery
                    > cursorFactory, String sql, String[] selectionArgs, String editTable) {
        return sqliteDatabase.rawQueryWithFactory(
                new AndroidCursorFactory(cursorFactory),
                sql, selectionArgs, editTable
        );
    }

    @Override
    public Cursor rawQueryWithFactory(
            CursorFactoryWrapper<
                    SQLiteDatabase,
                    SQLiteCursorDriver,
                    SQLiteQuery
                    > cursorFactory, String sql, String[] selectionArgs,
            String editTable, CancellationSignal cancellationSignal) {
        return sqliteDatabase.rawQueryWithFactory(
                new AndroidCursorFactory(cursorFactory),
                sql, selectionArgs, editTable, cancellationSignal
        );
    }

    @Override
    public long insert(String table, String nullColumnHack, ContentValues values) {
        return sqliteDatabase.insert(table, nullColumnHack, values);
    }

    @Override
    public long insertOrThrow(
            String table, String nullColumnHack, ContentValues values
    ) throws SQLExceptionWrapper {
        try {
            return sqliteDatabase.insertOrThrow(table, nullColumnHack, values);
        } catch (SQLException wrapped) {
            throw new SQLExceptionWrapper(wrapped);
        }
    }

    @Override
    public long replace(String table, String nullColumnHack, ContentValues initialValues) {
        return sqliteDatabase.replace(table, nullColumnHack, initialValues);
    }

    @Override
    public long replaceOrThrow(
            String table, String nullColumnHack, ContentValues initialValues
    ) throws SQLExceptionWrapper {
        try {
            return sqliteDatabase.replaceOrThrow(table, nullColumnHack, initialValues);
        } catch (SQLException wrapped) {
            throw new SQLExceptionWrapper(wrapped);
        }
    }

    @Override
    public long insertWithOnConflict(
            String table, String nullColumnHack, ContentValues initialValues, int conflictAlgorithm
    ) {
        return sqliteDatabase.insertWithOnConflict(
                table, nullColumnHack, initialValues, conflictAlgorithm
        );
    }

    @Override
    public int delete(String table, String whereClause, String[] whereArgs) {
        return sqliteDatabase.delete(table, whereClause, whereArgs);
    }

    @Override
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        return sqliteDatabase.update(table, values, whereClause, whereArgs);
    }

    @Override
    public int updateWithOnConflict(
            String table, ContentValues values, String whereClause,
            String[] whereArgs, int conflictAlgorithm) {
        return sqliteDatabase.updateWithOnConflict(
                table, values, whereClause, whereArgs, conflictAlgorithm
        );
    }

    @Override
    public void execSQL(String sql) throws SQLExceptionWrapper {
        try {
            sqliteDatabase.execSQL(sql);
        } catch (SQLException wrapped) {
            throw new SQLExceptionWrapper(wrapped);
        }
    }

    @Override
    public void execSQL(String sql, Object[] bindArgs) throws SQLExceptionWrapper {
        try {
            sqliteDatabase.execSQL(sql, bindArgs);
        } catch (SQLException wrapped) {
            throw new SQLExceptionWrapper(wrapped);
        }
    }

    @Override
    public void validateSql(String sql, CancellationSignal cancellationSignal) {
        sqliteDatabase.validateSql(sql, cancellationSignal);
    }

    @Override
    public boolean isReadOnly() {
        return sqliteDatabase.isReadOnly();
    }

    @Override
    public boolean isOpen() {
        return sqliteDatabase.isOpen();
    }

    @Override
    public boolean needUpgrade(int newVersion) {
        return sqliteDatabase.needUpgrade(newVersion);
    }

    @Override
    public String getPath() {
        return sqliteDatabase.getPath();
    }

    @Override
    public void setLocale(Locale locale) {
        sqliteDatabase.setLocale(locale);
    }

    @Override
    public void setMaxSqlCacheSize(int cacheSize) {
        sqliteDatabase.setMaxSqlCacheSize(cacheSize);
    }

    @Override
    public void setForeignKeyConstraintsEnabled(boolean enable) {
        sqliteDatabase.setForeignKeyConstraintsEnabled(enable);
    }

    @Override
    public boolean enableWriteAheadLogging() {
        return sqliteDatabase.enableWriteAheadLogging();
    }

    @Override
    public void disableWriteAheadLogging() {
        sqliteDatabase.disableWriteAheadLogging();
    }

    @Override
    public boolean isWriteAheadLoggingEnabled() {
        return sqliteDatabase.isWriteAheadLoggingEnabled();
    }

    @Override
    public List<Pair<String, String>> getAttachedDbs() {
        return sqliteDatabase.getAttachedDbs();
    }
}
