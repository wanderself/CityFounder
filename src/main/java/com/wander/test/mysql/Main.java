package com.wander.test.mysql;

import com.wander.test.mysql.dao.impl.CityDaoImpl;

/**
 * Main
 * Created by root on 05th.May.2017
 */
public class Main {

    private static String tw = "211.23.164.87";
    private static String hk = "103.250.13.140";
    private static String kr = "182.163.234.137";
    private static String tk = "106.185.48.232";
    private static String us = "46.21.157.23";

    public static void main(String[] args) {


        new Main().res(tw);
        new Main().res(hk);
        new Main().res(kr);
        new Main().res(tk);
        new Main().res(us);
    }

    public void res(String ip) {
        CityDaoImpl cityDao = new CityDaoImpl();
        System.out.printf("國家：%s,  城市：%s,  省：%s,  經緯度：%s,%s\n", cityDao.getPosition(ip).getCountry(), cityDao.getPosition(ip).getCity(), cityDao.getPosition(ip).getSubdivisionName(), cityDao.getPosition(ip).getLongitude(), cityDao.getPosition(ip).getLatitude());
    }
}
