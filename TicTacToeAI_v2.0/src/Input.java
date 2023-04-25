import java.util.Scanner;

public class Input {
    public static String string(String input_string){
        Scanner scan = new Scanner(System.in);
        System.out.print(input_string);
        
        String user_input = scan.nextLine();
        return user_input;
    }

    public static char character(String input_string){
        Scanner scan = new Scanner(System.in);
        System.out.print(input_string);
        
        char user_input = scan.next().charAt(0);
        return user_input;
    }

    public static int integer(String input_string){
        Scanner scan = new Scanner(System.in);
        System.out.print(input_string);
        
        int user_input = scan.nextInt();
        return user_input;
    }

    public static double Double(String input_string){
        Scanner scan = new Scanner(System.in);
        System.out.print(input_string);
        
        double user_input = scan.nextDouble();
        return user_input;
    }
}
