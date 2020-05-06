package lior.com.mymusicapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SongDBHelper extends SQLiteOpenHelper {

    private static final String SONG_TABLE_NAME = "SONG";
    private static final String SONG_ID = "ID";
    private static final String SONG_NAME = "SONG_NAME";
    private static final String SINGER_NAME = "SINGER_NAME";
    private static final String SONG_IMAGE = "IMAGE";
    private Context ctx;

    public SongDBHelper(Context context) {
        super(context, SONG_TABLE_NAME, null, 6);

        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + SONG_TABLE_NAME + "(" +
                SONG_ID + " INTEGER PRIMARY KEY, " +
                SINGER_NAME + " TEXT, " +
                SONG_NAME + " TEXT, " +
                SONG_IMAGE + " TEXT " + ")";
        try {
            db.execSQL(CREATE_TABLE);
        } catch (SQLiteException ex) {
            Log.e("SQLiteException", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SONG_TABLE_NAME);
        onCreate(db);
    }

    public void addSong(String singerName, String songName, String songImage) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SINGER_NAME, singerName);
        contentValues.put(SONG_NAME, songName);
        contentValues.put(SONG_IMAGE, songImage);

        db.insertOrThrow(SONG_TABLE_NAME, null, contentValues);
        db.close();
    }

    public void deleteData() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL("delete from " + SONG_TABLE_NAME);
        } catch (SQLiteException e) {
            Log.e("SongDBHelper", e.getMessage());
        } finally {
            db.close();
        }
    }

    public ArrayList<SongModel> getAllSongs() {
        ArrayList<SongModel> songModels = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(SONG_TABLE_NAME, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int colID = cursor.getColumnIndex(SONG_ID);
            int id = cursor.getInt(colID);
            String singerName = cursor.getString(1);
            String songName = cursor.getString(2);
            String songImage = cursor.getString(3);
            SongModel songModel = new SongModel(singerName, songName, songImage);
            songModel.setId(id);
            songModels.add(songModel);
        }
        cursor.close();
        return songModels;
    }

}
