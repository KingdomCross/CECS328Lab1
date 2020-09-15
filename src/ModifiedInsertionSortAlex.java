/*
Author: Alex Chheng
Author: Zixi Liu
Reference: https://www.journaldev.com/585/insertion-sort-java#:~:text=Insertion%20Sort%20in%20Java%201%20In%20java%20insertion,finally%20we%20have%20a%20sorted%20array%20of%20integers, https://www.informit.com/articles/article.aspx?p=680829&seqNum=3#:~:text=Processing%20a%20String%20One%20Character%20at%20a%20Time,from%200%20to%20the%20length%20of%20the%20string-1, https://www.geeksforgeeks.org/java-program-for-insertion-sort/.
 */

import java.util.Scanner;

public class ModifiedInsertionSortAlex {
    public static void main(String[] args) {
        String[] strArray = new String[] {"andy", "ands", "anda", "and", "boats", "boatc", "boat", "an", "sea"};
        String[] strArray2 = new String[] {"check", "checkz", "check", "checks", "checks", "check"};
        String[] strArray3 = new String[] {"apple", "test", "going", "zebra", "aardvark"};
        //InsertionSort(strArray);

        PrintArray(strArray3);
        System.out.println("[Original]");
        InsertionSortImperative(strArray3);
        System.out.println();

        PrintArray(strArray);
        System.out.println("[Original]");
        InsertionSortImperative(strArray);
        System.out.println();

        PrintArray(strArray2);
        System.out.println("[Original]");
        InsertionSortImperative(strArray2);
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
        
    	 for (int i=1; i < array.length; ++i)
    	 {
             key = array[i];
             int j = i-1;

             
             while (j >= 0 && charCompare(array[i],array[j]))
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
    
    
    public static boolean charCompare(String s1, String s2)
    {
    	int keyLength;
    	boolean flag = false;

  
    	
    	if (s1.length() <= s2.length())
    	{
    		keyLength = s1.length() - 1;
    	}
    	else 
        {
    		keyLength = s2.length() - 1;
        }

    	System.out.println("comparing " + s1 + " and " + s2);
        
    	for (int index = 0; index < keyLength; index++) 
    	{
    		char aChar = s1.charAt(index);
    		char bChar = s2.charAt(index);
    		System.out.println(bChar + " " + aChar+ " "+Character.valueOf(bChar).compareTo(Character.valueOf(aChar)));
    		System.out.println("index"+index);

    		
    		while(flag = false)
    		{
    			if(Character.valueOf(bChar).compareTo(Character.valueOf(aChar)) < 0)
    			{
    				flag = true;
    			}
    			else
    			{
    				flag = false;
    			}
    			
    		}
    		
    		System.out.println("temvalue "+ flag);

    	}
    	
    	
		return flag;
    	
    	
    }
    public static void InsertionSort(String[] arr){
        int keyLength; //Used for to compare the shortest word
        int maxLength;
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
                bString = arr[j + i + 1]; //Data need to be in sort is copy
                //System.out.println(j + " j " + bString);

//                if (aString.equals(bString)){
//                    arr[i] = bString;
//                    tempString = arr[i + 1];
//                    arr[i + 1] = aString;
//                    for(int k = 0; k < arr.length - 1 - i - j; k++){ //if there is more to the right of the list
//                        temp2String = arr[i + k + 2];
//                        arr[i + k + 2] = tempString;
//                        tempString = arr[i + k + 3];
//                        arr[i + k + 3] = temp2String;
//                    }
//                }

                if (aString.length() <= bString.length()){ //need to take in the least length
                    keyLength = aString.length();
                    maxLength = bString.length();
                }
                else {
                    keyLength = bString.length();
                    maxLength = aString.length();
                }

                for (int index = 0; index < keyLength - 1; index++) {
                    char aChar = aString.charAt(index);
                    char bChar = bString.charAt(index);
                    if (aChar > bChar){ //This is when the right is less than the left
                        //return s2;
                        //tempString = arr[i + 1];
                        for(int k = i + j + 1; k > arr.length - 1 - i - j; k--){ //if there is more to the right of the list
                            tempString = arr[k - 1];
                            arr[k] = tempString;
                        }
                        arr[i] = bString;
                        arr[i + 1] = aString;
                        break;
                    }
                    else if (aChar < bChar){
                        //return  s1;
                        break;
                    }
                    else if (index == keyLength - 1 && keyLength < maxLength){ //This tells us that it match but the right is less than the left
                        //need to be behind left
                        for(int k = i + j + 1; k > arr.length - 1 - i - j; k--){ //if there is more to the right of the list
                            tempString = arr[k - 1];
                            arr[k] = tempString;
                        }
                        arr[i] = bString;
                        arr[i + 1] = aString;
                        break;
                    }
                }
//                for (int m = 0; m < arr.length; m++)
//                {
//                    System.out.print(arr[m] + " ");
//                }
//                System.out.println("Debug");
                //return s1;
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
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
