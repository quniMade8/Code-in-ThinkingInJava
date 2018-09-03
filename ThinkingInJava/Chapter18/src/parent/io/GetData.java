package parent.io;

import java.nio.ByteBuffer;

import static net.mindview.util.Print.*;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        //Allocate 会将ByteBuffer置0
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        int i = 0;
        while (i++ < bb.limit())
            if (bb.get() != 0)
                print("nonzero");
        print("i = " + i);
        bb.rewind();
        //Store and read a char array:
        bb.asCharBuffer().put("Howdy!");
        char c;
        while ((c = bb.getChar()) != 0)
            printnb(c + " ");
        print();
        bb.rewind();
        //Store and read a short:
        bb.asShortBuffer().put((short) 471142);
        print(bb.getShort());
        bb.rewind();
    }
}
