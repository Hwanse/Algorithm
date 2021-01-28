package hwanse.algorithm.recursion;

/**
 * 백트래킹(Backtracking)
 * 상태공간 트리를 깊이 우선 방식으로 탐색하여 해를 찾는 알고리즘
 * 깊이 우선 탐색을 구현하는 방법 대표적인 2가지
 * 1. Recursion
 * 2. Stack
 */
public class NQueens {

  private static final int SIZE = 4;
  private static final int[] cols = new int[SIZE + 1];

  public static void main(String[] args) {
    queens(0);
  }

  /**
   * base case
   * 1. 해당 노드(level) 위치에 퀸을 놓을 수 없을 경우 false
   * 2. 위 조건을 수렴하고 동시에 마지막 level 의 노드일경우 true
   * recursive case
   * 1. 1번의 base case 를 수렴했을 경우 다음 퀸을 위치할 다음 level 의 노드 탐색
   * 2. 다음 level 에서 위 조건들을 만족하지 못 할 경우 다시 이전 level 로 복귀하여
   *    다음 열의 노드로 이동하여 탐색을 진행
   * @param level 퀸이 위치할 노드 정보
   * @return 위 모든 조건을 수렴할 경우 true 반환
   */
  public static boolean queens(int level) {
    if (!promising(level)) {
      return false;
    } else if (level == SIZE) {
      for (int i = 1; i <= SIZE; i++) {
        System.out.println("(" + i + ", " + cols[i] + ")");
      }
      return true;
    }

    for (int i = 1; i <= SIZE; i++) {
      cols[level + 1] = i;
      if (queens(level + 1)) {
        return true;
      }
    }

    return false;
  }

  /**
   * 다음 level 에 퀸이 놓을 수 있는지 없는지에 대한 여부를 판별
   * 1. 모든 퀸은 같은 열에 위치 하면 안된다.
   * 2. 같은 대각선 라인에도 놓여 있으면 안된다.
   * @param level 다음 퀸이 위치할 노드의 위치
   * @return 위 조건을 모두 수렴할 경우 해당 노드에 퀸을 놓는다.
   */
  public static boolean promising(int level) {
    for (int i = 1; i < level; i++) {
      if (cols[i] == cols[level]) { // 같은 열에 놓여있는지 검사
        return false;
      } else if (level - i == Math.abs(cols[level] - cols[i])) {  // 같은 대각선의 놓였는지 검사
        return false;
      }
    }
    return true;
  }

}
