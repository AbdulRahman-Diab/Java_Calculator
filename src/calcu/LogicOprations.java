package calcu;

public class LogicOprations {

    public static String logicNOT(String binaryNums) {
        String Ans = "";
        int size = binaryNums.length();
        for (int i = 0; i < size; i++) {
            switch (binaryNums.charAt(i)) {
                case '0':
                    Ans += "1";
                    break;
                case '1':
                    Ans += "0";
                    break;
                default:
                    return null;
            }
        }
        return Ans;
    }

    public static String logicOR(String... binaryNums) {
        binaryNums = completWithZero(binaryNums);
        String Ans;
        if (check(binaryNums[0])) {
            Ans = binaryNums[0];
        } else {
            return null;
        }
        for (int i = 1; i < binaryNums.length; i++) {
            if (check(binaryNums[i])) {
                Ans = logicOR2num(Ans, binaryNums[i]);
            } else {
                return null;
            }
        }
        return Ans;
    }

    public static String logicAND(String... binaryNums) {
        binaryNums = completWithZero(binaryNums);

        String Ans;
        if (check(binaryNums[0])) {
            Ans = binaryNums[0];
        } else {
            return null;
        }

        for (int i = 1; i < binaryNums.length; i++) {
            if (check(binaryNums[i])) {
                Ans = logicAND2num(Ans, binaryNums[i]);
            } else {
                return null;
            }
        }
        return Ans;
    }

    public static String logicNOR(String... binaryNums) {
        return logicNOT(logicOR(binaryNums));
    }

    public static String logicNAND(String... binaryNums) {
        return logicNOT(logicAND(binaryNums));
    }

    public static String logicXOR(String... binaryNums) {
        binaryNums = completWithZero(binaryNums);
        String Ans;
        if (check(binaryNums[0])) {
            Ans = binaryNums[0];
        } else {
            return null;
        }
        for (int i = 1; i < binaryNums.length; i++) {
            if (check(binaryNums[i])) {
                Ans = logicXOR2num(Ans, binaryNums[i]);
            } else {
                return null;
            }
        }
        return Ans;
    }

    public static String logicXAND(String... binaryNums) {
        binaryNums = completWithZero(binaryNums);
        String Ans;
        if (check(binaryNums[0])) {
            Ans = binaryNums[0];
        } else {
            return null;
        }
        for (int i = 1; i < binaryNums.length; i++) {
            if (check(binaryNums[i])) {
                Ans = logicXAND2num(Ans, binaryNums[i]);
            } else {
                return null;
            }
        }
        return Ans;
    }

    private static String logicOR2num(String binaryNum1, String binaryNum2) {
        String Ans = "";

        for (int index = 0; index < binaryNum1.length(); index++) {
            if (binaryNum1.charAt(index) == '1' || binaryNum2.charAt(index) == '1') {
                Ans += '1';
            } else {
                Ans += '0';
            }
        }
        return Ans;
    }

    private static String logicAND2num(String binaryNum1, String binaryNum2) {
        String Ans = "";
        for (int index = 0; index < binaryNum1.length(); index++) {
            if (binaryNum1.charAt(index) == '0' || binaryNum2.charAt(index) == '0') {
                Ans += '0';
            } else {
                Ans += '1';
            }
        }
        return Ans;
    }

    private static String logicXOR2num(String binaryNum1, String binaryNum2) {
        String Ans = "";
        for (int index = 0; index < binaryNum1.length(); index++) {
            if ((binaryNum1.charAt(index) == '0' && binaryNum2.charAt(index) == '1') || (binaryNum1.charAt(index) == '1' && binaryNum2.charAt(index) == '0')) {
                Ans += '1';
            } else {
                Ans += '0';
            }
        }
        return Ans;
    }

    private static String logicXAND2num(String binaryNum1, String binaryNum2) {
        String Ans = "";
        for (int index = 0; index < binaryNum1.length(); index++) {
            if ((binaryNum1.charAt(index) == '0' && binaryNum2.charAt(index) == '0') || (binaryNum1.charAt(index) == '1' && binaryNum2.charAt(index) == '1')) {
                Ans += '1';
            } else {
                Ans += '0';
            }
        }
        return Ans;
    }

    private static String[] completWithZero(String... pNums) {
        int maxSize = 0;
        for (int i = 0; i < pNums.length; i++) {
            pNums[i] = revarsStr(pNums[i]);
            if (pNums[i].length() > maxSize) {
                maxSize = pNums[i].length();
            }
        }
        for (int i = 0; i < pNums.length; i++) {
            for (int j = pNums[i].length(); j < maxSize; j++) {
                pNums[i] += '0';
            }
        }
        for (int i = 0; i < pNums.length; i++) {
            pNums[i] = revarsStr(pNums[i]);
        }
        return pNums;
    }

    private static String revarsStr(String str) {
        int size = str.length();
        String strRevars = "";
        for (int i = size - 1; i >= 0; i--) {
            strRevars += str.charAt(i);
        }
        return strRevars;
    }

    private static boolean check(String str) {
        int size = str.length();
        for (int index = 0; index < size; index++) {
            if (str.charAt(index) != '0' && str.charAt(index) != '1') {
                return false;
            }
        }
        return true;
    }

}
