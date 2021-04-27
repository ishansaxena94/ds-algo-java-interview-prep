package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Aruba
{
    /*

A palindrome is a word, number, phrase, or other sequence of characters which reads the same backward as forward.

Given a string find whether a palindrome can be made out of it or not.

Examples:
madam - True
racecar - True
roseflower - Flase

*/
    public static boolean isPalindrome(String str){

        Map<Character, Integer> map = new HashMap<>();
        char arr[] = str.toCharArray();

        // get freq of each char
        for(char ch : arr){

            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }
            else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        int oddCount = 0;

        for(Map.Entry<Character, Integer> e : map.entrySet()){

            if(e.getValue()%2 != 0){
                oddCount++;
            }
        }

        if(oddCount <= 1)
            return true;
        else return false;
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("roseflower"));
        System.out.println(isPalindrome("racecar!"));
    }
}
