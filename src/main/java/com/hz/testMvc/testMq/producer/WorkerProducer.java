package com.hz.testMvc.testMq.producer;

import com.hz.testMvc.utils.RabbitMqConnectionUtil;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * 工作模式,1个生产者对应多个消费者
 */
public class WorkerProducer {

    public final static String QUEUE_NAME = "WORKER_QUEUE";

    public static void main(String[] args) {
        //1.获取链接
        Connection connection = RabbitMqConnectionUtil.getRabbitMqCon();
        //2、声明信道
        Channel channel = null;

        try {
            channel = connection.createChannel();
            //3、声明(创建)队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //4、定义消息内容(发布多条消息)
            for(int i = 0 ; i < 10 ; i++){
               String message = "xiu zhang say hello mq: "+i;
                channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
                System.out.println("[x] Sent'"+message+"':");
                Thread.sleep(i*10);
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
