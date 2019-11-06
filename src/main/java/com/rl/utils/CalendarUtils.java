package com.rl.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName
 * @Description 日期工具类
 * @Author
 * @Date 2019/9/2 10:50
 * @Version 1.0
 **/
public class CalendarUtils {
    public String getSimpleDateFormat(Integer v){//v：需要计算的数值，例：+5表示后五天，-4表示前四天
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long longTime = new Date().getTime();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date(longTime));
        calendar.add(Calendar.DAY_OF_MONTH,v);
        String timestr=sdf.format(calendar.getTime().getTime());
      return timestr;
    }
}
