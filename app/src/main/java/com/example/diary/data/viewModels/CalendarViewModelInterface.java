package com.example.diary.data.viewModels;

import com.example.diary.entities.Day;

import java.util.List;

import io.reactivex.Flowable;

public interface CalendarViewModelInterface {

    Flowable<List<Day>> getDays();
}
