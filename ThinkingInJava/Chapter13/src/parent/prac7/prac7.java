package parent.prac7;

public class prac7 {
    private static String sentence = "You shall not pass.";
    private static String sentence2 = "greenIsTheColor";

    public static void main(String[] args) {
        System.out.println(sentence.matches("[A-Z]+.+\\."));
        System.out.println(sentence2.matches("[A-Z]+.+\\."));
    }

}
