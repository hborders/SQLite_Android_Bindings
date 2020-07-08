package org.sqlite.database.wrapper;

import android.os.ParcelFileDescriptor;

import java.io.Closeable;

public interface SQLiteStatementWrapper<SQLiteStatementType> extends Closeable {
    void close();

    SQLiteStatementType getSQLiteStatement();

    void bindLong(int index, long value);
    void bindString(int index, String value);
    void clearBindings();
    void bindAllArgsAsStrings(String[] bindArgs);

    void execute() throws SQLExceptionWrapper, SQLiteConstraintExceptionWrapper;
    int executeUpdateDelete();
    long executeInsert();
    long simpleQueryForLong() throws SQLiteDoneExceptionWrapper;
    String simpleQueryForString() throws SQLiteDoneExceptionWrapper;
    ParcelFileDescriptor simpleQueryForBlobFileDescriptor();
}
