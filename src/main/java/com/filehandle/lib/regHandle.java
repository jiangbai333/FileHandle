package com.filehandle.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hsoft on 2017/8/29.
 */
public final class regHandle {
    
    /**
     * 使用正则替换字符串
     * @param rlcStr 将要被替换的字符串
     * @param regStr 将要被匹配的字符串
     * @param rpeStr 将要替换为的字符串
     * @return String 替换完成后的字符串
     */
	public static String replacec(String rlcStr, String regStr, String rpeStr) {
        
        Pattern pn
                = Pattern.compile(regStr);
        Matcher mc
                = pn.matcher(rlcStr);
        
        return mc.replaceAll(rpeStr);
	}
}
