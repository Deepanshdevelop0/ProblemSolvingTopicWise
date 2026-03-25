package LeetCode.Strings.Problems.Easy;

public class Remove_Outermost_Paranthesis {

    public static void main(String[] args) {
        Remove_Outermost_Paranthesis classObj = new Remove_Outermost_Paranthesis();
        System.out.println(classObj.removeOuterParentheses("(()())(())"));
        System.out.println(classObj.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(classObj.removeOuterParentheses("()()"));
    }

    public String removeOuterParentheses(String s) {
        char[] charr = s.toCharArray();

        int init = 0, track = 0;
        String res = "";

        for (int i = 0; i < charr.length; i++) {
            if (charr[i] == '(') {
                track++;
            }
            else {
                track--;
                if (track == 0) {
                    res += s.substring(init + 1, i);
                    init = i+1;
                }
            }
        }

        return res;
    }

}
