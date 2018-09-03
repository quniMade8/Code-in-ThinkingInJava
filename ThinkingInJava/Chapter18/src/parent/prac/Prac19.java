package parent.prac;

import net.mindview.util.BinaryFile;

import java.io.IOException;

public class Prac19 {
    public static void main(String[] args) {
        try {
            byte[] result = BinaryFile.read("src/parent/prac/Prac19.java");
            for (byte x : result) {
                System.out.print((char) x + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
