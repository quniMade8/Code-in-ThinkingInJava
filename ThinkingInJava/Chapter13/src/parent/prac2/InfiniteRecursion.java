package parent.prac2;

public class InfiniteRecursion {
    @Override
    public String toString() {
        //this+ 会调用toString(),引起死循环
        //return "InfiniteRecursion:" + this + "\n";
        return "InfiniteRecursion:" + super.toString() + "\n";
    }

    public static void main(String[] args) {
        InfiniteRecursion x = new InfiniteRecursion();
        System.out.println(x);
    }
}
