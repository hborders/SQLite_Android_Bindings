package org.sqlite.database;

import org.sqlite.database.sqlite.SQLiteException;

public class SQLExceptionWrapper extends Exception {
    final android.database.SQLException androidSQLException;
    final org.sqlite.database.SQLException sqliteSQLException;

    public SQLExceptionWrapper(android.database.SQLException androidSQLException) {
        super(androidSQLException);
        this.androidSQLException = androidSQLException;
        this.sqliteSQLException = null;
    }

    public SQLExceptionWrapper(org.sqlite.database.SQLException sqliteSQLException) {
        super(sqliteSQLException);
        this.androidSQLException = null;
        this.sqliteSQLException = sqliteSQLException;
    }
}
