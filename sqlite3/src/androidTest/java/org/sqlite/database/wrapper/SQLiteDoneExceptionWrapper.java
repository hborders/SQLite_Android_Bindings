package org.sqlite.database.wrapper;

public final class SQLiteDoneExceptionWrapper extends Exception {
    public final android.database.sqlite.SQLiteDoneException androidSQLiteDoneException;
    public final org.sqlite.database.sqlite.SQLiteDoneException sqliteSQLiteDoneException;

    public SQLiteDoneExceptionWrapper(
            android.database.sqlite.SQLiteDoneException androidSQLiteDoneException) {
        super(androidSQLiteDoneException);

        this.androidSQLiteDoneException = androidSQLiteDoneException;
        this.sqliteSQLiteDoneException = null;
    }

    public SQLiteDoneExceptionWrapper(
            org.sqlite.database.sqlite.SQLiteDoneException sqliteSQLiteDoneException) {
        super(sqliteSQLiteDoneException);

        this.androidSQLiteDoneException = null;
        this.sqliteSQLiteDoneException = sqliteSQLiteDoneException;
    }
}
