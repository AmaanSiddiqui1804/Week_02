/* Program to Check Palindrome String
Problem Statement: 	Create a PalindromeChecker class with an attribute text. 
Add methods to:
Check if the text is a palindrome.
Display the result
*/

import java.util.Scanner;

class PalindromeChecker {
    String text ;
    // Constructor
    public PalindromeChecker(String text) {
        this.text = text;
    }

    //Method to check if the given text is a palindrome or not
    public boolean palindromeCheck(){
        text = text.trim();
        int start = 0  , end = text.length()-1;
        while(start<end){
            if(text.charAt(start) != text.charAt(end)){
                return false;
            }
            start++ ;
            end -- ;
        }
        return true ;
    }

    //Method to display result
    public void displayResult(){
        System.out.println("Is the given text: " + text + " palindrome ? " + palindromeCheck());
    }
}
public class Palindrome {
    public static void main(String[] args) {

        //creating scanner class instance
        Scanner sc = new Scanner(System.in);
        //Asking user for input
        System.out.println("Enter text to check for palindrome");
        String text = sc.nextLine() ;
        PalindromeChecker p1 = new PalindromeChecker(text);
        p1.displayResult();

        //Closing scanner class instance
        sc.close();
    }
    
}
