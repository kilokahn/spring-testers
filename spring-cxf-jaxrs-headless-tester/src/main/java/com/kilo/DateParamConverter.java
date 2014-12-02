
package com.kilo;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ext.ParamConverter;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateParamConverter implements ParamConverter<Date> {

    private static final Logger LOG = LoggerFactory
            .getLogger(DateParamConverter.class);

    private enum DatePattern {
        HYPHEN_DATE_PATTERN("yyyy-MM-dd"),
        HYPHEN_DATE_PATTERN_US("MM-dd-yyyy"),
        HYPHEN_DATE_TIME_PATTERN("yyyy-MM-dd HH:mm:ss.SSS"),
        HYPHEN_SHORT_DATE_TIME_PATTERN("yyyy-MM-dd HH:mm:ss"),
        SLASH_DATE_PATTERN("yyyy/MM/dd"),
        SLASH_DATE_PATTERN_US("MM/dd/yyyy"),
        SLASH_DATE_TIME_ZONE_PATTERN_US("MM/dd/yyyy HH:mm:ss z"),
        NODELIM_DATE_PATTERN("yyyyMMdd"),
        NODELIM_DATE_TIME_PATTERN("yyyyMMdd HH:mm:ss.SSS"),
        WEIRDASS_DATE_TIME_PATTERN("yyyyMMddHH:mm:ss.S");

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
    public Date fromString(String dateString) {
        try {
            return DateUtils.parseDateStrictly(dateString,
                    DatePattern.getPatterns());
        } catch (ParseException exception) {
            LOG.warn("Unable to handle date " + dateString);
        }
        return null;
    }

    @Override
    public String toString(Date date) throws IllegalArgumentException {
        return DateFormatUtils.format(date,
                DatePattern.NODELIM_DATE_TIME_PATTERN.pattern);
    }

}
