/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.company.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Contains time related utility methods.
 */
public class TimeUtil {

    private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static SimpleDateFormat TIME_FORMAT_MSEC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
    private final static SimpleDateFormat FILE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    
    // only static methods, don't allow construction
    private TimeUtil() {
    }

    /**
     * Return a prettified version of the given elapsed time in milliseconds.
     */
    public static synchronized String formatElapsedTime(long elapsedTimeMs) {
        if (elapsedTimeMs < 1000) {
            return String.format("%d ms", elapsedTimeMs);
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTimeMs) % 60;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTimeMs) % 60;
        long hours = TimeUnit.MILLISECONDS.toHours(elapsedTimeMs);
        StringBuilder time = new StringBuilder();
        if (hours > 0) {
            time.append(hours);
            time.append("h ");
        }
        if (minutes > 0) {
            time.append(minutes);
            time.append("m ");
        }
        time.append(seconds);
        time.append("s");

        return time.toString();
    }

    /**
     * Return a readable formatted version of the given epoch time.
     *
     * @param epochTime the epoch time in milliseconds
     * @return a user readable string
     */
    public static synchronized String formatTimeStamp(long epochTime) {
        return TIME_FORMAT.format(new Date(epochTime));
    }
    
    public static String getTimestamp() {
        return formatTimeStamp(System.currentTimeMillis());
    }
    
    public static synchronized String formatTimeStampMsec(long epochTime) {
        return TIME_FORMAT_MSEC.format(new Date(epochTime));
    }
    
    public static String getTimestampMsec() {
        return formatTimeStampMsec(System.currentTimeMillis());
    }
    
    public static synchronized String formatTimeForFile(long epochTime) {
        return FILE_TIME_FORMAT.format(new Date(epochTime));
    }
    
    public static String getTimestampForFile() {
        return formatTimeForFile(System.currentTimeMillis());
    }
    
}
