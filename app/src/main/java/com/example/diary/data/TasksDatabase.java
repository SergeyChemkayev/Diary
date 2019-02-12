package com.example.diary.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.diary.entities.Task;

@Database(entities = {Task.class}, version =1, exportSchema = false)
public abstract class TasksDatabase extends RoomDatabase {
    public abstract TasksDao tasksDao();
}
