package parent.io;

import parent.demo.BufferedInputFile;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 从内存读取
 */
public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("src/parent/io/FormattedMemoryInput.java").getBytes()
                    )
            );
            while (true)
                System.out.print((char) in.readByte());
        } catch (IOException e) {
            System.err.println("End of stream");
        }
    }
}
