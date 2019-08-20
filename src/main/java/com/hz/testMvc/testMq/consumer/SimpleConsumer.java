package com.hz.testMvc.testMq.consumer;

import com.hz.testMvc.utils.RabbitMqConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * 简单队列-消费者
 */
public class SimpleConsumer {

    public final static String QUEUE_NAME = "SIMPLE_QUEUE";

    public static void main(String[] args) {
        //1.获取链接
        Connection connection = RabbitMqConnectionUtil.getRabbitMqCon();
        Channel channel = null;

        try {
            //2.建立通道
             channel = connection.createChannel();
             //3.声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //4.定义消费者队列
            QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

            /**
             * true:表示自动确认，只要消息从队列中获取，无论消费者获取到消息后是否成功消费，都会认为消息已经成功消费
             *
             * false: 手动确认消费者获取消息后，服务器会将该消息标记为不可用状态，等待消费者的反馈，
             * 如果消费者一直没有反馈，那么该消息将一直处于不可用状态，并且服务器会认为该消费者已经挂掉，不会再给其发送消息，直到该消费者反馈。
             */
            channel.basicConsume(QUEUE_NAME,false,queueingConsumer);

            //5.监听队列
            while (true){
                QueueingConsumer.Delivery  delivery = queueingConsumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("从队列中取出的消息："+message);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
