package LeetCode.BitManipulation.problems;

public class Binary_Digit_Score {

    public static void main(String[] args) {
        Binary_Digit_Score classObj = new Binary_Digit_Score();
        int res = classObj.calculateScore(14, 6);
        System.out.println(res);
    }

    public int calculateScore(int a, int b) {
        int s1 = Integer.bitCount(a);
        int s2 = Integer.bitCount(b);

        return (s1 >= s2) ? s1 * s2 : s2 / s1;
    }

}
