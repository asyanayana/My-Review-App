package org.d3if1016.asessment2.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ReviewDao(context: Context, factory: SQLiteDatabase.CursorFactory?) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COl + " TEXT," +
                REVIEW_COL + " TEXT" + ")")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addReview(name : String, review : String ){
        val values = ContentValues()
        values.put(NAME_COl, name)
        values.put(REVIEW_COL, review)
        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getReview(): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }

    fun delete(name : String){
        val db = this.readableDatabase
        db.delete(TABLE_NAME, "$NAME_COl=?", arrayOf(name));
        db.close();
    }

    companion object{
        private val DATABASE_NAME = "ASESSMENT02"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "t_review"
        val ID_COL = "id"
        val NAME_COl = "name"
        val REVIEW_COL = "review"
    }
}