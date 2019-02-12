package com.example.diary.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.diary.entities.Task;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class TasksDao {

    @Query("SELECT * FROM tasks WHERE time_stamp BETWEEN :from AND :to")
    public abstract Flowable<List<Task>> findTasksBetweenDates(Date from, Date to);

    @Insert
    public abstract void insertTask(Task task);
}
