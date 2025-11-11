import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileInspector {
    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser("src");
        int result = chooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            Path file = selectedFile.toPath();

            int wordCount = 0;
            int lineCount = 0;
            int characterCount = 0;

        try {

            System.out.println("File contents: ");
            System.out.println();

            // Word count
            for (String line : Files.readAllLines(file)) {

                System.out.println(line);
                lineCount++;
                System.out.println();

                if (!line.isEmpty()) {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }
                // Character count
                characterCount += line.length();
            }
        // Summary Report
        System.out.println("Summary Report: ");
        System.out.println("File Name: " + selectedFile.getName());
        System.out.println("Number of Lines: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + characterCount);

        } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
                }
            }
        }
    }