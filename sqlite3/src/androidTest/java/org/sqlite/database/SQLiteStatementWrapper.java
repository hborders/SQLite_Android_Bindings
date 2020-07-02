package org.sqlite.database;

import android.os.ParcelFileDescriptor;

public interface SQLiteStatementWrapper {
    void execute();
    int executeUpdateDelete();
    long executeInsert();
    long simpleQueryForLong();
    String simpleQueryForString();
    ParcelFileDescriptor simpleQueryForBlobFileDescriptor();
}
