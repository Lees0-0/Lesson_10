package org.example.ex1;

import java.io.*;

public class PhoneNumber {

    public static void main(String[] args) throws IOException {
        String fileName = "./ex1/file.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        }
    }
    private static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }

        if (phoneNumber.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$")) {
            return true;
        }
        return false;
    }
}