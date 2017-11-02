/* [2016-12-05] Challenge #294 [Easy] Rack management 1

Today's challenge is inspired by the board game Scrabble. Given a set of 7 letter tiles and a word, 
determine whether you can make the given word using the given tiles. Feel free to format your input 
and output however you like. You don't need to read from your program's input if you don't want to - 
you can just write a function that does the logic. I'm representing a set of tiles as a single string, 
but you can represent it using whatever data structure you want.

Examples:
scrabble("ladilmy", "daily") -> true
scrabble("eerriin", "eerie") -> false
scrabble("orrpgma", "program") -> true
scrabble("orppgma", "program") -> false

Optional Bonus 1:
Handle blank tiles (represented by "?"). These are "wild card" tiles that can stand in for any single 
letter.
scrabble("pizza??", "pizzazz") -> true
scrabble("piizza?", "pizzazz") -> false
scrabble("a??????", "program") -> true
scrabble("b??????", "program") -> false

*/

public class RackManagement1
{
	public static void main(String[] args)
	{
		System.out.println(scrabble("ladilmy", "daily"));
		System.out.println(scrabble("eerriin", "eerie"));
		System.out.println(scrabble("orrpgma", "program"));
		System.out.println(scrabble("orppgma", "program"));	
		
		System.out.println(scrabble("pizza??", "pizzazz"));
		System.out.println(scrabble("piizza?", "pizzazz"));	
		System.out.println(scrabble("a??????", "program"));	
		System.out.println(scrabble("b??????", "program"));	
	}
	
	public static boolean scrabble(String input, String word)
	{
		if(word.length() > input.length())
			return false;
				
		char inputArray[] = input.toCharArray();
		char wordArray[] = word.toCharArray();
		
		
		for(int i = 0; i < word.length(); i++)
		{
			boolean found = false;	
			for(int j = i; j < input.length(); j++)
			{
				if(wordArray[i] == inputArray[j])
				{
					found = true;
					char temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
					break;
				}
			}
			if(!found) 
			{				// search for "?"
				for(int j = i; j < input.length(); j++)
				{
					if(inputArray[j] == '?')
					{
						found = true;
						char temp = inputArray[i];
						inputArray[i] = inputArray[j];
						inputArray[j] = temp;
						break;
					}
				}
				if(!found) return false;
			}
		}	
		return true;
	}
}
