package com.xebialabs;

import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiStreamer extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                hitGithubApi();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hitGithubApi() throws IOException {

        final String userName = "";
        final String password = "";

        URL githubConnect = new URL("https://api.github.com/repos/{USERNAME}/{REPONAME}");
        HttpURLConnection connection = (HttpURLConnection) githubConnect.openConnection();

        connection.setRequestMethod("GET");

        byte[] encodedPassword = (userName + ":" + password).getBytes();
        BASE64Encoder encoder = new BASE64Encoder();
        connection.setRequestProperty("Authorization",
                "Basic " + encoder.encode(encodedPassword));

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        String line;

        while ((line=bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
