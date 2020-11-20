package project1;

// CHANGE

import java.util.Scanner;

public class ModifiedInsertionSort
{
	 public static void main(String[] args)
     {
         String[] stringArray = {"apple", "test", "going", "zebra", "aardvark"};
		 //String[] stringArray = {"andy", "ands", "anda", "and", "boats", "boatc", "boat", "an" , "sea"};

          System.out.println("Orignal array:");
          for(int i = 0;i<stringArray.length;i++)
          {
              System.out.print(stringArray[i] + " ");
          }
          
          

          String[] sortedArray = sortArray(stringArray);

          System.out.println("Sorted array:");
          for(int i = 0;i<sortedArray.length;i++)
          {

              System.out.print(sortedArray[i] + " ");
          }
     }
	 
	 public static String[] sortArray(String[] array)
	{
		 
		 String sortedArray[] = array.clone(); //make another array for display the counter		 
		 int j ;
		  
		 for(int i = 1; i < array.length; i++)
		 {
			 j = 1;
			 int counter = 1; 
			 while(compare(array[i], sortedArray[i - j ]))
			 {
				 
				 if(i - j  == 0)
				 {
					 j  = j + 1;
					 counter --; //deleted the duplicate counter
					 break;
				 } 
				 
				j++;
				
			 }
			 
			int index = i;
			String key = array[i];
			

			for(int x = 1; x < j ; x++)
			{
				sortedArray[i] = sortedArray[i-1];
				
				i = i-1;
				
				counter ++;
			}
			sortedArray[i] = key;
			i = index;
			
			
			System.out.println(array[i] + " " + counter); //array[i] always started on the 2nd
			
		}
		return sortedArray;
	}
	 
	 public static String stringToString(String s) //delete the last char
	 {
		 if (s != null && s.length() > 1 ) 
		 {
		        s = s.substring(0, s.length() - 1);
		 }
		 return s;
	}
	 
	 
	 
	 public static Boolean compare(String s1, String s2)
	 {
		 
	 	char[] sOne = stringToString(s1).toCharArray();//change string to char array, easy for comparison
	 	
	 	char[] sTwo = stringToString(s2).toCharArray();

	 	int keyLength;
	 	
	 	if(sOne.length > sTwo.length)
	 	{
	 		keyLength = sTwo.length;
	 	}
	 	else
	 	{
	 		keyLength = sOne.length;
	 	}
	 	
	 	
	 	for(int i=0; i < keyLength; i++)
	 	{
	 		int oneValue = sOne[i];
	 		int twoValue = sTwo[i];
	 		
	 		if(stringToString(s1).compareTo(stringToString(s2)) == 0)
	 		{
	 			return false;
	 		}
	 		else
	 		{
	 			if(oneValue < twoValue)
		 		{
		 			return true;
		 		}
		 		else
		 		{
		 			if(oneValue > twoValue)
		 			{
		 				return false;
		 			}
		 			else
		 			{
		 				continue;
		 			}
		 		}
	 			
	 		}
	
	 	}
	 		
	 	return true;
	 }
	


}