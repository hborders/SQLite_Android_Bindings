package org.sqlite.database.wrapper;

import org.sqlite.database.sqlite.SQLiteDatabase;

public interface DefaultDatabaseErrorHandlerWrapper<
        SQLiteDatabaseType,
        SQLiteStatementType,
        SQLiteCursorDriverType,
        SQLiteQueryType
        > {
    void onCorruption(SQLiteDatabaseWrapper<
            SQLiteDatabaseType,
            SQLiteStatementType,
            SQLiteCursorDriverType,
            SQLiteQueryType
            > dbObj);
}
