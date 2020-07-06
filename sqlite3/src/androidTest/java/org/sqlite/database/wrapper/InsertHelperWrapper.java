package org.sqlite.database.wrapper;

import android.content.ContentValues;

public interface InsertHelperWrapper<InsertHelperType> {
    InsertHelperType getInsertHelper();

    int getColumnIndex(String key);
    void bind(int index, double value);
    void bind(int index, float value);
    void bind(int index, long value);
    void bind(int index, int value);
    void bind(int index, boolean value);
    void bindNull(int index);
    void bind(int index, byte[] value);
    void bind(int index, String value);
    long insert(ContentValues values);
    long execute();
    void prepareForInsert();
    void prepareForReplace();
    long replace(ContentValues values);
    void close();

}
