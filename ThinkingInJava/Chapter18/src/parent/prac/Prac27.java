package parent.prac;

import java.io.*;

class TheSerializableClass implements Serializable {
    private TheSerializableClass data;
    private String s;

    public TheSerializableClass(String s, TheSerializableClass data) {
        this.s = s;
        this.data = data;
    }

    public TheSerializableClass(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    @Override
    public String toString() {
        return data == null ? s : s + " contains: " + data.toString();
    }
}

public class Prac27 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TheSerializableClass x = new TheSerializableClass("outer", new TheSerializableClass("inner"));
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("SerializedClass.out"));
        out.writeObject("Write begin");
        out.writeObject(x);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("SerializedClass.out"));
        String meta = (String) in.readObject();
        TheSerializableClass x2 = (TheSerializableClass) in.readObject();
        in.close();
        System.out.println(meta);
        System.out.println(x2);
    }
}
