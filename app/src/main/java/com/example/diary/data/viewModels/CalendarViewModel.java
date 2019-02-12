package com.example.diary.data.viewModels;

import com.example.diary.data.DataManager;
import com.example.diary.data.DataSource;
import com.example.diary.entities.Day;
import com.example.diary.entities.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public class CalendarViewModel implements CalendarViewModelInterface {

    private DataSource dataSource = new DataManager();
    private Date firstDayOfPeriod;
    private Date lastDayOfPeriod;


    private void getDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        firstDayOfPeriod = cal.getTime();
        cal.add(Calendar.MONTH, 1);
        lastDayOfPeriod = cal.getTime();
    }

    @Override
    public Flowable<List<Day>> getDays() {
        return dataSource.getTasksBetweenDates(firstDayOfPeriod, lastDayOfPeriod)
                .flatMap(this::manageDays);
    }

    private Flowable<List<Day>> manageDays(List<Task> tasks) {
        Calendar calendar = Calendar.getInstance();
        List<Day> days = new ArrayList<>();
        for (int i = 0; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            days.add(new Day(calendar.get(Calendar.DAY_OF_WEEK), i + 1));
        }
        for (Task task : tasks) {
            calendar.setTimeInMillis(task.getTimeStamp());
            for (Day day : days) {
                if (day.getDay() == calendar.get(Calendar.DAY_OF_MONTH)) {
                    day.setAnyTasks(true);
                    if (task.isBell()) {
                        day.setAnyBells(true);
                    }
                }
            }
        }
        return Flowable.just(days);
    }
}
