package com.rl.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class GlobleService {
    private static DateFormat sid = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getID() {
        return format.format(new Date());
    }

    public static Date getDate(String dateValue) throws ParseException {
        Date tmpDate = null;
        if (StringUtils.isNotBlank(dateValue)) {
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            tmpDate = format.parse(dateValue);
        }
        return tmpDate;
    }
    public static Date getDateByDateValue(String dateValue) throws ParseException {
        Date tmpDate = null;
        if (StringUtils.isNotBlank(dateValue)) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            tmpDate = df.parse(dateValue);
        }
        return tmpDate;
    }

    /**
     * 日期相加
     *
     * @param initTime 初始值
     * @param v        差量
     * @return
     */
    public static Date getSumDate(Date initTime, int v) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initTime);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + v);
        return calendar.getTime();
    }


    public static String getDateString(Date date) {
        String str = "";
        try {
            str = format.format(date);
        } catch (Exception e) {
        }
        return str;
    }
    public static String getDateString2(Date date) {
        String str = "";
        try {
            str = sid.format(date);
        } catch (Exception e) {
        }
        return str;
    }

}
