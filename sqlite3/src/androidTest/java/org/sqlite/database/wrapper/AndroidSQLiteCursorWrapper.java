package org.sqlite.database.wrapper;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AndroidSQLiteCursorWrapper implements SQLiteCursorWrapper {
    private final SQLiteCursor sqliteCursor;

    public AndroidSQLiteCursorWrapper(SQLiteCursor sqliteCursor) {
        this.sqliteCursor = sqliteCursor;
    }

    public SQLiteDatabase getDatabase() {
        return sqliteCursor.getDatabase();
    }

    public boolean onMove(int oldPosition, int newPosition) {
        return sqliteCursor.onMove(oldPosition, newPosition);
    }

    @Override
    public int getCount() {
        return sqliteCursor.getCount();
    }

    @Override
    public int getColumnIndex(String columnName) {
        return sqliteCursor.getColumnIndex(columnName);
    }

    @Override
    public String[] getColumnNames() {
        return sqliteCursor.getColumnNames();
    }

    @Override
    public void deactivate() {
        sqliteCursor.deactivate();
    }

    @Override
    public void close() {
        sqliteCursor.close();
    }

    @Override
    public boolean requery() {
        return sqliteCursor.requery();
    }

    @Override
    public void setWindow(CursorWindow window) {
        sqliteCursor.setWindow(window);
    }

    @Override
    public void setSelectionArguments(String[] selectionArgs) {
        sqliteCursor.setSelectionArguments(selectionArgs);
    }

    @Override
    public byte[] getBlob(int columnIndex) {
        return sqliteCursor.getBlob(columnIndex);
    }

    @Override
    public String getString(int columnIndex) {
        return sqliteCursor.getString(columnIndex);
    }

    @Override
    public void copyStringToBuffer(int columnIndex, CharArrayBuffer buffer) {
        sqliteCursor.copyStringToBuffer(columnIndex, buffer);
    }

    @Override
    public short getShort(int columnIndex) {
        return sqliteCursor.getShort(columnIndex);
    }

    @Override
    public int getInt(int columnIndex) {
        return sqliteCursor.getInt(columnIndex);
    }

    @Override
    public long getLong(int columnIndex) {
        return sqliteCursor.getLong(columnIndex);
    }

    @Override
    public float getFloat(int columnIndex) {
        return sqliteCursor.getFloat(columnIndex);
    }

    @Override
    public double getDouble(int columnIndex) {
        return sqliteCursor.getDouble(columnIndex);
    }

    @Override
    public boolean isNull(int columnIndex) {
        return sqliteCursor.isNull(columnIndex);
    }

    @Deprecated
    public boolean isBlob(int columnIndex) {
        return sqliteCursor.isBlob(columnIndex);
    }

    @Deprecated
    public boolean isString(int columnIndex) {
        return sqliteCursor.isString(columnIndex);
    }

    @Deprecated
    public boolean isLong(int columnIndex) {
        return sqliteCursor.isLong(columnIndex);
    }

    @Deprecated
    public boolean isFloat(int columnIndex) {
        return sqliteCursor.isFloat(columnIndex);
    }

    @Override
    public int getType(int columnIndex) {
        return sqliteCursor.getType(columnIndex);
    }

    public CursorWindow getWindow() {
        return sqliteCursor.getWindow();
    }

    public boolean hasWindow() {
        return sqliteCursor.hasWindow();
    }

    @Override
    public int getColumnCount() {
        return sqliteCursor.getColumnCount();
    }

    @Override
    public boolean isClosed() {
        return sqliteCursor.isClosed();
    }

    @Override
    public void fillWindow(int position, CursorWindow window) {
        sqliteCursor.fillWindow(position, window);
    }

    @Override
    public int getColumnIndexOrThrow(String columnName) {
        return sqliteCursor.getColumnIndexOrThrow(columnName);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return sqliteCursor.getColumnName(columnIndex);
    }

    @Override
    public void registerContentObserver(ContentObserver observer) {
        sqliteCursor.registerContentObserver(observer);
    }

    @Override
    public void unregisterContentObserver(ContentObserver observer) {
        sqliteCursor.unregisterContentObserver(observer);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        sqliteCursor.registerDataSetObserver(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        sqliteCursor.unregisterDataSetObserver(observer);
    }

    @Override
    public void setNotificationUri(ContentResolver cr, Uri notifyUri) {
        sqliteCursor.setNotificationUri(cr, notifyUri);
    }

    @Override
    public void setNotificationUris(@NonNull ContentResolver cr, @NonNull List<Uri> notifyUris) {
        sqliteCursor.setNotificationUris(cr, notifyUris);
    }

    @Override
    public Uri getNotificationUri() {
        return sqliteCursor.getNotificationUri();
    }

    @Nullable
    @Override
    public List<Uri> getNotificationUris() {
        return sqliteCursor.getNotificationUris();
    }

    @Override
    public boolean getWantsAllOnMoveCalls() {
        return sqliteCursor.getWantsAllOnMoveCalls();
    }

    @Override
    public void setExtras(Bundle extras) {
        sqliteCursor.setExtras(extras);
    }

    @Override
    public Bundle getExtras() {
        return sqliteCursor.getExtras();
    }

    @Override
    public Bundle respond(Bundle extras) {
        return sqliteCursor.respond(extras);
    }

    @Override
    public int getPosition() {
        return sqliteCursor.getPosition();
    }

    @Override
    public boolean move(int offset) {
        return sqliteCursor.move(offset);
    }

    @Override
    public boolean moveToPosition(int position) {
        return sqliteCursor.moveToPosition(position);
    }

    @Override
    public boolean moveToFirst() {
        return sqliteCursor.moveToFirst();
    }

    @Override
    public boolean moveToLast() {
        return sqliteCursor.moveToLast();
    }

    @Override
    public boolean moveToNext() {
        return sqliteCursor.moveToNext();
    }

    @Override
    public boolean moveToPrevious() {
        return sqliteCursor.moveToPrevious();
    }

    @Override
    public boolean isFirst() {
        return sqliteCursor.isFirst();
    }

    @Override
    public boolean isLast() {
        return sqliteCursor.isLast();
    }

    @Override
    public boolean isBeforeFirst() {
        return sqliteCursor.isBeforeFirst();
    }

    @Override
    public boolean isAfterLast() {
        return sqliteCursor.isAfterLast();
    }
}
