package com.thuni.his.demo.tools;

import lombok.extern.slf4j.Slf4j;
import org.jfantasy.framework.util.common.ClassUtil;
import org.jfantasy.framework.util.ognl.OgnlUtil;

import java.text.ParseException;
import java.util.*;

@Slf4j
public final class Z7Utils {

    /**
     * 集合框架
     */
    public static class Gather{
        /**
         * 转化ListList<Map<String, Object>>类型数据转为List<T>数据格式
         *
         * @param list
         * @param clazz
         * @param <T>
         * @return
         */
        public static  <T> List<T> getListByMap(List<Map<String, Object>> list, Class<T> clazz) {
            List<T> returnList = new ArrayList<T>();
            OgnlUtil ognlUtil = OgnlUtil.getInstance();
            for (Map<String, Object> map : list) {
                T object = ClassUtil.newInstance(clazz);
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    ognlUtil.setValue(entry.getKey(), object, entry.getValue());
                }
                returnList.add(object);
            }
            return returnList;
        }
    }

    /**
     *  日期
     */
    public static class Dates {
        /**
         * 计算年龄
         *
         * @param birthDay 出生日期
         * @return
         * @throws ParseException
         */
        public static int getAgeByBirth(Date birthDay) throws ParseException {
            int age = 0;
            Calendar cal = Calendar.getInstance();
            if (cal.before(birthDay)) {
                //出生日期晚于当前时间，无法计算
                throw new IllegalArgumentException(
                        "The birthDay is before Now.It's unbelievable!");
            }
            int yearNow = cal.get(Calendar.YEAR);  //当前年份
            int monthNow = cal.get(Calendar.MONTH);  //当前月份
            int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
            cal.setTime(birthDay);
            int yearBirth = cal.get(Calendar.YEAR);
            int monthBirth = cal.get(Calendar.MONTH);
            int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
            age = yearNow - yearBirth;   //计算整岁数
            if (monthNow <= monthBirth) {
                if (monthNow == monthBirth) {
                    if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
                } else {
                    age--;//当前月份在生日之前，年龄减一
                }
            }
            return age;
        }
    }
}
