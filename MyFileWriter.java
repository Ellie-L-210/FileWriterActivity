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

    /**
     * Reads a text file and returns its contents as a string.
     * 
     * @param filePath the path to the file
     * @return the contents of the file as a string
     * @throws IOException if an I/O error occurs
     */
    public static String stringify(String filePath) throws IOException {
        File current = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(current));
        String output = "";
        while (br.ready()) {
            output += (char) br.read();
        }
        br.close();
        return output;
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("testfile1.txt");
        File file2 = new File("testfile2.txt");

        // printFileSize(file1.getName());
        // printFileSize(file2.getName());
        System.out.println(stringify(file1.getPath()));
    }

}