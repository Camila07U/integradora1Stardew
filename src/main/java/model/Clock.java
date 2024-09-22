package model;

public class Clock {

    private int days =0;
    private Season season= Season.SPRING;

    public boolean advanceDays(int days) {
        for (int i = 0; i < days; i++) {
            days++;
            if (days % 28 == 0) {
                changeSeason();
                return true;
            }
        }
        return false;
    }

    public void changeSeason() {

        switch (season) {
            case SPRING:
                season = Season.SUMMER;
                break;
            case SUMMER:
                season = Season.AUTUMN;
                break;
            case AUTUMN:
                season = Season.WINTER;
                break;
            case WINTER:
                season = Season.SPRING;
                break;
        }

    }

    public int getDays() {
        return days;
    }

    public Season getSeason() {
        return season;
    }
}
