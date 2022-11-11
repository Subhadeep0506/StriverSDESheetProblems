import java.util.*;

class Test {
    public void calculateMarks() {
        double maths, science, english;
        System.out.println("Enter marks of Maths, Science and English: ")
        Scanner sc = new Scanner(System.in);
        maths = sc.nextDouble();
        science = sc.nextDouble();
        english = sc.nextDouble();

        double average = (maths + science + english) / 3.0;
        if (average > 85) {
            System.out.println("Well Done");
        }
        else {
            System.out.println("Work Hard");
        }
    }
}
