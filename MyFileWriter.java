package FileWriterActivity;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class MyFileWriter {
    void makeHiddenFile(String password) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(".secretcodes.txt"));
            if (password.equals("")) {
                bufferedWriter.write("1234veryoriginal");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void makeHiddenFolder() {
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(
                    new FileWriter(
                            "/Users/ellieliou/Desktop/HonorsTopics/FileWriterActivity/.classifiedinfo/donttellanyone.dat"));
            bufferedWriter2.write("super secret phrase");
            bufferedWriter2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Calculate and print the file size using the File class
    private static void printFileSize(String fileName) {
        File current = new File(fileName);
        long length = current.length();
        System.out.println(length);
    }

    public static void main(String[] args) {
        File file1 = new File("testfile1.txt");
        File file2 = new File("testfile2.txt");

        printFileSize(file1.getName());
        printFileSize(file2.getName());
    }

}