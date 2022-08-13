package com.bridgelap.hotalmanagement;

public class Hotel {
    String hotelName;
    int rating;
    int regularCustomerRate;
    int rewardCustomerRate;
    int regularCustomerWeekendRate;
    int rewardCustomerWeekendRate;

    long totalCost;

    public Hotel(String hotelName, int rating, int regularCustomerRate, int rewardCustomerRate, int regularCustomerWeekendRate, int rewardCustomerWeekendRate) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.regularCustomerRate = regularCustomerRate;
        this.rewardCustomerRate = rewardCustomerRate;
        this.regularCustomerWeekendRate = regularCustomerWeekendRate;
        this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;
    }

    public Hotel() {
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRegularCustomerRate() {
        return regularCustomerRate;
    }

    public void setRegularCustomerRate(int regularCustomerRate) {
        this.regularCustomerRate = regularCustomerRate;
    }

    public int getRewardCustomerRate() {
        return rewardCustomerRate;
    }

    public void setRewardCustomerRate(int rewardCustomerRate) {
        this.rewardCustomerRate = rewardCustomerRate;
    }

    public int getRegularCustomerWeekendRate() {
        return regularCustomerWeekendRate;
    }

    public void setRegularCustomerWeekendRate(int regularCustomerWeekendRate) {
        this.regularCustomerWeekendRate = regularCustomerWeekendRate;
    }

    public int getRewardCustomerWeekendRate() {
        return rewardCustomerWeekendRate;
    }

    public void setRewardCustomerWeekendRate(int rewardCustomerWeekendRate) {
        this.rewardCustomerWeekendRate = rewardCustomerWeekendRate;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", rating=" + rating +
                ", totalCost=" + totalCost +
                '}';
    }
}
