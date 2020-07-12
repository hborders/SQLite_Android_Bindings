package org.sqlite.database.wrapper;

import android.database.Cursor;
import android.database.CursorWindow;

public interface SQLiteCursorWrapper extends Cursor {
    void setWindow(CursorWindow window);
    void setSelectionArguments(String[] selectionArgs);
    void fillWindow(int position, CursorWindow window);
}
