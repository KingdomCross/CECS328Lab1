
//import java.util.ArrayList;
import java.util.Scanner;

public class ModifiedInsertionSort 
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Enter a string of words: ");
		String[] words = console.nextLine().split("\\s+");
		String key = "";
		int counter = 0;
		
		// Starts the sorting here (BASIC SORTING NEED TO MODIFY)
		/**
		 * i starts at 1 because we want the key to start at position 1 not position 0.
		 * j will be the word that will be compared to the initial key.
		 */
		for(int i = 1; i < words.length; ++i)
		{
			key = words[i];
			//String key = words[i].substring(0, words[i].length() - 1);
			int j = i - 1;
		
			
			/**
			 * While position j is greater...
			 */
			while(j >= 0 && words[j].substring(0, words[j].length() - 1).compareTo(words[i].substring(0, words[i].length() - 1)) > 0)
			{
				words[j + 1] =  words[j];
				j = j - 1;
				counter++;
				System.out.println(words[j] + " " + counter);
			}
			if (words[j].substring(0, words[j].length() - 1).compareTo(words[i].substring(0, words[i].length() - 1)) == 0)
			{
				counter++;
			}
			//System.out.println(words[j] + " " + counter);
			words[j + 1] = key;
			counter = 0;
		}
		
		// prints all the words in array
		for (int i = 0; i < words.length; i++)
		{
			System.out.println(words[i]);
		}
		
		console.close();
		
		//System.out.println("array is of size = " + words.length); // testing
	}
}

/*// old method
Scanner console = new Scanner(System.in);
ArrayList<String> list = new ArrayList<>();
boolean quit = false;
while (quit != true)
{
	System.out.print("Enter words: ");
	list.add(console.nextLine());
	
	System.out.print("Done? [y/n]: ");
	if(console.nextLine().equals("y"))
	{
		console.close();
		quit = true;
	}
}
System.out.println(list);
*/
