import java.util.*;

public class UppercaseFirstLetter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String str = input.nextLine();

        StringBuilder strNew = new StringBuilder(str);
        char ch = Character.toUpperCase(str.charAt(0));
        strNew.append(ch);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                strNew.append(str.charAt(i));
                i++;
                strNew.append(Character.toUpperCase(str.charAt(i)));                
            }

            else{
                strNew.append(str.charAt(i));
            }
        }

        System.out.println(strNew.toString());

        input.close();
    }
}
