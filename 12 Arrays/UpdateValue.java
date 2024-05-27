// package 12 Arrays;

import java.util.*;

public class UpdateValue {

    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i]++;
        }

        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int marks[] = {10, 20, 30};
        update(marks);

        input.close();
    }
}
