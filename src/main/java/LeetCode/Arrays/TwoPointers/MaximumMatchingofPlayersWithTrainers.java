package LeetCode.Arrays.TwoPointers;

import java.util.Arrays;

public class MaximumMatchingofPlayersWithTrainers {

    public static void main(String[] args) {
        MaximumMatchingofPlayersWithTrainers classObj = new MaximumMatchingofPlayersWithTrainers();
        System.out.println(classObj.matchPlayersAndTrainers(new int[]{4,7,9}, new int[]{8,2,5,8}));
        System.out.println(classObj.matchPlayersAndTrainers(new int[]{1,1,1}, new int[]{10}));
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int j = 0, count = 0;

        for (int i = 0; i < trainers.length && j < players.length; i++) {
            if (trainers[i] >= players[j]) {
                j++;
                count++;
            }
        }

        return count;
    }

}
