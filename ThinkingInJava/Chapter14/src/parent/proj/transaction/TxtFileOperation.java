package parent.proj.transaction;


import java.io.IOException;

public interface TxtFileOperation {
    void open(String fileName, boolean mode) throws IOException;

    void writeText(String text) throws IOException;

    void dispose() throws IOException;
}
