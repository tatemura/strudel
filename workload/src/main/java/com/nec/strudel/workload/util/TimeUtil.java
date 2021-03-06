/*******************************************************************************
 * Copyright 2015, 2016 Junichi Tatemura
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.nec.strudel.workload.util;

public final class TimeUtil {
    private TimeUtil() {
        // not instantiated
    }

    public static final long MICS_PER_MS = 1000;
    public static final long NS_PER_MICS = 1000;
    public static final long NS_PER_MS = NS_PER_MICS * MICS_PER_MS;
    public static final long MS_PER_SECOND = 1000;
    public static final long MICS_PER_SECOND = MICS_PER_MS * MS_PER_SECOND;
    public static final long NS_PER_SECOND = NS_PER_MICS * MICS_PER_SECOND;
    public static final long SECONDS_PER_MIN = 60;
    public static final long MIN_PER_HOUR = 60;
    public static final long SECONDS_PER_HOUR = SECONDS_PER_MIN * MIN_PER_HOUR;
    public static final long HOURS_PER_DAY = 24;
    public static final long SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;
    public static final long MS_PER_HOUR = MS_PER_SECOND * SECONDS_PER_HOUR;
    public static final long MS_PER_DAY = MS_PER_SECOND * SECONDS_PER_DAY;

    public static String formatTime(long ms) {
        long val = ms / MS_PER_SECOND;
        final int seconds = (int) (val % SECONDS_PER_MIN);
        val /= SECONDS_PER_MIN;
        final int minutes = (int) (val % MIN_PER_HOUR);
        val /= MIN_PER_HOUR;
        final int hours = (int) (val % HOURS_PER_DAY);
        val /= HOURS_PER_DAY;
        final int days = (int) val;

        StringBuilder sb = new StringBuilder();
        if (days > 1) {
            sb.append(days).append(" days ");
        } else if (days == 1) {
            sb.append("1 day ");
        }
        if (hours > 1) {
            sb.append(hours).append(" hours ");
        } else if (hours == 1) {
            sb.append("1 hour ");
        }
        if (minutes > 1) {
            sb.append(minutes).append(" minutes ");
        } else if (minutes == 1) {
            sb.append("1 minute ");
        }
        if (seconds > 1) {
            sb.append(seconds).append(" seconds");
        } else if (seconds == 1) {
            sb.append("1 second");
        }
        return sb.toString();
    }

    public static String formatTimeMs(long ms) {
        String str = formatTime(ms);
        if (str.isEmpty()) {
            return ms + " msec";
        } else {
            return str;
        }
    }

    public static String nanoToMs(long nano) {
        return nanoToMs(nano, "%.2f");
    }

    public static String nanoToMs(long nano, String format) {
        double ms = ((double) nano) / TimeUtil.NS_PER_MS;
        return String.format(format, ms);
    }

}
