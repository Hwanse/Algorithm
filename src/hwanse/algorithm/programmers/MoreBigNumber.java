package hwanse.algorithm.programmers;

public class MoreBigNumber {

  public int solution(final int inputNumber) {
    // 아래와 같은 api 를 사용해서 다른 풀이도 가능
    Integer.bitCount(inputNumber);

    int oneCount = countOneOfBinary(inputNumber);
    int biggerNumber = inputNumber;

    while (true) {
      if (oneCount == countOneOfBinary(++biggerNumber)) {
        break;
      }
    }

    return biggerNumber;
  }

  int countOneOfBinary(int number) {
    int temp = number;
    int count = 0;

    while (temp > 0) {
      count += (temp & 1);
      temp >>= 1;
    }

    return count;
  }

}
