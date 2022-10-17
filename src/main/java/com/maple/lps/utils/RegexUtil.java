//package com.maple.lps.utils;
//
//import com.maple.lps.constant.RegexType;
//
//import java.util.regex.Pattern;
//
//public class RegexUtil {
//    private final String regex_nopol = "^[A-Z]{1,2}\\s{1}\\d{0,4}\\s{0,1}[A-Z]{0,3}$";
//    //private final String regex_nik = "^\\d{6}([04][1-9]|[1256][0-9]|[37][01])(0[1-9]|1[0-2])\\d{2}\\d{4}$";
//    private final String regex_sandi = "\\d{6}$";
////    private final String regex_phone = "^(\\+62|62|0)8[1-9][0-9]{6,10}$";
////    //private final String regex_npwp = "/^([\\d]{2})[.]?([\\d]{3})[.]?([\\d]{3})[.]?[\\d][-]?([\\d]{3})[.]?([\\d]{3})$/g";
////    private final String regex_npwp = "^\\d{15}$";
//    private final String regex_name = "^[\\p{L} \\.'\\-]+$";
//
//    public RegexType checkPattern(String string) {
//        if (Pattern.matches(regex_name, string)) return RegexType.name;
//        if (Pattern.matches(regex_provinsi, string)) return RegexType.provinsi;
//        if (Pattern.matches(regex_city, string)) return RegexType.city;
//        if (Pattern.matches(regex_sandi, string)) return RegexType.sandi;
//        return RegexType.unknown;
//    }
//
//    public boolean isRegexNik(String string) {
//        return Pattern.matches(regex_nik, string);
//    }
//
//    public boolean isRegexPhone(String string) {
//        return Pattern.matches(regex_phone, string);
//    }
//
//    public boolean comparePhoneNumber(String phone1, String phone2) {
//        String dissectedPhone1 = null;
//        String dissectedPhone2 = null;
//        if (phone1.startsWith("62")) {
//            dissectedPhone1 = "0" + phone1.substring(2);
//        } else if (phone2.startsWith("62")) {
//            dissectedPhone2 = "0" + phone2.substring(2);
//        } else {
//            dissectedPhone1 = phone1;
//            dissectedPhone2 = phone2;
//        }
//
//        return dissectedPhone1.equalsIgnoreCase(dissectedPhone2);
//    }
//}
