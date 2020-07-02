package org.sqlite.database;

public interface SQLiteTransactionListenerWrapper {
    void onBegin();
    void onCommit();
    void onRollback();
}
