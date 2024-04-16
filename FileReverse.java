package com.nav.myapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReverse {
    public static void main(String[] args) {
        String inputFile = "input.txt"; // Change this to your input file path
        String outputFile = "output.txt"; // Change this to your output file path
        try {
            // Read input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder inputContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                inputContent.append(line).append("\n");
            }
            reader.close();

            // Reverse the content
            String reversedContent = inputContent.reverse().toString();

            // Write reversed content to output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(reversedContent);
            writer.close();

            System.out.println("Reversed content has been written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}