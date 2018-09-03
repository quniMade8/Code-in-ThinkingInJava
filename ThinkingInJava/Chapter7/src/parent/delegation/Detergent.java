package parent.delegation;

class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute");
    }

    public void apply() {
        append("apply");
    }

    public void scrub() {
        append("scrub");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

//代理类
public class Detergent {
    private Cleanser cleanser = new Cleanser();
    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    public void scrub() {
        cleanser.scrub();
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();x.apply();
        System.out.println(x.cleanser);
    }

}
