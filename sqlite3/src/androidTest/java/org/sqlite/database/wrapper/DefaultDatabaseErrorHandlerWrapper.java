package org.sqlite.database.wrapper;

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
