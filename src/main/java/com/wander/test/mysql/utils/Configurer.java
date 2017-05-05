package com.wander.test.mysql.utils;

/**
 * Configurer: configuration definition
 * Created by root on 04th.May.2017
 */
public class Configurer {
    //topology name
    public static final String TOPOLOGY_NAME = "topology.name";

    //kafka spout
    public static final String KAFKA_SPOUT_ID = "spout.kafka.id";
    public static final String KAFKA_ZKHOST = "spout.kafka.zkHost";
    public static final String KAFKA_ZKROOT = "spout.kafka.zkRoot";
    public static final String KAFKA_TOPIC = "spout.kafa.topic";
    public static final String KAFKA_CLIENT_ID = "spout.kafka.clientId";
    public static final String KAFKA_SPOUT_COUNT = "spout.kafka.count";

    //zookeeper servers
    public static final String ZK_SERVER1 = "zookeeper.server.1";
    public static final String ZK_SERVER2 = "zookeeper.server.2";
    public static final String ZK_SERVER3 = "zookeeper.server.3";
    public static final String ZK_PORT = "zookeeper.port";


    //hbase bolt
    public static final String HBASE_BOLT_ID = "bolt.hbase.id";
    public static final String HBASE_BOLT_COUNT = "bolt.hbase.count";

    //mysql
    public static final String MYSQL_DRIVER = "mysql.driver";

    public static final String MYSQL_WRITE_URL = "mysql.write.url";
    public static final String MYSQL_WRITE_USER = "mysql.write.user";
    public static final String MYSQL_WRITE_PASSWD = "mysql.write.password";
    public static final String MYSQL_WRITE_MINPOOLSIZE = "mysql.write.MinPoolSize";
    public static final String MYSQL_WRITE_ACQUIREINCREMENT = "mysql.write.AcquireIncrement";
    public static final String MYSQL_WRITE_MAXPOOLSIZE = "mysql.write.MaxPoolSize";
    public static final String MYSQL_WRITE_MAXIDLETIME = "mysql.write.MaxIdleTime";

    public static final String MYSQL_READ_URL = "mysql.read.url";
    public static final String MYSQL_READ_USER = "mysql.read.user";
    public static final String MYSQL_READ_PASSWD = "mysql.read.password";
    public static final String MYSQL_READ_MINPOOLSIZE = "mysql.read.MinPoolSize";
    public static final String MYSQL_READ_ACQUIREINCREMENT = "mysql.read.AcquireIncrement";
    public static final String MYSQL_READ_MAXPOOLSIZE = "mysql.read.MaxPoolSize";
    public static final String MYSQL_READ_MAXIDLETIME = "mysql.read.MaxIdleTime";

}
