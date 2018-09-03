package parent.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static net.mindview.util.Print.*;

public class Endians {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);//由数组支持的Buffer
        bb.asCharBuffer().put("abcdef");//一个char占两个字节
        print(Arrays.toString(bb.array()));//只能在由数组支持的Buffer上调用此方法
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        print(Arrays.toString(bb.array()));
    }
}
