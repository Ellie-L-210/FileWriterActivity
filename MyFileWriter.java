package FileWriterActivity;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String hashFile(String filePath) {
        try {
            File current = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(current));
            String hashInput = "";
            while (br.ready()) {
                hashInput += br.read();
            }
            BigInteger num = new BigInteger(getSha(hashInput));
            StringBuilder hexFormat = new StringBuilder(num.toString(16));
            br.close();
            return hexFormat.toString();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("testfile1.txt");
        File file2 = new File("testfile2.txt");

        // printFileSize(file1.getName());
        // printFileSize(file2.getName());
        System.out.println(stringify(file1.getPath()));
    }

}