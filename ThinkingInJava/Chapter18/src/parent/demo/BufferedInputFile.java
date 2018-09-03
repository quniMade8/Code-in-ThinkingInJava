package parent.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//缓冲输入文件
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        //BufferedReader装饰器,表示使用缓冲区来读取
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("src/parent/io/BufferedInputFile.java"));
    }
}
