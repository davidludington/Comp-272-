import java.util.*;

public class LUCSorter {
  private int[] a;

  public LUCSorter(int[] anArray) {
    a = anArray;
  }

  public void divisibleByKFirst(int k) {
    if (k == 0)
      return;

    if (a.length <= 1)
      return;
    int[] first = new int[a.length / 2];
    int[] second = new int[a.length - first.length];
    System.arraycopy(a, 0, first, 0, first.length);
    System.arraycopy(a, first.length, second, 0, second.length);
    LUCSorter firstSorter = new LUCSorter(first);
    LUCSorter secondSorter = new LUCSorter(second);
    firstSorter.divisibleByKFirst(k);
    secondSorter.divisibleByKFirst(k);
    merge(first, second, k);
  }

  private void merge(int[] first, int[] second, int k) {
    // Add your code below
    int i = 0, j = 0, index = 0;

    // Merge the two sorted arrays
    while (i < first.length && j < second.length) {
      if (first[i] % k == 0) {
        a[index++] = first[i++];
      } else if (second[j] % k == 0) {
        a[index++] = second[j++];
      } else {
        if (first[i] < second[j]) {
          a[index++] = first[i++];
          
        } else {
          a[index++] = second[j++];
        }
      }
    }

    

    // Copy remaining elements from the first array if lists are not the same lengh
    while (i < first.length && first[i] % k == 0) {
      a[index++] = first[i++];
    }
    while (j < second.length && second[j] % k == 0) {
      a[index++] = second[j++];
    }
    while (i < first.length) {
      a[index++] = first[i++];
    }
    while (j < second.length) {
      a[index++] = second[j++];
    }

  }

  // This method is used to check your work
  public static void check(int[] a, int k) {
    LUCSorter sorter = new LUCSorter(a);
    sorter.divisibleByKFirst(k);
  }
}

