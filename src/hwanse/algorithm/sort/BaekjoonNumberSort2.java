package hwanse.algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 이 문제는 퀵 정렬의 worst case 일때, 시간복잡도가 O(n^2) 인 점을 저격한 문제로 보임
 * Collections API 에서 제공해주는 sort 정렬은 TimeSort 방식이다
 * - TimeSort
 * : 반복 합병 및 삽입 정렬 알고리즘을 사용하는데 이렇게 두 가지가 섞인 알고리즘을
 * hybrid stable sorting algorithm 이라고 한다.
 * 1. 합병 정렬
 * 최선, 최악의 case 모두 O(N log N)을 보장
 * 2. 삽입 정렬
 * 최선일 경우 O(n), 최악일 경우 O(n^2)
 *
 * ==> 즉, TimeSort 는 합벽정렬의 최악의 case 와 삽입 정렬의 최선의 경우의 수를
 * 짬뽕한 알고리즘, 실제로 정렬 알고리즘에서 가장 많이 쓰이는 알고리즘이다.
 * 시간 복잡도는 O(n) ~ O(n log n)을 보장한다는 장점이 있다.
 */
public class BaekjoonNumberSort2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int length = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < length; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(list);
    printArray(list, bw);

    bw.flush();
    br.close();
    bw.close();

  }

  public static void printArray(List<Integer> arr, BufferedWriter bw) throws IOException {
    for (int data : arr) {
      bw.write(data + "\n");
    }
  }

}
