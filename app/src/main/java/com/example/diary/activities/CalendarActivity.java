package com.example.diary.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.diary.R;
import com.example.diary.data.viewModels.CalendarViewModel;
import com.example.diary.data.viewModels.CalendarViewModelInterface;
import com.example.diary.entities.Day;

import org.reactivestreams.Subscription;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class CalendarActivity extends AppCompatActivity {

    @BindView(R.id.calendar_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.calendar_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private boolean isAbleToLoadTasks = true;
    private CalendarViewModelInterface calendarViewModelInterface;
    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        ButterKnife.bind(this);
        calendarViewModelInterface = new CalendarViewModel();
        compositeDisposable = new CompositeDisposable();
        initRecyclerView();
        initSwipeRefreshLayout();
        getTasks();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }

    private void initRecyclerView() {
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (isAbleToLoadTasks) {
                getTasks();
            }
        });
    }

    private void getTasks() {
        compositeDisposable.add(calendarViewModelInterface.getDays()
                .doOnSubscribe(this::showLoading)
                .doAfterTerminate(this::hideLoading)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setTasksToCalendar));
    }

    private void setTasksToCalendar(List<Day> days) {

    }

    private void showLoading(Subscription subscription) {
        swipeRefreshLayout.setRefreshing(true);
    }

    private void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
