package LeetCode.Strings.Problems;

public class Validate_IP_Address {


    public static void main(String[] args) {
        Validate_IP_Address classObj = new Validate_IP_Address();

        // IPv4 address
//        String queryIP = "256.256.256.256";
//        String queryIP = "192.156.0.1";
        String queryIP = "+1.0.0.0";
//        String queryIP = "172.16.254.1";

        // IPv6 address
//        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334";


        System.out.println(classObj.validIPAddress(queryIP));

    }

    public String validIPAddress(String queryIP) {
        return (checkIfIpv4(queryIP)) ? "IPv4"
                : (checkIfIpv6(queryIP)) ? "IPv6"
                : "Neither";
    }

    /* Better for interview constraints, handles cases with input having signs. This approach validates each character. */
    /* Ip : "+1.0.0.0" */
    public boolean checkIfIpv4(String queryIP) {
        String[] arr = queryIP.split("\\.", -1);
        if (arr.length != 4) {
            return false;
        }

        for (String str : arr) {
            int len = str.length();
            if (len == 0 || len > 3) return false;
            if (str.charAt(0) == '0' && str.length() > 1) return false;

            int num = 0;
            for (char ch : str.toCharArray()) {
                if (ch < '0' || ch > '9') {
                    return false;
                }
                num = num * 10 + (ch - '0');
            }

            if (num > 255) {
                return false;
            }
        }

        return true;
    }


    public boolean checkIfIpv6(String queryIP) {
        String[] arr = queryIP.split(":", -1);
        if (arr.length != 8) {
            return false;
        }

        for (String str : arr) {
            int len = str.length();
            if (len == 0 || len > 4) {
                return false;
            }

            for (char ch : str.toCharArray()) {
                boolean isHex = (ch >= '0' && ch <= '9')
                        || (ch >= 'a' && ch <= 'f')
                        || (ch >= 'A' && ch <= 'F');

                if (!isHex) return false;
            }

        }

        return true;
    }

}
