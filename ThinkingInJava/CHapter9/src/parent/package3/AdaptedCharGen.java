package parent.package3;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class AdaptedCharGen extends CharGen implements Readable {
    private int count = 0;

    public AdaptedCharGen(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) {
            return -1;
        }
        char[] result = generate();
        cb.append(String.valueOf(result));
        cb.append(" ");
        return 1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedCharGen(5));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}
