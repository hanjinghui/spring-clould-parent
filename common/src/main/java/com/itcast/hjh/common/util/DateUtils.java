package com.itcast.hjh.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDataTimeForYYMMDD(){
		return formatDate(new Date(), "yyyy-MM-dd");
	}


	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}


	public static Date getDateStart(Date date) {
		if(date==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(formatDate(date, "yyyy-MM-dd")+" 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getDateEnd(Date date) {
		if(date==null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date= sdf.parse(formatDate(date, "yyyy-MM-dd") +" 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 判断字符串是否是日期
	 * @param timeString
	 * @return
	 */
	public static boolean isDate(String timeString){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try{
			format.parse(timeString);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	/**
	 * 格式化时间
	 * @param timestamp
	 * @return
	 */
	public static String dateFormat(Date timestamp){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(timestamp);
	}

	/**
	 * 获取系统时间Timestamp
	 * @return
	 */
	public static Timestamp getSysTimestamp(){
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 获取系统时间Date
	 * @return
	 */
	public static Date getSysDate(){
		return new Date();
	}

	/**
	 * 生成时间随机数
	 * @return
	 */
	public static String getDateRandom(){
		String s=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		return s;
	}

	/**
	 * 获取当前日期的下一天日期
	 * @return
	 */
	public static String getNextDate(){
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		return formatDate(date, "yyyy-MM-dd");
	}

	/**
	 * 获取传递日期的下一天日期
	 * @return
	 */
	public static String getNextDateByDate(String dateTime){
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(format.parse(dateTime));
			calendar.add(Calendar.DATE, 1);
			Date date = calendar.getTime();
			return formatDate(date, "yyyy-MM-dd");
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * 获取目标日期的前一天日期
	 * @return
	 */
	public static String getBeforeDateByDate(String dateTime){
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(format.parse(dateTime));
			calendar.add(Calendar.DATE, -1);
			Date date = calendar.getTime();
			return formatDate(date, "yyyy-MM-dd");
		}catch(Exception e){
			return null;
		}
	}
	/**
	 * 将字符串类型转换成日期类型
	 * @param time
	 * @return
	 */
	public static Date stringToDate(String time){
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
		Date date = null;
		try {
			date = df.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 将字符串类型转换成日期类型
	 * @param time
	 * @return
	 */
	public static Date stringToDate2(String time){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date date = null;
		try {
			date = df.parse(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 判断某个时间是否在两个时间之间
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
		//设置当前时间
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		//设置开始时间
		Calendar begin = Calendar.getInstance();
		begin.setTime(beginTime);
		//设置结束时间
		Calendar end = Calendar.getInstance();
		end.setTime(endTime);
		//处于开始时间之后，和结束时间之前的判断
		if (date.after(begin) && date.before(end)) {
			return true;
		} else {
			return false;
		}
	}

    /**
     * 获取当前日期的年月日时分秒（yyyyMMddHHmmss）字符串
     * @return
     */
    public static String getNowTime(){
        Calendar now = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(now.get(Calendar.YEAR));
        sb.append(now.get(Calendar.MONTH) + 1);
        sb.append(now.get(Calendar.DAY_OF_MONTH));
        sb.append(now.get(Calendar.HOUR_OF_DAY));
        sb.append(now.get(Calendar.MINUTE));
        sb.append(now.get(Calendar.SECOND));
        return sb.toString();
    }

	/**
	 * 获取目标时间后的24小时的具体时间
	 * @param date
	 * @param hours
	 * @return
	 * @throws ParseException
	 */
	public static String getAfterByHourTime(String date ,int hours) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date));
		cal.add(Calendar.HOUR_OF_DAY, hours);
		return formatDateTime(cal.getTime());
	}

	/**
	 * 判断某个时间是否在两个时间之间
	 * @param nowTime
	 * @param nowTime
	 * @param targetTime
	 * @return
	 */
	public static boolean afterTarget(Date nowTime, Date targetTime) {
		//设置当前时间
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		//设置开始时间
		Calendar time = Calendar.getInstance();
		time.setTime(targetTime);
		if (date.after(time)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断某个时间是否在两个时间之间
	 * @param nowTime
	 * @param nowTime
	 * @param targetTime
	 * @return
	 */
	public static boolean beforeTarget(Date nowTime, Date targetTime) {
		//设置当前时间
		Calendar date = Calendar.getInstance();
		date.setTime(nowTime);
		//设置开始时间
		Calendar time = Calendar.getInstance();
		time.setTime(targetTime);
		if (date.before(time)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断两个时间段是否跨天
	 * @param nowTime
	 * @param nowTime
	 * @param
	 * @return
	 */
	public static boolean getIsNextDay(String startTime, String endTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");//24小时制
		boolean flag = false;
		try{
			long time2 = simpleDateFormat.parse(startTime).getTime();
			long time3 = simpleDateFormat.parse(endTime).getTime();
			if(time2 < time3){
				flag = false;
			} else {
				flag = true;
			}
			return flag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static boolean getMoveNextDay(String tagTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
		boolean flag = false;
		try{

			long time2 = simpleDateFormat.parse(getDateTime()).getTime();
			long time3 = simpleDateFormat.parse(tagTime).getTime();
			if(time2 < time3){
				flag = true;
			} else {
				flag = false;
			}
			return flag;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 判断时间是否在某个时间段内
	 * @param s需要判断的时间,形如23:30:00
	 * @param s1 时间段开始时间,形如22:30:00
	 * @param s2时间段结束时间,形如06:00:00
	 * @return
	 */
	public static boolean isInTimeRange(String s, String s1,String s2){
		boolean flag = false;
		int set = Integer.valueOf(s.replaceAll(":",""));
		int begin = Integer.valueOf(s1.replaceAll(":",""));
		int end = Integer.valueOf(s2.replaceAll(":",""));
		if(end < begin){
			end = end + 240000;
		}
		if(set>=begin && set<end){
			flag = true;
		}
		return flag;
	}

	/**
   * 判断某一时间是否在一个区间内
   *
   * @param sourceTime  时间区间,半闭合,如[10:00:00-20:00:00)
   * @param curTime     需要判断的时间 如10:00:00
   * @return
   * @throws IllegalArgumentException
   */
	public static boolean isInTimeForS(String sourceTime, String curTime) {
		if (sourceTime == null || !sourceTime.contains("-") || !sourceTime.contains(":")) {
			throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
		}
		if (curTime == null || !curTime.contains(":")) {
			throw new IllegalArgumentException("Illegal Argument arg:" + curTime);
		}
		String[] args = sourceTime.split("-");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		try {
			if (args[1].equals("0:00:00")) {
				args[1] = "24:00:00";
			}
			long now = sdf.parse(curTime).getTime();
			long start = sdf.parse(args[0]).getTime();
			long end = sdf.parse(args[1]).getTime();

			if (end < start) {
				end = end+24*3600*1000;
			}
			long start0=start - 24*3600*1000;
			long end0=end - 24*3600*1000;

			long start1=start + 24*3600*1000;
			long end1=end + 24*3600*1000;

			if (now >= start && now < end) {
				return true;
			} else if(now >= start0 && now < end0){
				return true;
			}else if(now >= start1 && now < end1){
				return true;
			}else{
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Illegal Argument arg:" + sourceTime);
		}
	}
}
