package org.example;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionGenerator 
{
    public static void main(String[] args) 
    {
        String transactionId = UUID.randomUUID().toString();
        String timestamp = LocalDateTime.now().toString();
        double amount = Math.random() * 10000;  // random amount up to 10,000
        String currency = Math.random() > 0.5 ? "INR" : "USD";
        String senderAccount = "ACC" + (int)(Math.random() * 1000000);
        String receiverAccount = "ACC" + (int)(Math.random() * 1000000);
        String transactionType = Math.random() > 0.5 ? "UPI" : "CARD";
        String channel = Math.random() > 0.5 ? "MOBILE" : "WEB";
        String deviceId = "DEV-" + (int)(Math.random() * 999999);
        String ipAddress = (int)(Math.random()*255) + "." +
                (int)(Math.random()*255) + "." +
                (int)(Math.random()*255) + "." +
                (int)(Math.random()*255);
        String location = Math.random() > 0.5 ? "Chennai, India" : "New York, USA";
        boolean successStatus = Math.random() > 0.2;  // 80% success

        System.out.println("=== Fake Transaction Generated ===");
        System.out.println("Transaction ID   : " + transactionId);
        System.out.println("Timestamp        : " + timestamp);
        System.out.println("Amount           : " + String.format("%.2f", amount));
        System.out.println("Currency         : " + currency);
        System.out.println("Sender Account   : " + senderAccount);
        System.out.println("Receiver Account : " + receiverAccount);
        System.out.println("Transaction Type : " + transactionType);
        System.out.println("Channel          : " + channel);
        System.out.println("Device ID        : " + deviceId);
        System.out.println("Location         : " + location);
        System.out.println("IP Address       : " + ipAddress);
        System.out.println("Success Status   : " + (successStatus ? "SUCCESS" : "FAILED"));
    }
}