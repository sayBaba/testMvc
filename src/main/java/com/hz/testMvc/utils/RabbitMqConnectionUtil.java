package com.hz.testMvc.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 连接rabbitMq
 */
public class RabbitMqConnectionUtil {

    private final static Logger logger = LoggerFactory.getLogger(RabbitMqConnectionUtil.class);


    public static Connection getRabbitMqCon(){
        //定义rabbitMq连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;

        try {
            connectionFactory.setHost("127.0.0.1");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            logger.error("IOException",e);
            return connection;
        }

        return connection;
    }
}
