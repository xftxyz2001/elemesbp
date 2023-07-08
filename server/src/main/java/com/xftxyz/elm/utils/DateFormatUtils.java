package com.xftxyz.elm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xftxyz.elm.config.ElmProperties;

public class DateFormatUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat(ElmProperties.datePattern);

    public static String format(Date date) {
        return sdf.format(date);
    }

    // 获取当前时间
    public static String currentTime() {
        return sdf.format(new Date());
    }

    public static Date parse(String dateString) {
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}