import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Command command = null;
        switch (number) {
            case 1:
                command = new Query();
                break;
        }
        command.execute();
    }
}
