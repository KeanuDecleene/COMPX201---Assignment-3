public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.dump();
        System.out.println(s.length());
        s.push("lolcd");
        System.out.println(s.length());
        s.push("peep");
        System.out.println(s.length());
        s.dump();
        s.pop();
        s.dump();
        System.out.println(s.isEmpty());
        s.pop();
        System.out.println(s.isEmpty());
    }
}