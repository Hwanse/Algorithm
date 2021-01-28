package hwanse.algorithm.recursion;

/**
 * 순환적으로 사고하기.
 * 기존 String 타입에서 기본으로 제공해주는 API 를 순환적 사고 방식으로 구현해보자.
 * 1. 모든 순환함수는 반복문(iteration)으로 변경이 가능
 * 2. 그 역도 성립함. 모든 반복문은 recursion 으로 표현이 가능하다
 * 3. 순환함수는 복잡한 알고리즘을 단순하고 알기 쉽게 표현하는 것을 가능하게 함.
 * 4. 그러나, 함수 호출에 따른 오버헤드가 있다 (매개변수 전달, 액티베이션 프레임 생성 등)
 * +) 경우에 따라 단순 반복문에 비해 실행속도면에서 낮을수도 있음
 */
public class Practice2 {

  /**
   * 각 정의된 재귀 함수들을 실행할 main 메소드.
   * @param args : 실행 arguments.
   */
  public static void main(String[] args) {
    // 1. 문자열 길이 계산
    String text = "abcde";
    System.out.println(length(text));

    // 2. 문자열 프린트
    printChars(text);
    System.out.println();

    // 3. 문자열 역순 출력
    reversePrint(text);
    System.out.println();

    // 4. 숫자를 이진수로 출력
    printBinary(5);
    System.out.println();

    // 5. 배열의 합 구하기
    int[] arr = new int[] {1, 2, 3, 4, 5};
    System.out.println(sum(arr.length, arr));
  }

  /**
   * String 타입의 length 메소드를 사용하지 않고 Recursion 방식으로 문자열 길이 계산하기.
   * @param input : 길이를 계산할 문자열.
   * @return 문자열의 길이 값 반환
   */
  public static int length(String input) {
    if (input.isBlank()) {
      return 0;
    } else {
      return 1 + length(input.substring(1));
    }
  }

  /**
   * 문자열 프린트를 재귀 호출 방식으로 구현.
   * @param str : 콘솔에 출력할 문자열
   */
  public static void printChars(String str) {
    if (str.length() == 0) {
      return;
    } else {
      System.out.print(str.charAt(0));
      printChars(str.substring(1));
    }
  }

  /**
   * 문자열을 역순으로 출력하는 함수를 재귀 방식으로 구현.
   * @param str : 역순으로 출력할 문자열 값.
   */
  public static void reversePrint(String str) {
    if (str.isEmpty()) {
      return;
    } else {
      int length = str.length();
      System.out.print(str.charAt(length - 1));
      reversePrint(str.substring(0, length - 1));
    }
  }

  /**
   * 입력된 숫자를 2진수로 출력하는데 Recursion 방식으로 구현.
   * @param number : 2진수로 출력할 숫자 값
   */
  public static void printBinary(int number) {
    if (number < 2) {
      System.out.print(number);
    } else {
      printBinary(number / 2);
      System.out.print(number % 2);
    }
  }

  /**
   * 배열의 모든 요소를 합하는 sum 함수를 Recursion 방식으로 구현.
   * @param n : 배열의 길이
   * @param arr : 합을 구할 배열
   * @return 배열의 모든 값을 더한 결과 값
   */
  public static int sum(int n, int[] arr) {
    if (n <= 0) {
      return 0;
    } else {
      return sum(n - 1, arr) + arr[n - 1];
    }
  }

}
