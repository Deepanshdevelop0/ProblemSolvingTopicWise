package Arrays.Miscellaneous;

public class MirrorDistanceofAnInteger {

    public static void main(String[] args) {
        MirrorDistanceofAnInteger classObj = new MirrorDistanceofAnInteger();
        int res = classObj.mirrorDistance(25);

        System.out.println(res);
    }

    public int mirrorDistance(int n) {

        int reverse = 0, temp = n;

        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }

        return Math.abs(n - reverse);
    }


}
