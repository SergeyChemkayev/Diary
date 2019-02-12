package com.example.diary.data;

import android.app.Application;
import android.arch.persistence.room.Room;

public class DiaryApplication extends Application {

    public static DiaryApplication INSTANCE;
    private TasksDatabase tasksDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        tasksDatabase = Room.databaseBuilder(this, TasksDatabase.class, "tasks").build();
    }

    public static DiaryApplication getINSTANCE() {
        return INSTANCE;
    }

    public TasksDatabase getTasksDatabase() {
        return tasksDatabase;
    }
}
