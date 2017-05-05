package com.wander.test.mysql.dao;

import com.wander.test.mysql.bean.City;

/**
 * CityDao
 * Created by root on 05th.May.2017
 */
public interface CityDao {
    City getPosition(String ip);
}
