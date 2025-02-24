import java.util.Scanner;

class User_Bank {
    static int Balance = 100000;
}

class ATM extends User_Bank {

    public void Withdrawal() {
        System.out.println("enter the amount to withdraw :");
        Scanner snum = new Scanner(System.in);
        int money = snum.nextInt();
        if (money <= Balance) {
            Balance = Balance - money;
            System.out.println("your balance " + Balance);
        } else {
            System.out.println("Insufficient Balance");
        }

    }

    public void Deposit() {
        System.out.println("enter the amount to deposit :");
        Scanner s_num = new Scanner(System.in);
        int money = s_num.nextInt();
        Balance = Balance + money;
        System.out.println("your balance " + Balance);
    }

    public void checkBalance() {
        System.out.println("Your current Balance is " + Balance);
    }
}

public class ATM_interface {
    static int money;

    public static void main(String[] args) {
        System.out.println("1.Withdrawal");
        System.out.println("2.Deposit");
        System.out.println("3.Check Balance");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your choice :");
        int choice = scan.nextInt();
        ATM ob = new ATM();

        switch (choice) {
            case 1:

                ob.Withdrawal();
                break;
            case 2:

                ob.Deposit();
                break;
            case 3:
                ob.checkBalance();
                break;
            default:
                System.out.println("Invalid number ! Try Again");
                
        }

    }
}
