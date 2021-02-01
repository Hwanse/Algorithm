package hwanse.algorithm.sort;

/**
 * 퀵 정렬의 이론적으로 다음과 같은 단계로 이루어짐
 * 1. 분할(divide) : 입력 배열을 피벗을 기준으로 2개의 부분 배열로 분할
 * 2. 정복(conquer) : 부분 배열을 정렬한다.
 * 3. 결합(combine) : 정렬된 부분 배열들을 하나의 배열에 합병한다.
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] arr = new int[] {3, 9, 4, 7, 12, 5, 0, 1, 13,6, 8, 2, 10};
    long start = System.currentTimeMillis();
    printArray(arr);
    quickSort(arr);
    printArray(arr);
    System.out.println("runtime sec : " + ((System.currentTimeMillis() - start) / 1000.0));

  }

  private static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  /**
   * 퀵 정렬을 순환 호출 방식으로 구현하는 함수
   * 1. 먼저 배열을 파티셔닝을 한다
   * 2. 파티셔닝 결과값을 기준으로 퀵 정렬을 순환 호출한다
   * @param arr   정렬할 배열
   * @param start 시작 index
   * @param end   마지막 index
   */
  private static void quickSort(int[] arr, int start, int end) {
    int part2 = partition(arr, start, end);
    if (start < part2 - 1) {
      quickSort(arr, start, part2 - 1);
    }
    if (part2 < end) {
      quickSort(arr, part2, end);
    }

  }

  /**
   * 실제 정렬을 수행하는 함수
   * 1. 피벗 값을 해당 배열 range에 중간값으로 임의로 지정
   * 2. left 커서가 right 커서보다 작거나 같을 경우에는 정렬을 수행
   * 3. (left 커서 값 > 피벗 값 and right 커서 값 < 피벗 값) 일때 스왑
   * 4. 위 과정이 끝나면 마지막의 left 커서의 index 값을 반환
   * @param arr   정렬할 배열
   * @param left 시작 커서 위치(index) 포인터의 역할
   * @param right   마지막 커서 위치(index) 포인터의 역할
   * @return
   */
  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right){
      while (arr[left] < pivot) left++;
      while (arr[right] > pivot) right--;
      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }
    return left;
  }

  private static void swap(int[] arr, int start, int end) {
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
  }

  private static void printArray(int[] arr) {
    for (int number : arr) {
      System.out.print(number + ", ");
    }
    System.out.println();
  }
}
