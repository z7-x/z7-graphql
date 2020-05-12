package com.thuni.his.demo.tools;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public final class z7Utils {

   private static class handleFormat{
        /**
         * String 转换 Date
         * @param birthday 传入参数
         * @return 返回Date数据格式
         */
        private  Date getDate(String birthday) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try{
                date = format.parse(birthday);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            return date;
        }

    }

    public static void ss(){

    }
}
