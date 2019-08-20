package com.hz.testMvc.testMq.producer;

import com.hz.testMvc.utils.RabbitMqConnectionUtil;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * 简单队列-生产者
 */
public class SimpleProducer {

    public final static String QUEUE_NAME = "SIMPLE_QUEUE";

    public static void main(String[] args) throws IOException {
        //1.建立链接
        Connection connection = RabbitMqConnectionUtil.getRabbitMqCon();

        Channel channel =null;
        try {
            //2.建立通道
            channel = connection.createChannel();
            //3.创建队列
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            //4.往mq放消息
            String msg = "xiaoZhang say hello RabbitMq";
            //消息生产者发送消息给消息队列
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("----------msg放入mq--------"+msg);
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
