public class StringArray
{
	public static void main(String[] args)
	{
		String input =  "...You...!!!@!3124131212 Hello have this is a --- " +
                    "string Solved !!...? to test @\n\n\n#!#@#@%$**#$@ " +
                    "Congratz this!!!!!!!!!!!!!!!!one ---Problem\n\n";
                    
		int indices[] = {12, -1, 1, -100, 4, 1000, 9, -1000, 16, 13, 17, 15};
		
		String strArray[] = input.split("[^a-zA-Z0-9]+");	
		
		for(int i = 0; i < indices.length; i++)
		{
			if(indices[i] > 0 && indices[i] < strArray.length)
				System.out.print(strArray[indices[i]] + " ");
		}				
	}
}
