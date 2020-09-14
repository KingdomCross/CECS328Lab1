/*
Author: Alex Chheng
Author: Zixi Liu
Reference: https://www.journaldev.com/585/insertion-sort-java#:~:text=Insertion%20Sort%20in%20Java%201%20In%20java%20insertion,finally%20we%20have%20a%20sorted%20array%20of%20integers, https://www.informit.com/articles/article.aspx?p=680829&seqNum=3#:~:text=Processing%20a%20String%20One%20Character%20at%20a%20Time,from%200%20to%20the%20length%20of%20the%20string-1.
 */

import java.util.Scanner;
import java.util.Arrays;

public class ModifiedInsertionSortAlex {
    public static void main(String[] args) {
        CharCompare("andyhavetest", "alexhavetest");

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
    
}
