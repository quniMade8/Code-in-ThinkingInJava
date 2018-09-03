package parent.io;

import java.io.*;

import net.mindview.util.*;
import parent.demo.Directory;

import static net.mindview.util.Print.*;

public class DirectoryDemo {
    public static void main(String[] args) {
        PPrint.pprint(Directory.walk(".").dirs);
        for (File x : Directory.local(".", ".*")) {
            print(x);
        }
    }
}
