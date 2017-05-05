package com.wander.test.mysql.common.str;

import java.util.Hashtable;

public class StrUtils {

    private static Hashtable countryMap = new Hashtable();

    static {
        countryMap.put("United States", "United States of America");
        countryMap.put("Republic of Korea", "South Korea");
    }

    /**
     * 映射geoCity的国家到echarts的国家
     */
    public static String MapCountryName(String geoCountry) {
        if (countryMap.containsKey(geoCountry))
            return (String) countryMap.get(geoCountry);
        else
            return geoCountry;
    }


    /*
     * 传入ip地址,返回对应的数字. 如果不是ip地址,返回 -1
     */
    public static long IpToLong(String ip) {
        long result = 0;

        String[] ipAddressInArray = ip.split("\\.");
        if (ipAddressInArray.length != 4)
            return -1;

        try {

            for (int i = 3; i >= 0; i--) {

                long ipNum = Long.parseLong(ipAddressInArray[3 - i]);

                // left shifting 24,16,8,0 and bitwise OR

                // 1. 192 << 24
                // 1. 168 << 16
                // 1. 1 << 8
                // 1. 2 << 0
                result |= ipNum << (i * 8);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
        return result;
    }

    /*
     * LongToIp
     */
    public static String LongToIp(long ip) {
        StringBuilder result = new StringBuilder(15);

        for (int i = 0; i < 4; i++) {

            result.insert(0, Long.toString(ip & 0xff));

            if (i < 3) {
                result.insert(0, '.');
            }

            ip = ip >> 8;
        }
        return result.toString();
    }


}
