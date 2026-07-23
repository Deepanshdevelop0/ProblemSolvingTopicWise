package LeetCode.Recursion.basic;

public class String_to_Integer_atoi {

    public static void main(String[] args) {
        String_to_Integer_atoi classObj = new String_to_Integer_atoi();

        System.out.println("case 1 : " + classObj.myAtoi("  --42"));
        System.out.println("case 2 : " + classObj.myAtoi("42"));
        System.out.println("case 2 : " + classObj.myAtoi("+-42"));
        System.out.println("case 2 : " + classObj.myAtoi("42w8957298"));

    }

    public int myAtoi(String s) {

        int i = 0, len = s.length();

        while (i < len && s.charAt(i) == ' ') {
            i++;
        }

        if (i >= len) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        int res = 0;
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            /*
             * Prevent integer overflow before appending the next digit.
             * Integer.MAX_VALUE is 2,147,483,647.
             * - Left side: If res is > 214748364, then res * 10 will definitely overflow.
             * - Right side: If res == 214748364, then adding a digit > 7 will overflow.
             */
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return sign * res;
    }


}
