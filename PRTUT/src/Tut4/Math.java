package Tut4;


import java.util.Arrays;

public class Math {
    /**
     * find the remainder after integer division using only subtraction
     *
     * @requires  a and b are both not null /\ b != 0
     * @effects return r is the remainder of (a / b), using only subtraction
     *
     *          e.g. remainder(4, 3) = 1
     */
    public static int remainder(int a, int b) {
        while(a>=b){
            a-=b;
        }

        return a;
    }

    /**
     * find the remainder after integer division using only subtraction
     *
     * @requires  a and b are both not null /\ b != 0
     * @effects return c is the result of (a / b), using only subtraction or addition
     *
     *          e.g. div(10, 4) = 2
     */
    public static int div(int a, int b) {
        int div = 0;
        while(a>=b){
            a-=b;
            div++;
        }
        return div;
    }

    /**
     * determine the middle one of three numbers
     *
     * @requires a, b and c are not null
     * @effects find the middle number in the 3 number
     *
     *          e.g. middle(45, 23, 36.5) = 36.5
     */
    public static double middle(double a, double b, double c) {
        double[] arr = {a,b,c};
        Arrays.sort(arr);
        return arr[1];
    }

    /**
     * determine whether or not a string is a palindrome
     *
     * @requires s is not a null String
     * @effects check if s is a palindrome or not
     *
     *          e.g. isPalindrome("anna") = true
     *               isPalindrome("3232") = false
     */
    public static boolean isPalindrome(String s) {
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1) ){
                return false;
            }
        }
        return true;
    }

    /**
     * determine if an integer is a prime
     * @requires i > 1
     * @effects check if i is a prime number or not
     *
     *
     *          e.g. isPrime(5) = true
     *               isPrime(15) = false
     */
    public static boolean isPrime(int n) {
        for(int i = 2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

