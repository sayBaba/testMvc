package com.hz.testMvc.testMq.consumer;

import com.hz.testMvc.utils.RabbitMqConnectionUtil;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * 发布订阅-消费者1
 */
public class PubSubConsumer1 {

    //交换机名称
    private final static String EXCHANGE_NAME = "FANOUT_EXCHANGE";

    private final static String QUEUE_NAME = "QUEUE_FANOUT_1";

    public static void main(String[] args) throws IOException {
        //1.获取链接
        Connection connection = RabbitMqConnectionUtil.getRabbitMqCon();
        //2、声明信道
        Channel channel = null;
        try {
            channel = connection.createChannel();
            //3、声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //4.队列绑定交换机
            channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");
            //能者多劳
            channel.basicQos(1);

            //5.定义队列的消费者
            QueueingConsumer queueingConsumer =  new QueueingConsumer(channel);

            //6.设置自动确认
            channel.basicConsume(QUEUE_NAME,true,queueingConsumer);

            while (true){
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                String msg = new String(delivery.getBody());
                System.out.println(" 消费者1：" + msg + "'");
                //消费者1接收一条消息后休眠10毫秒
                Thread.sleep(10);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
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
