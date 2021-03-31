package strings;

public class RomanToDecimal {

	static int value(char alpha) {

		switch (alpha) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}
	
	static void romanToDecimal(String numeral) {
		
		int result = 0;
		char s1, s2;
		int val1, val2;
		int len = numeral.length();
		
		char arr[] = numeral.toCharArray();
		
		for(int i = 0; i < len; i++) {
			
			s1 = arr[i];
			
			if(i + 1  < len) {
				s2 = arr[i + 1];
				
				val1 = value(s1);
				val2 = value(s2);
				
				if(val1 < val2) {
					result += val2 - val1;
					i++;
				}
				else {
					result += val1;
				}
			}
			else {
				val1 = value(arr[i]);
				result += val1;
			}
			
			val1 = 0;
			val2 = 0;
		}
		
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "MCMIV"; 
        System.out.println("Integer form of Roman Numeral" + 
                           " is ");
        romanToDecimal(str);
	}

}
