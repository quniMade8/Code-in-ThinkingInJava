package parent.proj.transaction;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class TransactionHandler implements InvocationHandler {
    private Object proxied;

    public TransactionHandler(Object transaction) {
        this.proxied = transaction;
    }

    private StringBuilder tempString;
    private String path;

    private void rollback() {
        if (path == null || path == "") {
            System.out.println("Rollback failed");
            System.exit(1);
        }
        BufferedWriter writer;
        try {
            File file = new File(path);
            writer = new BufferedWriter(new FileWriter(new File(path), false));
            writer.write(tempString.toString());
            writer.close();
            tempString.delete(0, tempString.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("****Proxy " + method);
        if (method.getName().equals("open")) {
            try {
                method.invoke(proxied, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                System.err.println("File couldn't be opened");
                System.exit(1);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                System.err.println("File couldn't be opened");
                System.exit(1);
            }
            File filename = new File(String.valueOf(args[0]));
            InputStreamReader reader = null;
            try {
                reader = new InputStreamReader(new FileInputStream(filename));
                BufferedReader br = new BufferedReader(reader);
                tempString = new StringBuilder();
                tempString.delete(0, tempString.capacity() - 1);
                String str;
                while ((str = br.readLine()) != null) {
                    tempString.append(str);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.err.println("Transaction init failed");
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Transaction init failed");
                System.exit(1);
            }
            path = (String) args[0];
        } else {
            try {
                method.invoke(proxied, args);
            } catch (IllegalAccessException e) {
                System.out.println(e.getCause());
                System.out.println("Rollback...");
                rollback();
                System.exit(1);
            } catch (InvocationTargetException e) {
                System.out.println(e.getCause());
                System.out.println("Rollback...");
                rollback();
                System.exit(1);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        TxtFileOperation real = new TextWriter();
        TxtFileOperation proxy = (TxtFileOperation) Proxy.newProxyInstance(
                TxtFileOperation.class.getClassLoader(),
                new Class[]{TxtFileOperation.class, List.class},
                new TransactionHandler(real)
        );
        proxy.open("a.txt", true);
        proxy.writeText("\none");
        proxy.dispose();
        proxy.open("a.txt", true);
        proxy.writeText("\ntwo");
        proxy.dispose();
        proxy.open("a.txt", true);
        proxy.writeText("\nthree");
        proxy.writeText("\nfour");
        proxy.dispose();
    }
}
