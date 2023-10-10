package utility.Luhn;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

import static utility.Luhn.LuhnValidation.isValidCreditCardNumbers;

public class LuhnGeneration {


    public static void main(String[] args) {

        String num = GenerateNewLuhnNumber();
        System.out.println("New Luhn Number :: " + num);

        boolean validCreditCardNumber = isValidCreditCardNumbers(num);

        if (validCreditCardNumber) {
            System.out.println("New Luhn Number :: " + num);
        }
    }


    public static final String[] PREFIX_LIST = new String[] { "04" };

    static String strrev(String str) {
        if (str == null)
            return "";
        String revstr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revstr += str.charAt(i);
        }

        return revstr;
    }

    static String completed_number(String prefix, int length)
    {

        String ccnumber = prefix;

        while (ccnumber.length() < (length - 1)) {
            ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
        }

        String reversedCCnumberString = strrev(ccnumber);

        List<Integer> reversedCCnumberList = new Vector<Integer>();
        for (int i = 0; i < reversedCCnumberString.length(); i++) {
            reversedCCnumberList.add(new Integer(String
                    .valueOf(reversedCCnumberString.charAt(i))));
        }

        int sum = 0;
        int pos = 0;

        Integer[] reversedCCnumber = reversedCCnumberList
                .toArray(new Integer[reversedCCnumberList.size()]);
        while (pos < length - 1) {

            int odd = reversedCCnumber[pos] * 2;
            if (odd > 9) {
                odd -= 9;
            }

            sum += odd;

            if (pos != (length - 2)) {
                sum += reversedCCnumber[pos + 1];
            }
            pos += 2;
        }

        int checkdigit = new Double(
                ((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
        ccnumber += checkdigit;

        return ccnumber;

    }

    public static String[] credit_card_number(String[] prefixList, int length,int howMany)
    {

        Stack<String> result = new Stack<String>();
        for (int i = 0; i < howMany; i++) {
            int randomArrayIndex = (int) Math.floor(Math.random()
                    * prefixList.length);
            String ccnumber = prefixList[randomArrayIndex];
            result.push(completed_number(ccnumber, length));
        }

        return result.toArray(new String[result.size()]);
    }

    public static String[] generateMasterCardNumbers(int howMany) {
        return credit_card_number(PREFIX_LIST, 16, howMany);
    }

    public static String GenerateNewLuhnNumber() {
        return credit_card_number(PREFIX_LIST, 11, 2)[0];
    }
}