package com.victoria.app.core.utils;

import com.victoria.app.core.model.DurationInMonths;

public class DateTimeUtils {

    public static int getMonths(DurationInMonths durationInMonths) {
        if (durationInMonths == DurationInMonths.THREE) {
            return 3;
        }
        if (durationInMonths == DurationInMonths.SIX) {
            return 6;
        }
        if (durationInMonths == DurationInMonths.TWELVE) {
            return 12;
        }
        if (durationInMonths == DurationInMonths.TWENTY_FOUR) {
            return 24;
        }
        return 0;

    }
}
