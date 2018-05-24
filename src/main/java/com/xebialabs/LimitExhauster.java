package com.xebialabs;

import java.io.IOException;

public class LimitExhauster {

    public static void main(String[] args) throws IOException {
        int numberOfThreads=50;
        for (int i=0; i<numberOfThreads; i++) {
            new ApiStreamer().start();
        }
    }
}
