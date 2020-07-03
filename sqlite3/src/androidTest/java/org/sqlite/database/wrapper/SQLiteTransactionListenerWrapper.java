package org.sqlite.database.wrapper;

public interface SQLiteTransactionListenerWrapper {
    void onBegin();
    void onCommit();
    void onRollback();
}
