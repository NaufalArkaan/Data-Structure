package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class StackQueueCodelab {
    public static void main(String[] args) {
        Queue<String> serviceQueue = new LinkedList<>();

        serviceQueue.add("Andi");
        serviceQueue.add("Titan");
        serviceQueue.add("Rapi");

        System.out.println("Initial Service Queue:");
        System.out.println(serviceQueue);

        String servedPassenger = serviceQueue.poll();
        System.out.println("Serving passenger: " + servedPassenger);

        System.out.println("Queue after serving:");
        System.out.println(serviceQueue);

        String nextPassenger = serviceQueue.peek();
        System.out.println("Next passenger to server: " + nextPassenger);
        System.out.println();

        Stack<String> transactionHistory = new Stack<>();

        transactionHistory.push("Transaction-1");
        transactionHistory.push("Transaction-2");
        transactionHistory.push("Transaction-3");

        System.out.println("Transaction History:");
        System.out.println(transactionHistory);

        String lastTransaction = transactionHistory.pop();
        System.out.println("Undo last transaction: " + lastTransaction);

        System.out.println("Transaction History after undo:");
        System.out.println(transactionHistory);

        String topTransaction = transactionHistory.peek();
        System.out.println("Current top transaction: " + topTransaction);

        //System.out.println();

        if(transactionHistory.isEmpty()){
            System.out.println("No transaction history.");
        }else{
            System.out.println("Transaction history is not empty. Size: " + transactionHistory.size());
        }
    }
}
