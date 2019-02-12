package com.example.diary.data;

import com.example.diary.entities.Task;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;

public interface DataSource {

    Flowable<List<Task>> getTasksBetweenDates(Date from, Date to);
    void insertTask(Task task);
}
