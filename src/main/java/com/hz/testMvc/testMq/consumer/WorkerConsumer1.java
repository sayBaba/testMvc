package com.hz.testMvc.testMq.consumer;

import com.hz.testMvc.utils.RabbitMqConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * worker模式-消费者1
 */
public class WorkerConsumer1 {

    public final static String QUEUE_NAME = "WORKER_QUEUE";

    public static void main(String[] args) {
        //1.获取链接
        Connection connection = RabbitMqConnectionUtil.getRabbitMqCon();
        //2、声明信道
        Channel channel = null;
        try {
            channel = connection.createChannel();
            //3.声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicQos(1);

            //4.定义队列的消费者
            QueueingConsumer queueingConsumer =  new QueueingConsumer(channel);
            //5、监听队列,手动返回完成状态
            channel.basicConsume(QUEUE_NAME,false,queueingConsumer);
            //能者多劳
            channel.basicQos(1);

            while (true){
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                String msg = new String(delivery.getBody());
                System.out.println(" [x] Received '" + msg + "'");
                //消费者1接收一条消息后休眠10毫秒
                Thread.sleep(10);
                //手动确认
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
