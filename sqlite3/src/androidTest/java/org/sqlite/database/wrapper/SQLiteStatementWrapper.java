package org.sqlite.database.wrapper;

import android.os.ParcelFileDescriptor;

import java.io.Closeable;

public interface SQLiteStatementWrapper<SQLiteStatementType> extends Closeable {
    void close();

    SQLiteStatementType getSQLiteStatement();

    void execute();
    int executeUpdateDelete();
    long executeInsert();
    long simpleQueryForLong();
    String simpleQueryForString();
    ParcelFileDescriptor simpleQueryForBlobFileDescriptor();
}
