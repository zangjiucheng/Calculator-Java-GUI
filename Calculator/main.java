package Calculator;

public class main {
    public static void main(String[] args) {
        Formula f1 = new Formula("1^4/4-0^4/4");
        try {
            System.out.println(f1.process());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
    }
}
