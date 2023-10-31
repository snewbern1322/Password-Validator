import java.util.Scanner;

public class PasswordValidator {
    public static boolean ValidatorMethod(String UserPassword){
        int CategoryAmount = 0;
        //set to false by default
        boolean lowercase = false;
        boolean uppercase = false;
        boolean numbers = false;
        boolean specialSymbols = false;
        
        //Check required conditons
        for (char ch : UserPassword.toCharArray()) {
            if (Character.isLowerCase(ch) && !lowercase){ //lowercase check
                CategoryAmount++; //add to count if condition is met...
                lowercase = true; //make condition true...
            }
            else if (Character.isUpperCase(ch) && !uppercase){ //uppercase check
                CategoryAmount++;
                uppercase = true;
            }
            else if (Character.isDigit(ch) && !numbers){ //number check
                CategoryAmount++;
                numbers = true;
            }
            else if ("~!@#$%^&*()-=+_".indexOf(ch) != -1 && !specialSymbols){ //symbol check
                CategoryAmount++;
                specialSymbols = true;
            }
        }
        
         return CategoryAmount >= 3;//returns value so new method is required. main function has VOID

    }

    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        //Prompt User
        System.out.println("Create a password that Satisfies the following requirements.");
        System.out.println("Must be between 8 and 16 characters.");
        System.out.println("Be a combination of at least three out of the following categories:");
        System.out.println("");
        System.out.println("-lower case letters(a-z)");
        System.out.println("-UPPER CASE LETTERS(A-Z)");
        System.out.println("-numbers(0-9)");
        System.out.println("-The following special symbols: ~!@#$%^&*()-=+_");
        System.out.println("");

        //User enters password
        System.out.print("Enter Password: ");
        String UserPassword = scanner.nextLine();
        scanner.close();

        //Check if password meets character count before checking other conditions
        int characterCount = UserPassword.length();
        if (characterCount < 8 || characterCount > 16) {
            System.out.println("Password must be between 8-16 characters, please try again.");
        }else{
            //inform user of password validity
            if (ValidatorMethod(UserPassword)){
                System.out.println("Your password meets the requirements listed!"); //password meets requirements
            }
            else{//doesnt meet requirements
                System.out.println("Your password does NOT meet one or more of the requirements listed..Please try again.");
            }

        }

        

    }
}
