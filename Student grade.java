import java.util.Scanner;

class Student_grade {
    public static void main(String[] args) {
        System.out.println("Enter the number of subjects");
        Scanner scan = new Scanner(System.in);
        int sub = scan.nextInt();
        int[] mark = new int[sub + 1];
        int sum = 0;
        for (int i = 1; i <= sub; i++) {
            System.out.println("Enter the mark of " + i + " Subject");
            mark[i] = scan.nextInt();
        }
        for (int x : mark) {
            sum = sum + x;
        }
        System.out.println("Grand total : " + sum);
        int avg_mark = sum / sub;
        System.out.println("Average percentage :" + avg_mark + "%");
        if (avg_mark >= 90) {
            System.out.println("Grade :A");
        } else if (avg_mark >= 70) {
            System.out.println("Grade :B");
        } else if (avg_mark >= 50) {
            System.out.println("Grade :C");
        } else {
            System.out.println("Grade :F");
        }

    }
}
