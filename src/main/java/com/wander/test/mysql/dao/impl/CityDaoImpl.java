package com.wander.test.mysql.dao.impl;

import com.wander.test.mysql.bean.City;
import com.wander.test.mysql.common.str.StrUtils;
import com.wander.test.mysql.dao.CityDao;
import com.wander.test.mysql.utils.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CityDaoImpl
 * Created by root on 05th.May.2017
 */
public class CityDaoImpl implements CityDao {

    public City getPosition(String ip) {

        City city = new City();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        long numIp = StrUtils.IpToLong(ip);


        String sql = "SELECT   GeoCity.country_name, GeoCity.country_iso_code, GeoCity.subdivision_1_name, "
                + " GeoCity.city_name,GeoIp.longitude, GeoIp.latitude"
                + " FROM GeoIp,GeoCity WHERE GeoIp.startIp < ? AND GeoIp.endIp > ? "
                + "AND GeoCity.geoname_id = GeoIp.geoname_id ";

//        System.out.println(sql);
//        System.out.println(numIp);
        try {
            conn = DataSource.getInstance().getConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, numIp);
            preparedStatement.setLong(2, numIp);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                city.setCountry(resultSet.getString(1));
                city.setCode(resultSet.getString(2));
                city.setSubdivisionName(resultSet.getString(3));
                city.setCity(resultSet.getString(4));
                city.setLongitude(resultSet.getDouble(5));
                city.setLatitude(resultSet.getDouble(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    System.err.println("resultSet Exception : " + e.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    System.err.println("preparedStatement Exception : " + e.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    System.err.println("conn Exception : " + e.getMessage());
                }
            }
        }
        return city;
    }
}
