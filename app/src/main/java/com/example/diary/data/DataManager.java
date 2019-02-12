package com.example.diary.data;

import com.example.diary.entities.Task;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;

public class DataManager implements DataSource {

    private TasksDao tasksDao = DiaryApplication.getINSTANCE().getTasksDatabase().tasksDao();

    @Override
    public Flowable<List<Task>> getTasksBetweenDates(Date from, Date to) {
        return tasksDao.findTasksBetweenDates(from, to);
    }

    @Override
    public void insertTask(Task task) {
        tasksDao.insertTask(task);
    }
}
