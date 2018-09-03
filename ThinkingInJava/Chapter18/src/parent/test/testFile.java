package parent.test;

import org.junit.Test;

import java.io.*;

public class testFile {
    @Test
    public void testFile() {
        File f1 = new File("e:/temp/vr");
        File f2 = new File("not_exist");
        System.out.println(f1.getName());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getAbsoluteFile());
        System.out.println(f1.canWrite());
        System.out.println();
        System.out.println(f2.isDirectory());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getAbsoluteFile());
        System.out.println(f2.canRead());
    }

    @Test
    public void testWriter() throws IOException {
        BufferedWriter out = new BufferedWriter(
                new FileWriter("testOut.txt"));
        out.write(20013);
        out.close();
        BufferedReader in = new BufferedReader(
                new FileReader("testOut.txt"));
        int c;
        while ((c = in.read()) != -1)
            System.out.println(c);
    }
}
