import java.util.*;
import java.io.*;

public class JavaAssignment1 {
    public static void main(String [] args){
        int n = 10;
        System.out.println(nFactorial(n));
/*
        //Q1 testing
        int[] test = {0,2,3,1,5};
        int[] sorted = bubblesort(test);
        for (int i = 0; i < sorted.length; i++){
            System.out.print(sorted[i]);
        }
        System.out.println();


        //Q2 testing
        JavaAssignment1.DyamicFib();


        //Q3 testing
        String testString = "Hello!";
        String reverse = reverseString(testString);
        System.out.println(reverse);



        //Q4 testing
        int n = 10;
        System.out.println(nFactorial(n));



        //Q5 testing
        String hi = "Hello another test!";
        String testresult = substringMethod(hi, 10);
        System.out.println(testresult);




        //Q6 testing
        testMod(4);
        testMod(5);




        //Q7 testing
        String[] employees = {"brent", "brad"};
        String[] temp = compareEmployee(employees);
        System.out.println(temp[0]);
        System.out.println(temp[1]);




        //Q8
        ArrayList temp = palindromesList();
        for (int i = 0; i < temp.size(); i++){
            System.out.println(temp.get(i));
        }





        //Q9
        ArrayList prime = primeArray();

        for (int i = 0; i < prime.size(); i++){
            System.out.println(prime.get(i).toString());
        }




*/
        //Q12
        //enhancedForEven();
    }

    //Q1
    public static int[] bubblesort(int[] arr){
        int[] answer = arr;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return answer;
    }


    //Q2
    public static void DyamicFib(){

    long[] arr = new long[25];
    arr[0] = new Long(0);
    arr[1] = new Long(1);
    for (int i = 2; i < arr.length; i++){
        arr[i] = arr[i-1] + arr[i-2];
        System.out.println(arr[i]);
    }
        System.out.println(arr[arr.length-1]);
}

    //Q3
    public static String reverseString(String string){
        char[] chars = string.toCharArray();
        String answer = "";
        for(int i = 0; i < chars.length; i++){
            answer+= chars[chars.length-i-1];
        }
        return answer;
    }


    //Q4
    public static int nFactorial(int n){
        int answer = 1;
        for (int i = 1; i < n; i++){
            answer*= i;
        }
        return answer;

    }



    //Q5
    public static String substringMethod(String str, int idx){
        String answer ="";
        char[] charArr = str.toCharArray();

        for (int i = 0; i < idx ; i++){
            answer+= charArr[i];
        }
        return answer;
    }



    //Q6
    public static int testMod(int x){
        float flt = (float)x;
        float divided = flt/2;
        String converter = String.valueOf(divided);
        String[] splitting = converter.split("\\.");

        if (splitting[1].equals("0")){
            //System.out.println("This integer is even");
            return 1;
        } else {
            //System.out.println("This integer is odd");
            return 0;
        }
    }


    //Q7
    public static String[] compareEmployee(String[] arr){
        String[] sortedEmployees = new String[arr.length];
        if (arr[0].compareTo(arr[1]) > 0){
            sortedEmployees[0] = arr[1];
            sortedEmployees[1] = arr[0];
            return sortedEmployees;
        } else {
            return arr;
        }
    }


    //Q8
    public static ArrayList palindromesList(){
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
        ArrayList palindromes = new ArrayList();
        for (int i = 0; i < arr.size(); i++){
            if (isPalindrome(arr.get(i))){
                palindromes.add(arr.get(i));
            }
        }
        return palindromes;
    }
    public static boolean isPalindrome(String str){
        boolean answer = false;
        int count = 0;
        char[] charArray = str.toCharArray();
        for (int i = 0; i < Math.floor((double)charArray.length/2); i++){
            if (charArray[i] != charArray[charArray.length-i-1]){
                count++;
            }
        }
        if (count == 0){
            answer = true;
        }
        return answer;
    }




    //Q9
    public static ArrayList primeArray(){
        ArrayList oneToHundred = new ArrayList();
        ArrayList primes = new ArrayList();
        for (int i = 1; i < 101; i++){
            oneToHundred.add(i);
        }

        for (int i = 0; i < oneToHundred.size(); i++) {
            int curr = (int)oneToHundred.get(i);

            for (int j = 2; j < curr; j++){
                if (testMod(curr/j) == 1){
                    break;
                }

            }
            primes.add(oneToHundred.get(i));
        }
        return primes;
    }


    //Q10
    public static boolean ternaryOp(int x, int y){
        return (x<y) ? true:false;
    }

    //Q11
    //public static


    //Q12 NOT DONE
    public static void enhancedForEven(){
        int[] fill = new int[100];
        int i = 1;

        for (int x:fill){
            fill[x] = i;
            i++;
        }
        for (int x:fill){
            if (x%2 == 0){
                System.out.println(fill[x]);
            }
        }
    }
}
