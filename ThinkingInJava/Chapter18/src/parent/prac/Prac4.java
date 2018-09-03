package parent.prac;

import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;

public class Prac4 {
    public interface Strategy {
        void process(File path);

        Object getReturn();
    }

    public Strategy strategy;
    private String regex;

    public Prac4(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void run(String[] args) {
        try {
            if (args.length == 0)
                doStrategy(new File(".").getCanonicalFile());
            else {
                for (String x : args)
                    if (new File(x).isDirectory())
                        doStrategy(new File(x).getCanonicalFile());
                    else
                        strategy.process(new File(x).getCanonicalFile());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doStrategy(File path) {
        for (File x : Directory.walk(path, regex).files) {
            strategy.process(x);
        }
    }

    public static void main(String[] args) {
        Prac4 x = new Prac4(new Prac4.Strategy() {
            int sum = 0;

            @Override
            public void process(File path) {
                sum += path.length();
            }

            @Override
            public Object getReturn() {
                return sum;
            }
        }, ".*\\.java");
        x.run(args);
        System.out.println((int) x.strategy.getReturn());
    }
}
