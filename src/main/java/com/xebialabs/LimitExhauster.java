package com.xebialabs;

public class LimitExhauster {

    public static void main(String[] args) {
//        Set the number of threads you want to hit the Api
        int numberOfThreads = 50;
        for (int i = 0; i < numberOfThreads; i++) {
            new ApiStreamer().start();
        }
    }
}
