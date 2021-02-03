package hwanse.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class EnglishEndingWords {

  public int[] solution(String[] words, int n) {
    Rule rule = new Rule();
    Player[] players = Player.createPlayers(n);

    for (int i = 0; i < words.length; i++) {
      int playerIndex = i % n;
      int playerNo = playerIndex + 1;
      String currentWord = words[i];


      if (!rule.checkWordRule(currentWord)) {
        return new int[] {playerNo, players[playerIndex].getCurrentTurn()};
      }

      rule.addWord(currentWord);
      players[playerIndex].addWord(currentWord);

    }

    return new int[] {0, 0};
  }

}

class Player {

  private List<String> words = new ArrayList<>();

  public static Player[] createPlayers(int countOfPlayer) {
    Player[] players = new Player[countOfPlayer];

    for (int i = 0; i < countOfPlayer; i++) {
      players[i] = new Player();
    }

    return players;
  }

  public int getCurrentTurn() {
    return words.size() + 1;
  }

  public void addWord(String word) {
    words.add(word);
  }

}

class Rule {
  List<String> beforeWords = new ArrayList<>();

  public boolean checkWordRule(String currentWord) {

    if (beforeWords.size() >= 2){
      String beforeWord = beforeWords.get(beforeWords.size() - 1);

      if (beforeWords.contains(currentWord)) {
        return false;
      } else if (beforeWord.charAt(beforeWord.length() - 1) != currentWord.charAt(0)) {
        return false;
      }
    }

    return true;
  }

  public void addWord(String word) {
    beforeWords.add(word);
  }

}

