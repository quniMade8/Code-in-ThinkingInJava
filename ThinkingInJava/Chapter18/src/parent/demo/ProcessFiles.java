package parent.demo;

import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTress(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTress(fileArg);
                    else {
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTress(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date d = new Date(file.lastModified());
                try {
                    Date date = format.parse("2018-06-25");
                    if (d.after(date)){
                        System.out.println("File: " + file.getName() + " last modified: " + d);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }, "java").start(args);
    }
}
