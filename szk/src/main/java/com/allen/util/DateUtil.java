package com.allen.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Allen on 2015/4/27.
 */
public class DateUtil {

    public static String longDatePattern = "yyyy-MM-dd HH:mm:ss";
    public static String shortDatePattern = "yyyy-MM-dd";

    /**
     * 将指定字符串转换成日期
     *
     * @param date
     *            String 日期字符串
     * @param datePattern
     *            String 日期格式
     * @return Date
     */
    public static Date getFormatDate(String date, String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);
        return sd.parse(date, new java.text.ParsePosition(0));
    }

    /**
     * 将指定日期对象转换成格式化字符串
     *
     * @param date
     *            Date XML日期对象
     * @param datePattern
     *            String 日期格式
     * @return String
     */
    public static String getFormattedString(Date date, String datePattern) {
        SimpleDateFormat sd = new SimpleDateFormat(datePattern);

        return sd.format(date);
    }

    public static String getThisYear() {
        // 获得当前日期
        Calendar cldCurrent = Calendar.getInstance();
        // 获得年月日
        String strYear = String.valueOf(cldCurrent.get(Calendar.YEAR));
        return strYear;
    }
    public static String getThisMonth() {
        // 获得当前日期
        Calendar cldCurrent = Calendar.getInstance();
        // 获得年月日
        String strMonth = String.valueOf((cldCurrent.get(Calendar.MONTH)+1));
        return strMonth;
    }
    public static String getThisDay() {
        // 获得当前日期
        Calendar cldCurrent = Calendar.getInstance();
        // 获得年月日
        String strDay = String.valueOf(cldCurrent.get(Calendar.DATE));
        return strDay;
    }
    public static String getThisWeek() {
        // 获得当前日期
        Calendar cldCurrent = Calendar.getInstance();
        // 获得年月日
        String strWeek = "";
        switch (cldCurrent.get(Calendar.DAY_OF_WEEK)){
            case 1:
                strWeek = "星期天";
                break;
            case 2:
                strWeek = "星期一";
                break;
            case 3:
                strWeek = "星期二";
                break;
            case 4:
                strWeek = "星期三";
                break;
            case 5:
                strWeek = "星期四";
                break;
            case 6:
                strWeek = "星期五";
                break;
            case 7:
                strWeek = "星期六";
                break;
            default:
                strWeek = "未知";
                break;
        }
        return strWeek;
    }

    // 获取当天时间,长时间格式
    public static Timestamp getLongNowTime() {
        return getNowTime(longDatePattern);
    }

    // 获取当天时间，短时间格式
    public static Timestamp getShortNowTime() {
        return getNowTime(shortDatePattern);
    }

    // 获取当天时间
    public static Timestamp getNowTime(String dateformat) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
        String dateString = dateFormat.format(now);
        SimpleDateFormat sd = new SimpleDateFormat(dateformat);
        Date dateFormt = sd.parse(dateString, new java.text.ParsePosition(0));
        Timestamp dateTime = new Timestamp(
                dateFormt.getTime());

        return dateTime;
    }

    public static String getDateTime(String dateformat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateformat);
        return formatter.format(new Date());
    }

    // 获取指定时间
    public static Timestamp getNowNewTime(String date, String dateformat) {
        // Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(dateformat);// 可以方便地修改日期格式
        dateFormat.parse(date, new java.text.ParsePosition(0));

        // String dateString= dateFormat.format(date);
        Date dateFormt = dateFormat.parse(date, new java.text.ParsePosition(0));
        Timestamp dateTime = new Timestamp(
                dateFormt.getTime());

        return dateTime;
        // return hehe;
    }

    /**
     * 有yyyy-MM-dd'T'hh:mm:ss.SSS格式的时间转换.
     * @return
     */
    public static String getTFormatString(String tdate) {
        SimpleDateFormat format1 = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss.SSS");
        String str = "";
        try {
            Date date = format1.parse(tdate);
            SimpleDateFormat format2 = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            str = format2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    // 获取当前时间前2个小时的时间。
    public static String getBefore2HourDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, -2); // 目前時間加3小時
        return df.format(c.getTime());

    }

    public static void main(String[] args) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");

        String date = "20110202";
        // System.out.println(sd.parse(date, new java.text.ParsePosition(0)));
        // System.out.println(getBefore2HourDate());
        System.out.println(beforeDay("2017-03-01"));
    }
    /**
     * 将long转换成日期格式
     * @param dateFormat
     * @param millSec
     * @return
     */
    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = new Date(millSec);
        return sdf.format(date);
    }
    /**
     * 将字符串转换成long
     * @param tdate
     * @return
     */
    public static long transferStringToLong(String tdate){
        SimpleDateFormat format1 = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        try {
            date = format1.parse(tdate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
    /**
     * 当前日期转换long
     * @return
     */
    public static long transferTimeLong(){
        return new Date().getTime();
    }

    /**
     *
     * @param time1
     *            当前时间
     * @param time2
     *            比较时间
     * @return 如果time1比time2大gap分钟，则返回true;
     */
    public static boolean compareDateTime(Date time1, Date time2, int gap) {
        return time1.getTime() - time2.getTime() > gap * 60 * 1000;
    }

    public static String subtractDateTime(Date time1, Date time2, String flag){
        String str = "";
        long temp = time1.getTime() - time2.getTime();
        if("hour".equals(flag)){
            long hour = temp / (1000 * 60 * 60);
            long minute = (temp % (1000 * 60 * 60)) / (1000 * 60);
            str += hour+"小时";
            str += 0 == minute ? "" : minute+"分钟";
        }
        return str;
    }

    /**
     * 功能计算前一天
     * @param specifiedDay
     * @return
     */
    public static String beforeDay(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date = null;
        try{
            date = new SimpleDateFormat(shortDatePattern).parse(specifiedDay);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);
        String dayBefore = new SimpleDateFormat(shortDatePattern).format(c.getTime());
        return dayBefore;
    }
    /**
     * 功能计算前一天
     * @param specifiedDay
     * @return
     */
    public static String afterDay(String specifiedDay){
        Calendar c = Calendar.getInstance();
        Date date = null;
        try{
            date = new SimpleDateFormat(shortDatePattern).parse(specifiedDay);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        String dayBefore = new SimpleDateFormat(shortDatePattern).format(c.getTime());
        return dayBefore;
    }
    /**
     * 功能：比较时间大小
     * @param source
     * @param target
     * @return
     * @throws Exception
     */
    public static int compareDate(String source,String target) throws Exception {
        Date sourceDate = new SimpleDateFormat(shortDatePattern).parse(source);
        Date targetDate = new SimpleDateFormat(shortDatePattern).parse(target);
        return sourceDate.compareTo(targetDate);
    }


}
