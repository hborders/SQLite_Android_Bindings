package org.sqlite.database.wrapper;

public interface SQLiteDatabaseFlags {
    int getCreateIfNecessary();
    int getOpenReadonly();
    int getEnableWriteAheadLogging();
}
