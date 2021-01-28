package hwanse.algorithm.recursion;

/**
 * 순환적 알고리즘 설계
 * 1. 암시적(implicit) 매개변수를 명시적(explicit) 매개변수로 바꾸어라.
 */
public class Practice3 {

  public static void main(String[] args) {
    //순차 탐색
    int[] arr = new int[] {6, 3, 1, 0, 7};
    int result = search(arr, 0, arr.length - 1, 7);
    System.out.println(result);

    // 순참 탐색2
    int result2 = divideSearch(arr, 0, arr.length - 1, 6);
    System.out.println(result2);

    // 최대 값 탐색
    int result3 = findMax(arr, 0, arr.length - 1);
    System.out.println(result3);
  }

  /**
   * 순환 탐색을 Recursion 방식으로 구현.
   *  - 암시적 매개변수들을 명시적 매개변수로 바꾸어서 표현해보자.
   * @param data    : input 정수형 배열
   * @param begin   : 탐색 시작 index 지점
   * @param end     : 탐색 종료 index 지점
   * @param target  : 탐색할 목표 값
   * @return  : 탐색 결과의 위치 index 반환
   */
  public static int search(int[] data, int begin, int end, int target) {
    if (begin > end) {
      return -1;
    } else if (target == data[begin]) {
      return begin;
    } else {
      return search(data, begin + 1, end, target);
    }
  }

  /**
   * 순차 탐색2
   * @param data    input 정수형 배열
   * @param begin   시작 index
   * @param end     마지막 index
   * @param target  탐색할 목표 값
   * @return  탐색 결과 index
   */
  public static int divideSearch(int[] data, int begin, int end, int target) {
    if (begin > end) {
      return -1;
    } else {
      int middle = (begin + end) / 2;
      if (data[middle] == target) {
        return middle;
      }

      int index = divideSearch(data, begin, middle - 1, target);
      if (index != -1) {
        return index;
      } else {
        return divideSearch(data, middle + 1, end, target);
      }
    }
  }

  public static int findMax(int[] data, int begin, int end) {
    if (begin == end) {
      return data[begin];
    } else {
      return Math.max(data[begin], findMax(data, begin + 1, end));
    }
  }

  public static int binarySearch(String[] items, String target, int begin, int end) {
    if (begin > end) {
      return -1;
    } else {
      int middle = (begin + end) / 2;
      int compareResult = target.compareTo(items[middle]);
      if(compareResult == 0) {
        return middle;
      } else if(compareResult < 0) {
        return binarySearch(items, target, begin, middle - 1);
      } else {
        return binarySearch(items, target, middle + 1, end);
      }
    }
  }

}
