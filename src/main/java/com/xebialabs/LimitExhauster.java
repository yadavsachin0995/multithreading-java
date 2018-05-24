package com.xebialabs;

public class LimitExhauster {

    public static void main(String[] args) {
        int numberOfThreads = 50;
        for (int i = 0; i < numberOfThreads; i++) {
            new ApiStreamer().start();
        }
    }
}
