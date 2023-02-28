package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] tokens = content.toString().split(" ");
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0L;
        for (int i = 0; i < tokens.length - 1; i++) {
            String next = tokens[i + 1];
            switch (tokens[i]) {
                case "Name:": name = next;
                break;
                case "Age:": age = Integer.parseInt(next);
                break;
                case "Email:": email = next;
                break;
                case "Phone:": phone = Long.parseLong(next);
                break;
                default: break;
            }
        }
        return new Profile(name, age, email, phone);
    }
}
