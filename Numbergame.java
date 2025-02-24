import java.util.Random;
import java.util.Scanner;

class Numbergame {
    int rand;
    int a;
    static int count = 1;

//User input and compare with random number

    void User_no(int rand, int i) {
        this.rand = rand;
        Scanner scan = new Scanner(System.in);
        System.out.print("enter your guess number :");
        int a = scan.nextInt();
        if (a != rand) {
            check(a);
            count = count + 1;
        } else {
            System.out.println("your guess is correct");
            score(count);
            System.exit(0);

        }

    }

// random number is greater or lesser than user input

    void check(int a) {
        this.a = a;
        if (a > rand) {
            System.out.println("your input is too high");
        } else {
            System.out.println("your input is too low");
        }

    }

    // score

    void score(int count) {
        System.out.println("No.of attempts:" + count);
        if (count == 1) {
            System.out.println("your score :100");
        } else if (count > 1 && count <= 3) {
            System.out.println("your score :75");
        } else if (count >= 4 && count < 7) {
            System.out.println("your score :50");
        } else {
            System.out.println("your score :25");
        }

    }

    public static void main(String[] args) {
        for (int j = 0; j <= 3; j++) {
            System.out.println("1.To play");
            System.out.println("2.exit");
            Scanner num = new Scanner(System.in);
            System.out.println("Enter your choice");
            int choice = num.nextInt();
            Random snum = new Random();
            int rand = snum.nextInt(100) + 1;
            switch (choice) {
                case 1:
                    for (int i = 1; i <= 10; i++) {
                        if (true) {
                            Numbergame ob = new Numbergame();
                            ob.User_no(rand, 1);
                        }

                    }
                    System.out.println("The number is :" + rand);
                    break;

                case 2:
                    System.out.println("you are exit from the game");
                    break;

                default:
                    System.out.println("Enter valid number");
                    break;

            }
        }
    }
}
