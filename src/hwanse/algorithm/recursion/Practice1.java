package hwanse.algorithm.recursion;

/**
 * 재귀 함수에서 무한 루프에 빠지지 않기 위한 조건
 * 1. Base case : 적어도 하나의 recursion 에 빠지지 않는 경우가 존재해야 한다.
 * 2. Recursive case : recursion 을 반복하다보면 결국 base case 로 수렴해야 한다.
 * 또한 순환 함수의 경우 수학적 귀난법과 동일하다. 따라서 순환 함수의 경우에는 문제 풀이시
 * 수학적 귀난법에 의한 구조를 이해하고 있어야 한다.
 */
public class Practice1 {

  public static void main(String[] args) {
    int result = func(4);
    System.out.println(result);
  }

  /**
   * 재귀 함수 테스트.
   *
   * @param n : 인자 값
   * @return 입력받은 인자만큼 상승하여 더하기 연산
   */
  public static int func(int n) {
    if (n <= 0) {
      return 0;
    } else {
      return n + func(n - 1);
    }
  }

}
