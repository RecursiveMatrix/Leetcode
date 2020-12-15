package greedy;

public class Solution_738 {
    public static void main(String[] args) {
        // Given a non-negative number N, find the biggest integer less than or equal to N so that
        // each digit of this integer, from left to right, increases strictly
        int test = 332;
        System.out.println(monotoneIncreasingDigits(test));

    }

    public static int monotoneIncreasingDigits(int N){
        // 将数字转化成字符串再转化成字符串数组，便于后续操作；
        // 先从前往后遍历，找到开始递减的点；
        // 从该点开始向前遍历，如果前一位比当前为大，那么当前借位
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));

    }
}
