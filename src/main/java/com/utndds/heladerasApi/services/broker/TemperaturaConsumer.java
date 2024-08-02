package com.utndds.heladerasApi.services.broker;

import com.rabbitmq.client.*;

public class TemperaturaConsumer {
    private static final String EXCHANGE_NAME = "temperatura";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("lautaro_romero_21");
        factory.setPassword("laucha021");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");

            // Aca se manejaria la logica para procesar la temperatura recibida
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}