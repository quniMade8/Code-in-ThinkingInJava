package parent.prac;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class SortedDirList {
    private File filePath;
    private String[] filePathList;


    public SortedDirList(String path) {
        filePath = new File(path);
        filePathList = filePath.list();
    }

    public String[] list() {
        Arrays.sort(filePathList, String.CASE_INSENSITIVE_ORDER);
        return filePathList;
    }

    public String[] list(String regex) {
//        String[] list = filePath.list(new FilenameFilter() {
//            private Pattern pattern = Pattern.compile(regex);
//
//            @Override
//            public boolean accept(File dir, String name) {
//                return pattern.matcher(name).matches();
//            }
//        });
//        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
//        return list;
        String[] list = new String[filePathList.length];
        int index = 0;
        Pattern pattern = Pattern.compile(regex);
        for (String x : filePathList) {
            if (pattern.matcher(x).matches())
                list[index++] = x;
        }
        return list;
    }
}
