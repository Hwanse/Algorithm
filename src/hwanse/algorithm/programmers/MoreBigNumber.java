package hwanse.algorithm.programmers;

public class MoreBigNumber {

  public int solution(final int inputNumber) {
    // 아래와 같은 api 를 사용해서 다른 풀이도 가능
    Integer.bitCount(inputNumber);
    return getBiggerNumber(inputNumber + 1, getCountOfOne(inputNumber));
  }

  public static int getBiggerNumber(int number, int countOfOne) {
    if (countOfOne == getCountOfOne(number)) {
      return number;
    } else {
      return getBiggerNumber(number + 1, countOfOne);
    }
  }

  public static int getCountOfOne(int number) {
    int temp = number;
    int count = 0;

    while (temp > 0) {
      if (temp % 2 == 1) {
        count++;
      }

      temp /= 2;
    }

    return count;
  }

}
