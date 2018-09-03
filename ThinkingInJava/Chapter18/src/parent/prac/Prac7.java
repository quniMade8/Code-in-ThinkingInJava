package parent.prac;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Prac7 {
    public static String file = "prac8.out";

    /**
     * 按行读取文本
     *
     * @param fileNames
     * @throws IOException
     */
    public static void readTxt(String[] fileNames) throws IOException {
        BufferedReader in;
        if (fileNames.length == 0) {
            in = new BufferedReader(new FileReader("thisDir/acc1.txt"));
            goRead(in, ".*");
        } else {
            String regex = fileNames[fileNames.length - 1];
            if (!regex.matches("-r:.*")) {
                regex = ".*";
            } else regex = regex.substring(3, regex.length());
            for (String filename : fileNames) {
                if (new File(filename).isFile()) {
                    in = new BufferedReader(new FileReader(filename));
                    goRead(in, regex);
                    in.close();
                } else
                    in = null;
            }
        }
    }

    public static void goRead(BufferedReader in, String regex) throws IOException {
        int lineCount = 1;
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        //等同于上面这行
        PrintWriter out = new PrintWriter(file);
        String line;
        LinkedList<String> linkedList = new LinkedList<>();
        while ((line = in.readLine()) != null) {
            if (line.matches(regex)) {
                System.out.println(line);
                out.println(lineCount++ + ": " + line);
            }
        }
        out.close();
    }

    public static void main(String[] args) throws IOException {
        readTxt(args);
    }
}
