package com.example.roomdatabasewithlivedata;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public void insert(Student student);

    @Query("SELECT * FROM AndroidStudents_1")
    public List<Student> readData();

    @Delete
    public void delete(Student student);

}
