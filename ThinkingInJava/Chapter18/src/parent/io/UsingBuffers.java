package parent.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import static net.mindview.util.Print.*;

public class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();//reset position to previously marked position
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);//一个char占两个字节
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
//        print("After putting:");
//        print("Limit: " + cb.limit());
//        print("Capacity: " + cb.capacity());
//        print("Position: " + cb.position());
        print(cb.rewind());
        symmetricScramble(cb);
        print(cb.rewind());
        symmetricScramble(cb);
        print(cb.rewind());
    }
}
