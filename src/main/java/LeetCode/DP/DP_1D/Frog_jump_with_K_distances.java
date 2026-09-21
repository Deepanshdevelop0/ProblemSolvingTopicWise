package LeetCode.DP.DP_1D;


public class Frog_jump_with_K_distances {

    public static void main(String[] args) {

        Frog_jump_with_K_distances frogJumpWithKDistances = new Frog_jump_with_K_distances();

        int[] heights = new int[]{10, 5, 20, 0, 15};
        int[] heights1 = new int[]{15, 4, 1, 14, 15};
        System.out.println(frogJumpWithKDistances.frogJump(heights, 2));

    }

    public int frogJump(int[] heights, int k) {

        int min = Integer.MAX_VALUE;

//        for (int i = 1; i < heights.length && i <= k; i++) {
//            min = Math.min(min, jumpRecursive(heights, k, i));
//        }

        return jumpRecursive(heights, k, 0);
    }

    public int jumpRecursive(int[] heights, int k, int indx) {
        if (indx == heights.length - 1) {
            return heights[indx];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k && indx+i < heights.length; i++) {
            int next = jumpRecursive(heights, k, indx+i);
            min = Math.min(min, Math.abs(heights[indx] - next));
        }

        return min;
    }

}
