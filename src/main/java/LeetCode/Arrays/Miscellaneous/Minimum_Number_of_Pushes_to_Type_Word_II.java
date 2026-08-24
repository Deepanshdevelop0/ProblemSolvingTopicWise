package LeetCode.Arrays.Miscellaneous;

import java.util.*;
import java.util.stream.Collectors;

public class Minimum_Number_of_Pushes_to_Type_Word_II {

    public static void main(String[] args) {
        Minimum_Number_of_Pushes_to_Type_Word_II classObj = new Minimum_Number_of_Pushes_to_Type_Word_II();
//        System.out.println(classObj.minimumPushes("aabbccddeeffgghhiiiiii"));

        System.out.println("test case : " + classObj.minimumPushes("abzaqsqcyrbzsrvamylmyxdjl"));
    }

    public int minimumPushes(String word) {
        int res = 0;

        int[] chaArr = new int[26];

        for (char ch : word.toCharArray()) {
            chaArr[ch - 'a']++;
        }

        Arrays.sort(chaArr);

        for (int i = 25; i >= 0; i--) {
            if(chaArr[i] == 0) break;
            res += chaArr[i] * ( ((25-i) / 8) + 1);
        }

        return res;
    }

}
