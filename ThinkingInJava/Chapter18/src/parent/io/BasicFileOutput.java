package parent.io;

import java.io.*;

public class BasicFileOutput {
    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {

//        BufferedReader in = new BufferedReader(
//                new FileReader("src/parent/io/BasicFileOutput.java"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
//        int lineCount = 1;
//        String s;
//        while ((s = in.readLine()) != null)
//            out.println(lineCount++ + ": " + s);
//        out.close();
//        System.out.println(BufferedInputFile.read(file));


        long time = System.currentTimeMillis();
        LineNumberReader in = new LineNumberReader(new BufferedReader(new FileReader("index.html")));
        PrintWriter out = new PrintWriter("BasicFileOutput.out");
        String s;
        while ((s = in.readLine()) != null)
            out.println(in.getLineNumber() + ": " + s);
        out.close();
        long nTime = System.currentTimeMillis();
        System.out.println("带缓存用时 : " + (nTime - time));

        long time2 = System.currentTimeMillis();
        LineNumberReader in2 = new LineNumberReader(new FileReader("index2.html"));
        PrintWriter out2 = new PrintWriter("BasicFileOutput2.out");
        String s2;
        while ((s2 = in2.readLine()) != null)
            out2.println(in2.getLineNumber() + ": " + s2);
        out2.close();
        long nTime2 = System.currentTimeMillis();
        System.out.println("不带缓存用时 : " + (nTime2 - time2));





    }
}
