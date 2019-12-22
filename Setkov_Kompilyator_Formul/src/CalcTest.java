import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) throws Exception {
        Calc c = new Calc();

        Scanner a = new Scanner(System.in);
        System.out.println("Ввод: ");
        c.compile(a.next().toCharArray());
        a.close();
    }
}
