package parent.io;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MappedIO {
    private static final int numOfInts = 4000000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.println(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    public static Tester[] tests = {
            new Tester("Steam Write") {
                @Override
                public void test() throws IOException {
                    DataOutputStream out = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream("performanceTest.txt")));
                    for (int i = 0; i < numOfInts; i++) {
                        out.writeInt(i);
                    }
                    out.close();
                }
            },
            new Tester("Mapped Write") {
                @Override
                public void test() throws IOException {
                    FileChannel out = new RandomAccessFile("performanceTest.txt", "rw").getChannel();
                    IntBuffer buff = out.map(FileChannel.MapMode.READ_WRITE, 0, out.size()).asIntBuffer();
                    for (int i = 0; i < numOfInts; i++) {
                        buff.put(i);
                    }
                    out.close();
                }
            },
            new Tester("Stream Read") {
                @Override
                public void test() throws IOException {
                    DataInputStream in = new DataInputStream(
                            new FileInputStream("performanceTest.txt"));
                    for (int i = 0; i < numOfInts; i++) {
                        in.read();
                    }
                }
            },
            new Tester("Mapped Read") {
                @Override
                public void test() throws IOException {
                    FileChannel in = new FileInputStream("performanceTest.txt").getChannel();
                    CharBuffer buff = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size()).asCharBuffer();
                    while (buff.hasRemaining())
                        buff.get();
                    in.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester test : tests)
            test.runTest();
    }
}
