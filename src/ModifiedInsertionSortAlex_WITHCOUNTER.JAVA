import java.util.Scanner;

public class ModifiedInsertionSort {
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

    public static void InsertionSortImperative(String[] arr)
    {
    	String sortedArray[] = arr.clone();
    	String tempArray[] = arr.clone();
    	int[] counter = new int[arr.length];
    	
    	for(int y = 0; y<arr.length; y++)
        {

            counter[y] = 0;
        }
    	
    	
        for (int i = 1; i < arr.length; i++)
        {
            String key = arr[i];
            int j = i - 1;
            
            boolean flag = false;
            
            while (j >= 0 && CharKeyCompare(arr, j, key))
            {

            	System.out.println(CharKeyCompare(arr, j, key));
            	
            	arr[j + 1] = arr[j];
            	j = j - 1;
            	counter[i]++;

            }

            arr[j + 1] = key;
        }
        
        for (int i = 1; i < tempArray.length; i++)
        {
            String key = tempArray[i];
            int j = i - 1;


            while (j >= 0 && CharKeyCompare(tempArray, j, key)==false)
            {

            	System.out.println(CharKeyCompare(tempArray, j, key));
            	
            	tempArray[j + 1] = tempArray[j];
            	j = j - 1;
            	counter[i]++;
            	break;
            }

            tempArray[j + 1] = key;
        }
        
        
        PrintArray(arr);
        System.out.println( " ");
        
        for(int x = 1;x<arr.length;x++)
        {

            System.out.print(sortedArray[x] + " ");
            System.out.println(counter[x]);
        }
    }

    public static void PrintArray(String[] arr){
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
