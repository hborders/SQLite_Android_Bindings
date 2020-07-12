package org.sqlite.database.wrapper;

import java.io.Closeable;

public interface SQLiteClosableWrapper extends Closeable {
    void close();

    void acquireReference();
    void releaseReference();
    void releaseReferenceFromContainer();

    void onAllReferencesReleased();
    void onAllReferencesReleasedFromContainer();

    boolean isOnAllReferencesReleasedCalled();
    boolean isOnAllReferencesReleasedFromContainerCalled();
}
