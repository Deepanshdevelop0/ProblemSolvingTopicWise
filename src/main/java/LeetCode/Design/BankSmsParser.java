package LeetCode.Design;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BankSmsParser {



        // Regex to find the amount (e.g., INR 5,000.00 or Rs 500)
        private static final String AMOUNT_REGEX = "(?i)(?:INR|Rs\\.?)\\s*([0-9,]+(?:\\.[0-9]{2})?)";

        // Keywords to identify transaction type
        private static final String CREDIT_REGEX = "(?i)(credited|received|deposit)";
        private static final String DEBIT_REGEX = "(?i)(debited|spent|withdrawn|withdrawal|withdrawal)";

        public static void parseSms(String sms) {
            System.out.println("Processing: " + sms);

            String type = "UNKNOWN";
            String amount = "0.00";

            // Identify Type
            if (Pattern.compile(CREDIT_REGEX).matcher(sms).find()) {
                type = "CREDIT";
            } else if (Pattern.compile(DEBIT_REGEX).matcher(sms).find()) {
                type = "DEBIT";
            }

            // Extract Amount
            Matcher amountMatcher = Pattern.compile(AMOUNT_REGEX).matcher(sms);
            if (amountMatcher.find()) {
                amount = amountMatcher.group(1);
            }

            System.out.println("Result -> Type: " + type + " | Amount: " + amount);
            System.out.println("---------------------------------------------------");
        }

        public static void main(String[] args) {
            String[] messages = {
                    "INR 5,000.00 was debited from A/c XX1234 on 25-Feb-26 at ATM/POS.",
                    "ALERT: INR 1,500.00 spent on card xx5678 at MERCH-XYZ.",
                    "Your A/c XX1234 is credited with INR 50,000.00 on 01-Mar-26.",
                    "Amount INR 2,000.00 received in A/c XX1234 via UPI.",
                    "An amount of INR 2,000.00 has been credited to XXXX2066 on 2/25/26",
                    "Your Account no. has been credited with Rs.2,000.00 on 2/25/26 8:26 PM from a/c no 2271",
                    "Your Account no. has been credited with Rs.200.00 on 2/25/26 8:26 PM from a/c no 2271"
            };

            for (String msg : messages) {
                parseSms(msg);
            }
        }

}
