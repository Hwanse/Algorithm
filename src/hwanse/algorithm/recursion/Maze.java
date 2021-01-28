package hwanse.algorithm.recursion;

/**
 * 미로 찾기 문제를 Recursion 방식으로 해결해보기.
 *
 */
public class Maze {

  private static int N = 8;
  private static int [][] maze = {
      {0, 0, 0, 0, 0, 0, 0, 1},
      {0, 1, 1, 0, 1, 1, 0, 1},
      {0, 0, 0, 1, 0, 0, 0, 1},
      {0, 1, 0, 0, 1, 1, 0, 0},
      {0, 1, 1, 1, 0, 0, 1, 1},
      {0, 1, 0, 0, 0, 1, 0, 1},
      {0, 0, 0, 1, 0, 0, 0, 1},
      {0, 1, 1, 1, 0, 1, 0, 0}
  };

  private static final int PATHWAY_COLOR = 0;   // white - 아직 가지 않은 경로
  private static final int WALL_COLOR = 1;      // blue - 벽
  private static final int BLOCKED_COLOR = 2;   // red - 이미 방문했지만 출구가 없는 경로
  private static final int PATH_COLOR = 3;      // green - 벙뮨했지만 출구의 여부가 미지수인 경로


  public static void main(String[] args) {
    printMaze();
    findMazePath(0, 0);
    printMaze();
  }

  /**
   * 춫구를 탐색
   * @param x  x축
   * @param y  y축
   * @return  탐색 결과
   */
  public static boolean findMazePath(int x, int y) {
    if(x < 0 || y < 0 || x >= N || y >= N) {
      return false;
    } else if (maze[x][y] != PATHWAY_COLOR) {
      return false;
    } else if (x == N - 1 && y == N - 1) {
      maze[x][y] = PATH_COLOR;
      return true;
    } else {
      maze[x][y] = PATH_COLOR;
      if(findMazePath(x - 1, y) || findMazePath(x, y + 1)
          || findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
        return true;
      }

      maze[x][y] = BLOCKED_COLOR;
      return false;
    }
  }

  /**
   * 미로를 출력
   */
  public static void printMaze() {
    for (int i = 0; i < N; i++) {
      for(int y = 0; y < N; y++) {
        System.out.print(maze[i][y] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
