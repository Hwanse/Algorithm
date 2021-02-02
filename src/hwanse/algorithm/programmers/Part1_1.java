package hwanse.algorithm.programmers;

public class Part1_1 {

  public static void main(String[] args) {
    Part1_1 sol = new Part1_1();
    System.out.println(sol.solution(11));
  }

  public boolean solution(int x) {
    int originalNum = x;
    int sum = 0;

    while (x > 0) {
      sum += (x % 10);
      x /= 10;
    }

    return (originalNum % sum) == 0;
  }

}
