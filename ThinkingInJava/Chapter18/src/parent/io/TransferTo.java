package parent.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
    //复制文件
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        //or
        //out.transferFrom(in,0,in.size());
    }
}
