package com.yds.educationaladministrationsystem.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/4/25.
 */
public class ValidateUtils {
    private ValidateUtils(){
		/* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isEmptyString(String str){
        return str.trim().length() == 0 || "".equals(str) || null == str || "null".equals(str);
    }

    public static boolean isNotEmptyString(String str){
        return !isEmptyString(str);
    }

    public static boolean isNullObj(Object obj){
        return obj == null;
    }

    public static boolean isNotNullObj(Object obj){
        return !(obj == null);
    }

    /**
     * verify phone
     * @param phoneNumber
     * @return
     */
    public static boolean isMobilePhone(String phoneNumber){

        Pattern mPattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher mMatcher = mPattern.matcher(phoneNumber);
        return mMatcher.matches();
    }

    /**
     * verify email
     * @param email
     * @return
     */
    public static boolean isEmail(String email){

        Pattern mPattern = Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
        Matcher mMatcher = mPattern.matcher(email);
        return mMatcher.matches();
    }
}
