import java.util.*;

public class PermutationOfString {

    public static void findPermutation(String str, String ans) {
        //Base case
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        //Recursion
        for (int i = 0; i < str.length(); i++) {    //To take choices for each character at every step
            char curr = str.charAt(i);
            //Adding the character to the new string. But before that we have to remove it from the actual string so that further child levels do not have access to that character
            String newStr = str.substring(0, i) + str.substring(i + 1);      //Modified str does not contain the character at ith position.
            findPermutation(newStr, ans + curr);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String str = "abc";
        String ans = "";
        findPermutation(str, ans);
        
        input.close();
    }
}