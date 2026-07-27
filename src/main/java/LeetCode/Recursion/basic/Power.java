package LeetCode.Recursion.basic;

public class Power {

    public static void main(String[] args) {
        Power classObj = new Power();

        System.out.println("case 1 : " + classObj.myPowRecursive(2.0000, 10));
        System.out.println("case 2 : " + classObj.myPowRecursive(2.0000, -2));
        System.out.println("case 3 : " + classObj.myPowRecursive(2.1000, 3));
        System.out.println("case 4 : " + classObj.myPowRecursive(100.000, 2147483647));
        System.out.println("case 5 : " + classObj.myPowRecursive(2.000, -2147483648));
    }

    public double myPowIterative(double x, int n) {

        long nn = (n < 0) ? (long) n * -1 : (long) n;

        double res = 1.0;

        while (nn > 0) {
            if (nn % 2 == 0) {
                x *= x;
                nn /= 2;
            }
            else {
                res *= x;
                nn -= 1;
            }
        }

        return (n < 0) ? 1 / res : res;
    }

    public double myPowRecursive(double x, int n) {

        long nn = (n < 0) ? (long) n * -1 : (long) n;

        double res = helper(x, nn, 1.0);

        return (n < 0) ? 1.0 / res : res;
    }

    public double helper(double x, long n, double res) {

        if (n == 0) return res;

        if (n % 2 == 0) {
            return helper(x * x, n / 2, res);
        }

        return helper(x, n-1, res * x);
    }


}
