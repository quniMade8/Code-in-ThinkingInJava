package parent.io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        //IntBuffer是一个view buffer,所有对其的操作将会映射到ByteBuffer
        IntBuffer ib = bb.asIntBuffer();
        //Store an array of int:
        ib.put(new int[]{11, 32, 33, 44, 123, 66, 1024});
        //Absolute location read and write:
        System.out.println(ib.get(3));
        ib.put(3, 1811);
        //Setting a new limit before rewinding the buffer.
        ib.flip();
        while (ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);
        }

        bb.rewind();
        while (bb.hasRemaining())
            System.out.println(bb.position() + " : " + bb.get());

        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        while (db.hasRemaining())
            System.out.println(db.position() + " : " + db.get());
    }
}
