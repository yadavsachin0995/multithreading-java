package com.xebialabs;

import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiStreamer extends Thread {

//    Override the run method to call hitGithubApi() method infinitely
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
//        Username and Password of Github Account
        final String userName = "";
        final String password = "";

//        Create the URL by replacing {USERNAME} with GitHub username and {REPONAME} with any repo
//        which the account hosts
        URL githubConnect = new URL("https://api.github.com/repos/{USERNAME}/{REPONAME}");
        HttpURLConnection connection = (HttpURLConnection) githubConnect.openConnection();

//        Set HTTP Request Method
        connection.setRequestMethod("GET");

//        Encode the basicAuth Credentials and set it as property
        byte[] encodedPassword = (userName + ":" + password).getBytes();
        BASE64Encoder encoder = new BASE64Encoder();
        connection.setRequestProperty("Authorization",
                "Basic " + encoder.encode(encodedPassword));

//        Get the input stream from connection into a bufferedReader variable
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));

        String line;

//        Write the stream to standard output
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
//        Finally close the bufferedReader
        bufferedReader.close();
    }
}
