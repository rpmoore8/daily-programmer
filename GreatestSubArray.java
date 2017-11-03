/* [3/27/2012] Challenge #31 [difficult]

In this challenge, given an array of integers, the goal is to efficiently find the subarray 
that has the greatest value when all of its elements are summed together. Note that because 
some elements of the array may be negative, the problem is not solved by simply picking the 
start and end elements of the array to be the subarrray, and summing the entire array. 

For example, given the array {1, 2, -5, 4, -3, 2}
The maximum sum of a subarray is 4. It is possible for the subarray to be zero elements in 
length (if every element of the array were negative). Try to come up with an efficient algorithm!
*/

public class GreatestSubarray
{
	public static void main(String[] args)
	{
		int[] testArray = {1, 2, -5, 4, -3, 2};		
		int [] subArray = greatestSub(testArray);
		printIntArray(subArray);
		
		int[] testArray2 = {1, 2, -5, 1, -3};		
		int [] subArray2 = greatestSub(testArray2);
		printIntArray(subArray2);
		
		int[] testArray3 = {-1, -2, -5, -1, -3};		
		int [] subArray3 = greatestSub(testArray3);
		printIntArray(subArray3);
				
		
		int[] testArray4 = {1, 2, 5, 1, 3};		
		int [] subArray4 = greatestSub(testArray4);
		printIntArray(subArray4);
		
	}
	
	public static int[] greatestSub(int[] input)
	{	
		int greatestSum = 0;
		int greatestSumStart = 0;
		int greatestSumEnd = 0;
		
		int tempSum = 0;
		int tempSumStart = 0;
		int tempSumEnd = 0;
		
		for(int i = 0; i < input.length; i++)
		{
			if(input[i] > 0)
			{
				tempSumEnd = i;
				tempSum =+ input[i];
			}
			else
			{
				if(tempSum > greatestSum)
				{
					greatestSum = tempSum;
					greatestSumStart = tempSumStart;
					greatestSumEnd = tempSumEnd;
				}
				if((tempSum + input[i]) > 0)
				{
					tempSumEnd = i;
					tempSum =+ input[i];
				}
				else
				{
					tempSum = 0;
					tempSumStart = i + 1;
					tempSumEnd = i + 1;
				}		
			}
		}
		
		if(tempSum > greatestSum)
		{
			greatestSum = tempSum;
			greatestSumStart = tempSumStart;
			greatestSumEnd = tempSumEnd;
		}
		
		if(greatestSum == 0) // all negatives
		{
			int[] empty = new int[0];
			return empty;
		}
		
		int outputLength = greatestSumEnd - greatestSumStart + 1;
		int[] output = new int[outputLength];
				
		for(int i = 0; i < outputLength; i++)
			output[i] = input[i + greatestSumStart];
		
		return output;
	}
	
	public static void printIntArray(int[] input)
	{	
		if(input.length == 0)
			System.out.println("()");
		else
		{
			System.out.print("(");
			for(int i = 0; i < (input.length - 1); i++)
				System.out.print(input[i] + ", ");
			System.out.println(input[(input.length - 1)] + ")");
		}
	}
}
