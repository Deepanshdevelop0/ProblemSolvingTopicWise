package Arrays.matrix;

public class maximumNumber69 {

    public static void main(String[] args) {
        int num = 996996;

        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number (int num) {

        int n = (int) Math.log10(num);

        int divisible = (int) Math.pow(10, n);

        for (int i = 0; i <= n; i++) {

            int n1 = (num / divisible) % 10;

            if (n1 < 9) {
                num += ((9 - n1) * divisible);
                return num;
            }

            divisible /= 10;
        }

        return num;
    }


}
