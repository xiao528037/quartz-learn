package com.xiao.quartzlearn.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包名:com.xiao.quartzlearn.tools
 * 作者: lucky
 * 创建时间: 2022年06月15日 11:13:32
 * 注释：
 */
public class DFUtil {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date) {
        return sdf.format(date);
    }
}
