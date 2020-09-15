/*
Author: Alex Chheng
Author: Zixi Liu
Reference: https://www.journaldev.com/585/insertion-sort-java#:~:text=Insertion%20Sort%20in%20Java%201%20In%20java%20insertion,finally%20we%20have%20a%20sorted%20array%20of%20integers, https://www.informit.com/articles/article.aspx?p=680829&seqNum=3#:~:text=Processing%20a%20String%20One%20Character%20at%20a%20Time,from%200%20to%20the%20length%20of%20the%20string-1, https://www.geeksforgeeks.org/java-program-for-insertion-sort/.
 */

import java.util.Scanner;

public class ModifiedInsertionSortAlex {
    public static void main(String[] args) {
        String[] strArray = new String[] {"apple", "test", "going", "zebra", "aardvark"};
        String[] strArray2 = new String[] {"andy", "ands", "anda", "and", "boats", "boatc", "boat", "an", "sea"};
        String[] strArray3 = new String[] {"check", "checkz", "check", "checks", "checks", "check"};
        String[] strArray4 = new String[] {"alex", "alexandra", "sam", "bob", "nick", "zixi", "al"};

        //InsertionSort(strArray);

        PrintArray(strArray);
        System.out.println("[Original]");
        InsertionSortImperative(strArray);
        System.out.println();

        PrintArray(strArray2);
        System.out.println("[Original]");
        InsertionSortImperative(strArray2);
        System.out.println();

        PrintArray(strArray3);
        System.out.println("[Original]");
        InsertionSortImperative(strArray3);
        System.out.println();

        PrintArray(strArray4);
        System.out.println("[Original]");
        InsertionSortImperative(strArray4);
        System.out.println();
    }
    
    public static boolean CharKeyCompare(String[] arr, int j, String key){
        int keyLength; //Used for to compare the shortest word
        String aString = arr[j];

//        Same as the line below
        /*if (aString.length() <= key.length()){ //need to take in the least length
            keyLength = aString.length();
        }
        else {
            keyLength = key.length();
        }*/
        keyLength = Math.min(aString.length(), key.length()); //need to take in the least length

        for (int index = 0; index < keyLength - 1; index++) {
            char aChar = aString.charAt(index);
            char bChar = key.charAt(index);

            if (aChar > bChar){ //This is when the right is less than the left
                //return s2;
                //System.out.println(index + " " + aChar + " " + aString + " " + bChar + " " + bString);
                return true;
            }
            else if (aChar < bChar){
                //return  s1;
                //System.out.println(index + " " + aChar + " " + aString + " " + bChar + " " + bString);
                return false;
            }
//            else if (index == keyLength - 2 && aString.length() == bString.length()){ //This line will work if the next else statement is not working. due to string logic error
//                return false;
//            }
            else if (index == keyLength - 2 && aString.length() > key.length()){ //This tells us that it match but the right is less than the left
                //need to be behind left
                //System.out.println(index + " " + aChar + " " + aString + " " + bChar + " " + bString);
                //System.out.println("Max Index " + keyLength + " " + maxLength + " " + index);
                return true;
            }
        }
        //PrintArray(arr);
        //System.out.println();
        //System.out.println(aString + " " + bString);
        return false;
    }

    public static void InsertionSortImperative(String[] arr){
        for (int i = 1; i < arr.length; i++){
            String key = arr[i];
            int j = i - 1;
            //while (j >= 0 && arr[j] > key)
            while (j >= 0 && CharKeyCompare(arr, j, key)){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        PrintArray(arr);
    }

    public static void PrintArray(String[] arr){
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
