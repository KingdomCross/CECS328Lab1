/*
Author: Alex Chheng
Author: Zixi Liu
Reference: https://www.journaldev.com/585/insertion-sort-java#:~:text=Insertion%20Sort%20in%20Java%201%20In%20java%20insertion,finally%20we%20have%20a%20sorted%20array%20of%20integers, https://www.informit.com/articles/article.aspx?p=680829&seqNum=3#:~:text=Processing%20a%20String%20One%20Character%20at%20a%20Time,from%200%20to%20the%20length%20of%20the%20string-1.
 */

import java.util.Arrays;

public class ModifiedInsertionSort {
    public static void main(String[] args){

        //Test
        System.out.println("Hello World");
        StringCheckTest("hello");
        StringCheckTest("world");
        CharCompare("hello", "world");
        System.out.println();
        CharCompare("testfortoday","todayfortest");

        int A[] = new int[10];
        populateArray(A);
        System.out.println("Before Sorting: ");
        printArray(A);
        // sort the array
        insertionSort(A);
        System.out.println("\nAfter Sorting: ");
        printArray(A);
    }

    /**
     * This method will sort the integer array using insertion sort in java algorithm
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }

    public static void printArray(int[] B) {
        System.out.println(Arrays.toString(B));
    }

    public static void populateArray(int[] B) {
        for (int i = 0; i < B.length; i++) {
            B[i] = (int) (Math.random() * 100);
        }
    }

    //Processing a String One Character at a Time
    public static void StringCheckTest(String n){
        for (int index = 0; index < n.length() - 1;
             index++) {
            char aChar = n.charAt(index);
            System.out.println(aChar);
        }
    }

    public static void CharCompare(String s1, String s2){
        for (int index = 0; index < s1.length() - 1;
             index++) {
            char aChar = s1.charAt(index);
            char bChar = s2.charAt(index);
            if (aChar == bChar){
                System.out.println(s1 + " " + s2 + " " + aChar + " = " + bChar);

            }
            else if (aChar <= bChar){
                System.out.println(s2 + " " + aChar + " < " + bChar);
            }
            else {
                System.out.println(s1 + " " + aChar + " > " + bChar);
            }
        }
    }
}
