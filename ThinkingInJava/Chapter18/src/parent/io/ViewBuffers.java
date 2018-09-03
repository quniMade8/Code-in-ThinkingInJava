package parent.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import static net.mindview.util.Print.*;

public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});
        bb.rewind();
        printnb("Byte Buffer ");
        while (bb.hasRemaining())
            printnb(bb.position() + " -> " + bb.get() + ". ");
        print();

        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        printnb("Char buffer ");
        while (cb.hasRemaining())
            printnb(cb.position() + " -> " + bb.get() + ". ");
        print();


    }
}
