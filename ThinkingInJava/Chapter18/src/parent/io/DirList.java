package parent.io;

import java.util.regex.*;
import java.io.*;
import java.util.*;

import net.mindview.util.*;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".\\thisDir");//File类有一定的误导性，用FilePath更合适
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String x : list)
            System.out.println(x);
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    private String regex;

    public DirFilter(String regex) {
        this.regex = regex;
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        String absPath = dir.getAbsolutePath();
        String fileContent = TextFile.read(absPath + "\\" + name);
        return fileContent.trim().endsWith("accept\n") || fileContent.trim().endsWith("accept");
    }
}
