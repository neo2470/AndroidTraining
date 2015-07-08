package com.alex.entity;

import android.provider.BaseColumns;

/**
 * Created by alex on 15-7-8.
 * 联系人类
 */
public final class Contacts {


    public static abstract class Column implements BaseColumns {
        public static final String NAME = "name";
        public static final String AGE = "age";
    }

    public static final String TABLE_NAME = "CONTACTS";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
            Column._ID + " INTEGER PRIMARY KEY," +
            Column.NAME + " TEXT," +
            Column.AGE + " INTEGER)";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;// 姓名

    private int age;// 年龄

}
