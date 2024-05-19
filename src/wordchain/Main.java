package wordchain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] n = {3, 5, 2};

        String[][] words = {
                {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
                {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
                {"hello", "one", "even", "never", "now", "world", "draw"}
        };

        int[][] result = {
                {3, 3},
                {0, 0},
                {1, 3}
        };

        Solution solution = new Solution();

        for (int i = 0; i < n.length; i++) {
            assert Arrays.equals(solution.solution(n[i], words[i]), result[i]) : "failed";
        }
    }
}

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        int count = 1;
        // 두번째 사람이 말한 단어부터 검사를 시작하니 number = 2로 설정
        int number = 2;
        Set<String> talkedWords = new HashSet<>();
        talkedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            String previousWord = words[i - 1];

            if (!word.substring(0, 1).equals(previousWord.substring(previousWord.length() - 1))
                    || talkedWords.contains(word)) {
                answer[0] = number;
                answer[1] = count;
                break;
            }

            talkedWords.add(word);

            if (number >= n) {
                number = 1;
                count++;
            } else {
                number++;
            }
        }

        return answer;
    }
}
