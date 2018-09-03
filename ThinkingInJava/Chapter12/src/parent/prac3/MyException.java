package parent.prac3;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class MyException extends Exception {
    private String info = "";
    private static Logger logger = Logger.getLogger("MyException");

    public MyException(String info) {
        this.info = info;
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public void printInfo() {
        System.err.println(info);
    }
}
