package strings;

public class Anagram {
	
	static int NO_OF_CHARS = 256;
	
	static boolean isAnagram(char[] a, char[] b) {
		
		if(a.length != b.length) return false;
		
		boolean isAnagram = true;
		
		int ca[] = new int[NO_OF_CHARS];
		int cb[] = new int[NO_OF_CHARS];
		
		for(char ele : a) {
			ca[ele]++;
		}
		
		for(char ele: b) {
			cb[ele]++;
		}
		
		for(int i = 0; i<a.length ; i++) {
			if(ca[i] != cb[i]) {
				isAnagram = false;
			}
		}
		
		return isAnagram;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char str1[] = ("geeksforgeeks").toCharArray(); 
        char str2[] = ("forgeeksgeeks").toCharArray(); 
  
        if (isAnagram(str1, str2)) 
            System.out.println("The two strings are"                   
            		+ "anagram of each other"); 
        else
            System.out.println("The two strings are not"
                               + " anagram of each other");
	}

}
