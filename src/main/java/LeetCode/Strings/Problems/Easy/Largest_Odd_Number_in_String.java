package LeetCode.Strings.Problems.Easy;

public class Largest_Odd_Number_in_String {

    public static void main(String[] args) {
        Largest_Odd_Number_in_String classObj = new Largest_Odd_Number_in_String();
        System.out.println(classObj.largestOddNumber("35427"));
        System.out.println(classObj.largestOddNumber("35472"));
        System.out.println(classObj.largestOddNumber("10133890"));
        System.out.println(classObj.largestOddNumber("10133800"));
        System.out.println(classObj.largestOddNumber("239537672423884969653287101"));
    }

    public String largestOddNumber(String num) {

        for (int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0';
            if (n % 2 != 0) {
                return num.substring(0, i+1);
            }
        }

        return "";
    }

}
