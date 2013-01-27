
package com.kilo;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.cxf.jaxrs.ext.ParameterHandler;

public class ProgressiveDateHandler implements ParameterHandler<Date> {

    private enum DatePattern {
        HYPHEN_DATE_PATTERN("yyyy-MM-dd"),
        HYPHEN_DATE_PATTERN_US("MM-dd-yyyy"),
        HYPHEN_DATE_TIME_PATTERN("yyyy-MM-dd HH:mm:ss.SSS"),
        HYPHEN_SHORT_DATE_TIME_PATTERN("yyyy-MM-dd HH:mm:ss"),
        SLASH_DATE_PATTERN("yyyy/MM/dd"),
        SLASH_DATE_PATTERN_US("MM/dd/yyyy"),
        SLASH_DATE_TIME_ZONE_PATTERN_US("MM/dd/yyyy HH:mm:ss z"),
        NODELIM_DATE_PATTERN("yyyyMMdd"),
        NODELIM_DATE_TIME_PATTERN("yyyyMMdd HH:mm:ss.SSS");
        /**
         * String representation of the pattern
         */
        private String pattern;

        private DatePattern(String pattern) {
            this.pattern = pattern;
        }

        private static final Map<String, DatePattern> stringToDatePattern = new HashMap<String, DatePattern>();

        static {
            for (DatePattern datePattern : values()) {
                stringToDatePattern.put(datePattern.pattern, datePattern);
            }
        }

        public static String[] getPatterns() {
            String[] patterns = new String[stringToDatePattern.size()];
            return stringToDatePattern.keySet().toArray(patterns);
        }
    }

    @Override
    public Date fromString(String dateStr) {

        Date date = null;

        if (StringUtils.isNotBlank(dateStr)) {
            try {
                date = DateUtils.parseDateStrictly(dateStr,
                        DatePattern.getPatterns());
            } catch (ParseException exception) {
                throw new IllegalArgumentException("Unable to handle date "
                        + dateStr, exception);
            }
        }
        return date;
    }

}
