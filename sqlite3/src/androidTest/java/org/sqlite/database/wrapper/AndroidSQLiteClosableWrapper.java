package org.sqlite.database.wrapper;

import android.database.sqlite.SQLiteClosable;

public final class AndroidSQLiteClosableWrapper extends SQLiteClosable implements SQLiteClosableWrapper {
    private boolean onAllReferencesReleasedCalled = false;
    private boolean onAllReferencesReleasedFromContainerCalled = false;

    @Override
    public void onAllReferencesReleased() {
        onAllReferencesReleasedCalled = true;
    }

    @Override
    public void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleasedFromContainerCalled = true;
    }


    @Override
    public boolean isOnAllReferencesReleasedCalled() {
        return onAllReferencesReleasedCalled;
    }

    @Override
    public boolean isOnAllReferencesReleasedFromContainerCalled() {
        return onAllReferencesReleasedFromContainerCalled;
    }
}
