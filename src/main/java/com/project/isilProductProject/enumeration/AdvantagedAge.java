package com.project.isilProductProject.enumeration;

public enum AdvantagedAge {

    YOUNG(15, 25), OLD(65, 100);


    AdvantagedAge(int value) {
        this.low = value;
        this.high = value;
    }

    public boolean isAdvantaged(int value) {
        if (low < value && high > value) {
            return true;
        }
        return false;
    }

    private AdvantagedAge(int low, int high) {
        this.low = low;
        this.high = high;
    }

    private final int low;
    private final int high;
}
