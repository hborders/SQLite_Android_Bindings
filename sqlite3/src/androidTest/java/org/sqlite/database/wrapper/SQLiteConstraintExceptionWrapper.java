package org.sqlite.database.wrapper;

public final class SQLiteConstraintExceptionWrapper extends Exception {
    public final android.database.sqlite.SQLiteConstraintException androidSQLiteConstraintException;
    public final org.sqlite.database.sqlite.SQLiteConstraintException sqliteSQLiteConstraintException;

    public SQLiteConstraintExceptionWrapper(
            android.database.sqlite.SQLiteConstraintException androidSQLiteConstraintException) {
        super(androidSQLiteConstraintException);

        this.androidSQLiteConstraintException = androidSQLiteConstraintException;
        this.sqliteSQLiteConstraintException = null;
    }

    public SQLiteConstraintExceptionWrapper(
            org.sqlite.database.sqlite.SQLiteConstraintException sqliteSQLiteConstraintException) {
        super(sqliteSQLiteConstraintException);

        this.androidSQLiteConstraintException = null;
        this.sqliteSQLiteConstraintException = sqliteSQLiteConstraintException;
    }
}
