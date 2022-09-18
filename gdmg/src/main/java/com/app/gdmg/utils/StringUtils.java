package com.app.gdmg.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static Boolean validateEmail(String email){
        Pattern emailPattern = Pattern.compile(ConstantesUtils.MAIL_REGEX);
        Matcher result =  emailPattern.matcher(email);
        return  result.matches();
    }
    public static Boolean validatePassword(String password){
        Pattern passwordPattern = Pattern.compile(ConstantesUtils.PASSWORD_REGEX);
        Matcher result = passwordPattern.matcher(password);
        return result.matches();
    }
}
