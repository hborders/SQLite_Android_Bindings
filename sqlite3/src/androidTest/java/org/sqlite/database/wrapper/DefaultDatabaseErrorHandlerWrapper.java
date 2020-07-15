package org.sqlite.database.wrapper;

import org.sqlite.database.sqlite.SQLiteDatabase;

public interface DefaultDatabaseErrorHandlerWrapper<
        SQLiteDatabaseType,
        SQLiteStatementType,
        SQLiteCursorDriverType,
        SQLiteQueryType,
        CursorFactoryType
        > {
    void onCorruption(SQLiteDatabaseWrapper<
            SQLiteDatabaseType,
            SQLiteStatementType,
            SQLiteCursorDriverType,
            SQLiteQueryType,
            CursorFactoryType
            > dbObj);
}
