package org.sqlite.database.wrapper;

import android.os.ParcelFileDescriptor;

public interface SQLiteStatementWrapper {
    void execute();
    int executeUpdateDelete();
    long executeInsert();
    long simpleQueryForLong();
    String simpleQueryForString();
    ParcelFileDescriptor simpleQueryForBlobFileDescriptor();
}
