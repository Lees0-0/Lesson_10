package org.example.ex2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class CopyPasterToJson {
    public static void main(String[] args) throws IOException {
        List<User> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("./ex2/file.txt"))) {
            String headerLine = reader.readLine();
            String[] headers = headerLine.split(" ");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                String name = values[0];
                int age = Integer.parseInt(values[1]);
                userList.add(new User(name, age));
            }
        }

        try (FileWriter writer = new FileWriter("./ex2/user.json")) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(userList, writer);
        }
    }
}
