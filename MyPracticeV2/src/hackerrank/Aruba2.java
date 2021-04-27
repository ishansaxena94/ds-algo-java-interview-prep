package hackerrank;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.*;

public class Aruba2
{
    /*
  **You're working on configurations and users keeps coming to you with templates that won't run because the braces are off.
  * To provide appropriate error msg to user, you decide to write a braces validator.
    Let's say:

 Write an efficient function that tells us whether or not an input string's braces are balanced and are properly nested.

Examples:



- "{as{}df}" should return `True`
* s {
* s {{
* s
- "{abc}def}" should return `False`
- "}vlan{" should return `False`
*
* - {}[]()
* {{[]()}}
*/

    public static boolean isValid(String str){

        if(str == null || str.isEmpty()){
            return true;
        }

        // {, (, [
        // {as{}df}
        // [ {as{}df} ]
        // (){


        // ch = { , s -> {
        //ch = { , s -> {, {
        //ch = } , s -> {
        //ch = } , s ->

        // }vlan{
        char arr[] = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char ch: arr){

            if(ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else if(ch == ')' || ch == ']' || ch == '}'){

                if(!stack.isEmpty()){

                    if(ch == ')' && stack.peek() == '(')
                    {
                        stack.pop();
                        continue;
                    }
                    else if(ch == ']' && stack.peek() == '[')
                    {
                        stack.pop();
                        continue;
                    }
                    else if(ch == '}' && stack.peek() == '{'){
                        stack.pop();
                        continue;
                    }
                    // ()[}
                    else // (ch == ')' || ch == ']' || ch == '}') && (ch != ')' || ch != ']' || ch != '}')
                        return false;
                    }
                else return false;
                }
            }


        if(!stack.isEmpty())
            return false;
        else return true;


    }

    static void fn(String s){
        switch (s){
            case "Meal_And_Food_Pass":
                System.out.println("HI for " + s );
        }
    }

    public static void main(String[] args)
    {
        if (false)
        {
            System.out.println("Hi");
        }

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .map(e -> e + ", ")
                .reduce("", String::concat);
        System.out.println(result);

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 1000);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        System.out.println(calendar.toString());
//        System.out.println(calendar.getTime());

        Double d = 77570601.070 * 100;
        System.out.println("d = " + d);


        Long l = Double.valueOf(d).longValue();
        System.out.println("l = " + l);

        System.out.println(Long.parseLong( String.format( "%.0f",d ) ) );

        String str1 = "Meal_And_Food_Pass";
        String str2 = "Meal_and_Food_Pass";

        fn(str1);
        fn(str2);



    }
}
