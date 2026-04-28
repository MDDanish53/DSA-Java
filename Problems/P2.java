// Problem 2 - to find max and min value in an array

public class P2 {

  public static void findMax(int arr[]) {
    int max;
    max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    System.out.println("Max value is = " + max);
  }

  public static void findMin(int arr[]) {
    int min;
    min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    System.out.println("Minimum value is = " + min);
  }

  public static void performOperation(int arr[], String choice) {
    if (choice == "max") {
      findMax(arr);
    } else if (choice == "min") {
      findMin(arr);
    } else {
      System.out.println("Invalid choice");
    }
  }

  public static void main(String args[]) {
    int arr[] = { 45, 62, 54, 12, 69, 42, 23 };
    performOperation(arr, "kuchbhi");
  }
}
