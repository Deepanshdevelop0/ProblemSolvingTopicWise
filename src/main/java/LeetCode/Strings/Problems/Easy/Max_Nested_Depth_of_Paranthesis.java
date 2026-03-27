package LeetCode.Strings.Problems.Easy;

public class Max_Nested_Depth_of_Paranthesis {

    public static void main(String[] args) {
        Max_Nested_Depth_of_Paranthesis classObj = new Max_Nested_Depth_of_Paranthesis();
        System.out.println(classObj.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(classObj.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(classObj.maxDepth("()(())((()()))"));
    }

    public int maxDepth(String s) {

        int maxDepth = 0, depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            else if (c == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}
