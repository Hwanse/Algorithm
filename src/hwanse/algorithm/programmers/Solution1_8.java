package hwanse.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution1_8 {

  public static void main(String[] args) {
    Solution1_8 solution = new Solution1_8();
    String[] words = new String[] {
        "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
    };

    int[] result = solution.solution(words, 3);
    System.out.println(Arrays.toString(result));
  }

  public int[] solution(String[] words, int n) {
    Rule rule = new Rule();
    Player[] players =  new Player[n];
    Player.createPlayers(players);

    for (int i = 0; i < words.length; i++) {
      int playerIndex = i % n;
      int playerNo = playerIndex + 1;
      String currentWord = words[i];

      if (i > 0 && !rule.checkWordRule(words[i - 1], currentWord)) {
        return new int[] {playerNo, players[playerIndex].getWords().size() + 1};
      }

      rule.addWord(currentWord);
      players[playerIndex].addWord(currentWord);
    }

    return new int[] {0, 0};
  }

}

class Player {
  private List<String> words = new ArrayList<>();

  public static void createPlayers(Player[] players) {
    for (int i = 0; i < players.length; i++) {
      players[i] = new Player();
    }
  }

  public List<String> getWords() {
    return this.words;
  }

  public void addWord(String word) {
    words.add(word);
  }

}

class Rule {
  List<String> beforeWords = new ArrayList<>();

  public boolean checkWordRule(String beforeWord, String currentWord) {
    if (currentWord.length() <= 1 || currentWord.length() > 50) {
      return false;
    } else if (beforeWord.charAt(beforeWord.length()-1) != currentWord.charAt(0)) {
      return false;
    } else if (beforeWords.contains(currentWord)) {
      return false;
    }
    return true;
  }


  public void addWord(String word) {
    beforeWords.add(word);
  }

}
