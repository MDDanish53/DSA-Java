// Problem 1 - Reverse the array

public class P1 {

  public static void revArr(int arr[]) {
    int revArr[] = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      revArr[i] = arr[arr.length - i - 1]; // main logic
    }
    printArr(revArr);
  }

  public static void printArr(int revArr[]) {
    for(int i = 0; i < revArr.length; i++) {
      System.out.print(revArr[i] + " ");
    }
  }

  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 4, 5 };
    revArr(arr);
  }
}
