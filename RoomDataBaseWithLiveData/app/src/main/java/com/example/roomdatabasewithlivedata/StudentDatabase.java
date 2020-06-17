package com.example.roomdatabasewithlivedata;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDAO myDao();
    
}
