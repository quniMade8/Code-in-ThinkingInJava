package parent.demo;

import net.mindview.util.PPrint;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class RecurseDirs {
    public static class Tree implements Iterable<File> {
        private List<File> dirs = new ArrayList<>();
        private List<File> files = new ArrayList<>();

        void addAll(Tree x) {
            dirs.addAll(x.dirs);
            files.addAll(x.files);
        }

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static Tree recurseDirs(File startDir, String regex) {
        Tree result = new Tree();
        for (File x : startDir.listFiles()) {
            if (x.isDirectory()) {
                result.dirs.add(x);
                result.addAll(recurseDirs(x, regex));
            } else if (x.isFile() && x.getName().matches(regex))
                result.files.add(x);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(recurseDirs(new File("e:/temp"), ".*"));
    }
}
