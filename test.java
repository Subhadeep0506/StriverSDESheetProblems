import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int N = s.nextInt();
            if (N < 21)
                System.out.println("" + -1);
            else
                System.out.println((int) Math.ceil(N / 21.0));
        }

        s.close();
    }
}