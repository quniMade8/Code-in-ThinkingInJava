package parent.io;

import parent.demo.BufferedInputFile;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("thisDir/acc1.txt"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
}
