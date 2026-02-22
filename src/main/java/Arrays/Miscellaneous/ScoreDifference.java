package Arrays.Miscellaneous;

public class ScoreDifference {

    public static void main(String[] args) {
        ScoreDifference classObj = new ScoreDifference();

        System.out.println(classObj.scoreDifference(new int[]{2,4,2,1,2,1}));
    }


    public int scoreDifference(int[] nums) {
        int one = 0, two = 0;
        boolean first = true, second = false;

        for (int i = 0; i < nums.length; i++) {
            int points = nums[i];

            if (i % 5 != 0 && points % 2 != 0) {
                boolean temp = first;
                first = second;
                second = temp;
            }
            else if (i > 0 && i % 5 == 0 && points % 2 == 0) {
                boolean temp = first;
                first = second;
                second = temp;
            }

            if (first) {
                one += points;
            }
            else {
                two += points;
            }
        }

        return one - two;
    }
}
