package parent.prac;

import net.mindview.util.Directory;
import net.mindview.util.BinaryFile;

import java.io.File;
import java.io.IOException;

public class Prac20 {
    public static void main(String[] args) {
        Directory.TreeInfo treeInfo = Directory.walk("out", ".+\\.class");
        boolean flag = false;
        String[] hexArray = new String[4];
        for (File x : treeInfo.files) {
            try {
                byte[] result = BinaryFile.read(x.getAbsoluteFile());
                for (int i = 0; i < 4; i++) {
                    String hex = Integer.toHexString(0xFF & result[i]);
                    hexArray[i] = hex;
                }
                //System.out.println(hexArray.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
