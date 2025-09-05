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

}