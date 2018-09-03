package parent.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw e;
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String spliter) throws IOException {
        super(Arrays.asList(read(fileName).split(spliter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String fileName) throws IOException {
        this(fileName, "\n");
    }

    public void write(String fileName) throws FileNotFoundException {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for (String item : this)
                    out.print(item);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            String file = read("src/parent/demo/TextFile.java");
            write("test.txt", file);
            TextFile text = new TextFile("test.txt");
            text.write("test2.txt");
            TreeSet<String> words = new TreeSet<>(
                    new TextFile("src/parent/demo/TextFile.java", "\\W+"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
