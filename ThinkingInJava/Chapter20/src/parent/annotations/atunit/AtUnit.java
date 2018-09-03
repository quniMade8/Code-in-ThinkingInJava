package parent.annotations.atunit;

import net.mindview.util.ProcessFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.*;


public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<>();
    static long testsRun = 0;
    static long failures = 0;

    public static void main(String[] args) {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);//enable asserts
        new ProcessFiles(new AtUnit(), "class").start(args);
        if (failures == 0)
            print("Ok (" + testsRun + " tests)");
        else {
            print("(" + testsRun + " tests)");
            print("\n>>> " + failures + " FAILURE" + (failures > 1 ? "S" : "") + " <<<");
            for (String failed : failedTests)
                print("  " + failed);
        }
    }

    @Override
    public void process(File cfile) {

    }
}
