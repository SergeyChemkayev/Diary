package com.example.diary.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.example.diary.entities.Task;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;

@Dao
public abstract class TasksDao {

    @Query("SELECT * FROM tasks WHERE time_stamp BETWEEN :from AND :to")
    public abstract Flowable<List<Task>> findTasksBetweenDates(@TypeConverters({DateConverter.class}) Date from, @TypeConverters({DateConverter.class}) Date to);

    @Insert
    public abstract void insertTask(Task task);
}
