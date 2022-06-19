package com.example.userprofile23_1;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.userprofile23_1.bean.Book;
import com.example.userprofile23_1.bean.Words;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Dictionary.db";
    private static final String TABLE_NAME_Book = "Book";
    private static final String TABLE_NAME_Words = "Words";

    private static final String CREATE_Book_SQL = "create table " + TABLE_NAME_Book +
            " (id integer primary key autoincrement, name text, is_selected integer)";
    private static final String CREATE_Words_SQL = "create table " + TABLE_NAME_Words +
            " (id integer primary key autoincrement, book_id integer, word text, translate text, is_learn integer, is_review integer, is_collect integer)";

    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Book_SQL);
        db.execSQL(CREATE_Words_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void initData(Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.character);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("character", "word：" + word);
                Log.d("character", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(1);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.culture);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("culture", "word：" + word);
                Log.d("culture", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(2);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.economics);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("economics", "word：" + word);
                Log.d("economics", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(3);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.education);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("education", "word：" + word);
                Log.d("education", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(4);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.life);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("life", "word：" + word);
                Log.d("life", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(5);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.natural);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("natural", "word：" + word);
                Log.d("natural", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(6);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.other);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("other", "word：" + word);
                Log.d("other", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(7);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.science);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("science", "word：" + word);
                Log.d("science", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(8);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }

        inputStream = resources.openRawResource(R.raw.sport);
        try(
                InputStreamReader isr = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader input = new BufferedReader(isr);
        ) {
            String s;
            while ((s = input.readLine()) != null) {
                String word = "", translate = "";
                for (int i = 0; i < s.length(); i++) {
                    int n = (int)s.charAt(i);
                    if(19968 <= n && n <40869) {
                        word = s.substring(0, i);
                        word.trim();
                        translate = s.substring(i);
                        translate.trim();
                        break;
                    }
                }
                Log.d("sport", "word：" + word);
                Log.d("sport", "translate：" + translate);
                Words words = new Words();
                words.setWord(word);
                words.setTranslate(translate);
                words.setBookId(9);
                insertWords(words);
            }
        } catch (Exception e) {
            Log.e("TAG", "delete: ", e);
        }
    }

    public long insertBook(Book book) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", book.getName());
        values.put("is_selected", book.getIsSelected());

        return db.insert(TABLE_NAME_Book, null, values);
    }

    public long insertWords(Words words) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("book_id", words.getBookId());
        values.put("word", words.getWord());
        values.put("translate", words.getTranslate());
        values.put("is_learn", 0);
        values.put("is_review", 0);
        values.put("is_collect", 0);

        return db.insert(TABLE_NAME_Words, null, values);
    }

    public int deleteFromDbByName(String name) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME_Book, "name = ?", new String[]{name});
    }

    public int updateData(String name) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("is_selected", 0);
        db.update(TABLE_NAME_Book, values, null, null);
        values.put("is_selected", 1);
        return db.update(TABLE_NAME_Book, values, "name = ?", new String[]{name});
    }

    public List<Book> queryFromDbByName(String name) {

        SQLiteDatabase db = getWritableDatabase();
        List<Book> bookList = new ArrayList<>();


        Cursor cursor = db.query(TABLE_NAME_Book, null, "name = ?", new String[]{name}, null, null, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String name1 = cursor.getString(cursor.getColumnIndex("name"));
                Integer isSelected = cursor.getInt(cursor.getColumnIndex("is_selected"));

                Book book = new Book();
                book.setId(id);
                book.setName(name1);
                book.setIsSelected(isSelected);

                bookList.add(book);
            }

            cursor.close();

        }

        return bookList;

    }



    public List<Book> queryAllFromDb() {

        SQLiteDatabase db = getWritableDatabase();
        List<Book> bookList = new ArrayList<>();


        Cursor cursor = db.query(TABLE_NAME_Book, null, null, null, null, null, null);

        if (cursor != null) {

            while (cursor.moveToNext()) {
                Integer id = cursor.getInt(cursor.getColumnIndex("id"));
                String name1 = cursor.getString(cursor.getColumnIndex("name"));
                Integer isSelected = cursor.getInt(cursor.getColumnIndex("is_selected"));


                Book book = new Book();
                book.setId(id);
                book.setName(name1);
                book.setIsSelected(isSelected);

                bookList.add(book);

            }
            cursor.close();
        }
        return bookList;
    }
}
