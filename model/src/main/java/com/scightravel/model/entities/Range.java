package com.scightravel.model.entities;

/**
 * Created by abhay on 3/23/2015.
 */
public class Range {
    String startRange;
    String endRange;

    public Range(String startRange, String endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }


    public String getStartRange() {
        return startRange;
    }

    public void setStartRange(String startRange) {
        this.startRange = startRange;
    }

    public String getEndRange() {
        return endRange;
    }

    public void setEndRange(String endRange) {
        this.endRange = endRange;
    }
}
