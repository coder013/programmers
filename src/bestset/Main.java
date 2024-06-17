package bestset;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] n = {2, 2, 2, 4};
        int[] s = {9, 1, 8, 11};

        int[][] result = {
                {4, 5},
                {-1},
                {4, 4},
                {2, 3, 3, 3}
        };

        Solution solution = new Solution();

        for (int i = 0; i < n.length; i++) {
            assert Arrays.equals(solution.solution(n[i], s[i]), result[i]) : "failed";
        }
    }
}

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        Arrays.fill(answer, s / n);

        int remainder = s % n;

        for (int i = 1; i <= remainder; i ++) {
            answer[n - i] = answer[n - i] + 1;
        }

        return answer;
    }
}
