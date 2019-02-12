package com.example.diary.entities;

public class Day {

    private int dayOfTheWeek;
    private int day;
    private boolean isAnyTasks;
    private boolean isAnyBells;

    public Day() {

    }

    public Day(int dayOfTheWeek, int day) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.day = day;
    }

    public Day(int dayOfTheWeek, int day, boolean isAnyTasks, boolean isAnyBells) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.day = day;
        this.isAnyTasks = isAnyTasks;
        this.isAnyBells = isAnyBells;
    }

    public int getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(int dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isAnyTasks() {
        return isAnyTasks;
    }

    public void setAnyTasks(boolean anyTasks) {
        isAnyTasks = anyTasks;
    }

    public boolean isAnyBells() {
        return isAnyBells;
    }

    public void setAnyBells(boolean anyBells) {
        isAnyBells = anyBells;
    }
}
