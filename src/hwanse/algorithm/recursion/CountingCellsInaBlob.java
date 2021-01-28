package hwanse.algorithm.recursion;

/**
 * Base case : 현재 픽셀이 image color 가 아니라면 0을 반환
 * Recursive case : 현재 픽셀이 image color 라면 먼저 현재 픽셀을 카운트 한다
 * 현재 픽셀이 중복 카운되는 것을 방지하기 위해 다른 색으로 칠한다.
 * 현재 픽셀이 이웃한 모든 픽셀들에 대해서 그 픽셀이 속한 blob 의 크기를 카운트하여 카운터에 더하고 반환
 */
public class CountingCellsInaBlob {

  private static int[][] blobs = new int[][] {
      {1, 0, 0, 0, 0, 0, 0, 1},
      {0, 1, 1, 0, 0, 1, 0, 0},
      {1, 1, 0, 0, 1, 0, 1, 0},
      {0, 0, 0, 0, 0, 1, 0, 0},
      {0, 1, 0, 1, 0, 1, 0, 0},
      {0, 1, 0, 1, 0, 1, 0, 0},
      {1, 0, 0, 0, 1, 0, 0, 1},
      {0, 1, 1, 0, 0, 1, 1, 1}
  };

  private static final int SIZE = 8;
  private static final int BACKGROUND_COLOR = 0;
  private static final int IMAGE_COLOR = 1;
  private static final int ALREADY_COUNTED = 2;

  public static void main(String[] args) {
    printCells();
    int selectedBlobSize = countCells(0,0);
    System.out.println(selectedBlobSize);
  }

  /**
   * 선택된 픽셀이 속한 Blob 의 사이즈를 구하기
   * 1. 배열의 크기를 벗어나지 않는다.
   * 2. 배경 Color 이거나 이미 카운트된 Color 는 0 을 반환한다
   * 3. 현재 방문한 픽셀을 카운트된 Color 로 칠한다.
   * 4. 현재 방문한 픽셀 포함 나머지 8 방향으로 인접된 픽셀이 이미지 픽셀일 경우 카운트를 더한다
   * @param x
   * @param y
   * @return
   */
  public static int countCells(int x, int y) {
    if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
      return 0;
    } else if (blobs[x][y] != IMAGE_COLOR) {
      return 0;
    } else {
      blobs[x][y] = ALREADY_COUNTED;
      return 1 + countCells(x - 1, y) + countCells(x - 1, y + 1)
           + countCells(x, y + 1) + countCells(x + 1, y + 1)
           + countCells(x + 1, y) + countCells(x + 1, y - 1)
           + countCells(x, y - 1) + countCells(x - 1, y - 1);
    }
  }

  public static void printCells() {
    for (int x = 0; x < SIZE; x++) {
      for (int y = 0; y < SIZE; y++) {
        System.out.print(blobs[x][y] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

}
