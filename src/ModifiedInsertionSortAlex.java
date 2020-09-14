/*
Author: Alex Chheng
Author: Zixi Liu
Reference: https://www.journaldev.com/585/insertion-sort-java#:~:text=Insertion%20Sort%20in%20Java%201%20In%20java%20insertion,finally%20we%20have%20a%20sorted%20array%20of%20integers, https://www.informit.com/articles/article.aspx?p=680829&seqNum=3#:~:text=Processing%20a%20String%20One%20Character%20at%20a%20Time,from%200%20to%20the%20length%20of%20the%20string-1.
 */

import java.util.Scanner;
import java.util.Arrays;

public class ModifiedInsertionSortAlex {
    public static void main(String[] args) {
        //CharCompare("andyhavetest", "alexhavetest");
        String[] arr = new String[] {"andy", "ands", "anda", "and", "boats", "boatc", "boat", "an", "sea"};
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Insertion Sort");
        InsertionSort(arr);

        System.out.println();
    	Scanner input = new Scanner(System.in);
        System.out.print("Enter a string of words: ");
        String[] original = input.nextLine().split("\\s+");
        String[] words = original.clone();  //get a clone of original array
        int[] counter = new int[original.length]; // get a empty Int array for counter

        sort(original, counter);
        
        System.out.println( " ");

        for(int i = 1;i<words.length;i++) {
     	System.out.print(words[i] + " ");
     	System.out.println(counter[i] + " ");
        }
    }
    
    public static void sort(String[] array, int[] counter)
    {
    	String key;
        
    	 for (int i=1; i<array.length; ++i)
    	 {
             key = array[i];
             int j = i-1;
             while (j>=0 && array[j].compareTo(key)>0)
             {
            	 array[j+1] = array[j];
                 j = j-1;
                 counter[i] = counter[i] +1;
             }
             array[j+1] = key;

        }
    	 for(int i = 0;i<array.length;i++)
         {
         	System.out.print(array[i] + " ");

         	
         }
    	 

         
    }

    public static String CharCompare(String s1, String s2){
        int keyLength; //Used for to compare the shortest word
        if (s1.length() <= s2.length()){
            keyLength = s1.length() - 1;
        }
        else {
            keyLength = s2.length() - 1;
        }

        for (int index = 0; index < keyLength; index++) {
            char aChar = s1.charAt(index);
            char bChar = s2.charAt(index);
            if (aChar > bChar){ //This is when the right is less than the left
                System.out.println(s1 + " " + s2);
                System.out.println(aChar + " > " + bChar);
                return s2;
            }
            else if (aChar < bChar){
                return  s1;
            }
        }
        return s1;
    }

    public static void InsertionSort(String[] arr){
        int keyLength; //Used for to compare the shortest word
        String aString;
        String bString;
        String tempString;
        String temp2String;

//        for (int i = 0; i < arr.length - 1; i++)
//        {
//            System.out.print(arr[i] + " ");
//        }

        for (int i = 0; i < arr.length - 1; i++){ //We don't want to count the last string because the bString is going to take the last string before i
            aString = arr[i];
            //System.out.println(aString + " " + bString);
            for (int j = 0; j < arr.length - 1 - i; j++){
                bString = arr[j + i + 1];
                //System.out.println(j + " j " + bString);


                if (aString.equals(bString)){
                    arr[i] = bString;
                    tempString = arr[i + 1];
                    arr[i + 1] = aString;
                    for(int k = 0; k < arr.length - 1 - i - j; k++){ //if there is more to the right of the list
                        temp2String = arr[i + k + 2];
                        arr[i + k + 2] = tempString;
                        tempString = arr[i + k + 3];
                        arr[i + k + 3] = temp2String;
                    }
                }

                if (aString.length() <= bString.length()){
                    keyLength = aString.length() - 1;
                }
                else {
                    keyLength = bString.length() - 1;
                }

                for (int index = 0; index < keyLength; index++) {
                    char aChar = aString.charAt(index);
                    char bChar = bString.charAt(index);
                    if (aChar > bChar){ //This is when the right is less than the left
                        //return s2;
                        arr[i] = bString;
                        tempString = arr[i + 1];
                        arr[i + 1] = aString;

                        System.out.println(aString + " " + tempString + " temp");
                        for(int k = 0; k < arr.length - 2 - i - j; k++){ //if there is more to the right of the list
                            temp2String = arr[i + k + 2];
                            arr[i + k + 2] = tempString;
                            System.out.println(k + " " + (arr.length - 2 - i - j));

                            if (k < arr.length - 3 - i - j){
                                tempString = arr[i + k + 3];
                                arr[i + k + 3] = temp2String;
                            }
                            System.out.println(temp2String + " " + tempString);
                        }
                        break;
                    }
                    else if (aChar < bChar){
                        //return  s1;
                        break;
                    }
                }
                for (int m = 0; m < arr.length; m++)
                {
                    System.out.print(arr[m] + " ");
                }
                System.out.println("Debug");
                //return s1;
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
