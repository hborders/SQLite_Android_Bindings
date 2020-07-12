package org.sqlite.database.wrapper;

import android.content.ContentValues;

import org.sqlite.database.DatabaseUtils;

public final class SQLiteInsertHelperWrapper implements InsertHelperWrapper<DatabaseUtils.InsertHelper> {
    private final DatabaseUtils.InsertHelper insertHelper;

    public SQLiteInsertHelperWrapper(DatabaseUtils.InsertHelper insertHelper) {
        this.insertHelper = insertHelper;
    }

    @Override
    public DatabaseUtils.InsertHelper getInsertHelper() {
        return insertHelper;
    }

    @Override
    public int getColumnIndex(String key) {
        return insertHelper.getColumnIndex(key);
    }

    @Override
    public void bind(int index, double value) {
        insertHelper.bind(index, value);
    }

    @Override
    public void bind(int index, float value) {
        insertHelper.bind(index, value);
    }

    @Override
    public void bind(int index, long value) {
        insertHelper.bind(index, value);
    }

    @Override
    public void bind(int index, int value) {
        insertHelper.bind(index, value);
    }

    @Override
    public void bind(int index, boolean value) {
        insertHelper.bind(index, value);
    }

    @Override
    public void bindNull(int index) {
        insertHelper.bindNull(index);

    }

    @Override
    public void bind(int index, byte[] value) {
        insertHelper.bind(index, value);
    }

    @Override
    public void bind(int index, String value) {
        insertHelper.bind(index, value);
    }

    @Override
    public long insert(ContentValues values) {
        return insertHelper.insert(values);
    }

    @Override
    public long execute() {
        return insertHelper.execute();
    }

    @Override
    public void prepareForInsert() {
        insertHelper.prepareForInsert();
    }

    @Override
    public void prepareForReplace() {
        insertHelper.prepareForReplace();
    }

    @Override
    public long replace(ContentValues values) {
        return insertHelper.replace(values);
    }

    @Override
    public void close() {
        insertHelper.close();
    }
}
