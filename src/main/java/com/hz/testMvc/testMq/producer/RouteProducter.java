package com.hz.testMvc.testMq.producer;

import com.hz.testMvc.utils.RabbitMqConnectionUtil;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * 路由模式-生产者
 */
public class RouteProducter {

    private final static String EXCHANGE_NAME = "ROUTE_EXCHANGE";


    public static void main(String[] args) {
        //1.建立链接
        Connection connection = RabbitMqConnectionUtil.getRabbitMqCon();
        //2、声明信道
        Channel channel = null;

        try {
            channel = connection.createChannel();
            //3,声明交换机
            channel.exchangeDeclare(EXCHANGE_NAME,"direct");
            //4、创建消息
            String message = "hello rabbitmq";
            //发布消息,指定key为："update"
            channel.basicPublish(EXCHANGE_NAME,"select",null,message.getBytes());
            System.out.println("[x] Sent'" + message + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //7、关闭连接
            try {
                if (channel != null) {
                    channel.abort();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }catch (AlreadyClosedException e){
                e.printStackTrace();
            }
        }


    }

}
