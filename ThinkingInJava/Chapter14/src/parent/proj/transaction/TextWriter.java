package parent.proj.transaction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter implements TxtFileOperation {
    BufferedWriter bufferedWriter;
    private static int exceptionTrigger = 0;

    @Override
    public void open(String fileName, boolean mode) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), mode));
    }

    @Override
    public void writeText(String text) throws IOException {
        if (exceptionTrigger == 3)
            throw new IOException();
        bufferedWriter.write(text);
        exceptionTrigger++;
    }

    @Override
    public void dispose() throws IOException {
        bufferedWriter.close();
    }
}
