package parent.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fileLock = fos.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("Locked file");
            TimeUnit.MILLISECONDS.sleep(100);
            fileLock.release();
            System.out.println("Released lock");
        }
        fos.close();
    }
}
