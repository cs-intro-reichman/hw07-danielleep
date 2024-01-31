

public class HashTagTokenizer {

	public static void main(String[] args) 
	{

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) 
	{
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for(int i=0; i<dictionary.length;i++)
		{
			dictionary[i]=in.readLine();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) 
	{
		for(int i=0; i<dictionary.length; i++)
		{
			if(dictionary[i].equals(word))
			{
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) 
	{

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) 
		{
            return;
        }
		hashtag.toLowerCase();
        int N = hashtag.length();
		String a;
		String b;

        for (int i = 1; i <= N; i++) 
		{
			a=hashtag.substring(0, i);
			if(existInDictionary(a, dictionary))
			{
				System.out.println(a);
				b=hashtag.substring(i,N);
				breakHashTag(b, dictionary);
				return;
			}
        }
    }
}
