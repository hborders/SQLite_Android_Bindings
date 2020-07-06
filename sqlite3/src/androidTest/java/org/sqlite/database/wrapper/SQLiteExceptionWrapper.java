package org.sqlite.database.wrapper;

public final class SQLiteExceptionWrapper extends Exception {
    public final android.database.sqlite.SQLiteException androidSQLiteException;
    public final org.sqlite.database.sqlite.SQLiteException sqliteSQLiteException;

    public SQLiteExceptionWrapper(android.database.sqlite.SQLiteException androidSQLiteException) {
        super(androidSQLiteException);

        this.androidSQLiteException = androidSQLiteException;
        this.sqliteSQLiteException = null;
    }

    public SQLiteExceptionWrapper(org.sqlite.database.sqlite.SQLiteException sqliteSQLiteException) {
        super(sqliteSQLiteException);

        this.androidSQLiteException = null;
        this.sqliteSQLiteException = sqliteSQLiteException;
    }
}
