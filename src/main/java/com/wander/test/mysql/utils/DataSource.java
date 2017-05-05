package com.wander.test.mysql.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wander.test.mysql.Main;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DataSource
 * Created by root on 05th.May.2017
 */
public class DataSource {

    private static DataSource dataSource;
    private Properties config;


    private ComboPooledDataSource readDataSource;
    private ComboPooledDataSource writeDataSource;

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }


    public DataSource() {

//        Properties config = new Properties();
        config = new Properties();
        try {
            config.load(Main.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        readDataSource = new ComboPooledDataSource();
        writeDataSource = new ComboPooledDataSource();

        try {
            System.out.println(config.getProperty(Configurer.MYSQL_DRIVER));
            readDataSource.setDriverClass(config.getProperty(Configurer.MYSQL_DRIVER));
            readDataSource.setJdbcUrl(config.getProperty(Configurer.MYSQL_READ_URL));
            readDataSource.setUser(config.getProperty(Configurer.MYSQL_READ_USER));
            readDataSource.setPassword(config.getProperty(Configurer.MYSQL_READ_PASSWD));

            readDataSource.setMinPoolSize(Integer.parseInt(config.getProperty(Configurer.MYSQL_READ_MINPOOLSIZE)));
            readDataSource.setMaxPoolSize(Integer.parseInt(config.getProperty(Configurer.MYSQL_READ_MAXPOOLSIZE)));
            readDataSource.setMaxIdleTime(Integer.parseInt(config.getProperty(Configurer.MYSQL_READ_MAXIDLETIME)));
            readDataSource.setAcquireIncrement(Integer.parseInt(config.getProperty(Configurer.MYSQL_READ_ACQUIREINCREMENT)));


            writeDataSource.setDriverClass(config.getProperty(Configurer.MYSQL_DRIVER));
            writeDataSource.setJdbcUrl(config.getProperty(Configurer.MYSQL_WRITE_URL));
            writeDataSource.setUser(config.getProperty(Configurer.MYSQL_WRITE_USER));
            writeDataSource.setPassword(config.getProperty(Configurer.MYSQL_WRITE_PASSWD));

            writeDataSource.setMinPoolSize(Integer.parseInt(config.getProperty(Configurer.MYSQL_WRITE_MINPOOLSIZE)));
            writeDataSource.setMaxPoolSize(Integer.parseInt(config.getProperty(Configurer.MYSQL_WRITE_MAXPOOLSIZE)));
            writeDataSource.setMaxIdleTime(Integer.parseInt(config.getProperty(Configurer.MYSQL_WRITE_MAXIDLETIME)));
            writeDataSource.setAcquireIncrement(Integer.parseInt(config.getProperty(Configurer.MYSQL_WRITE_ACQUIREINCREMENT)));

        } catch (PropertyVetoException e) {
            e.printStackTrace();
            System.err.println("DataSource: " + e.getMessage());
        }

    }

    public Connection getConnection() throws SQLException {
        return readDataSource.getConnection();
    }


}
