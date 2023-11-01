import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static void testLinearSearch() {
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        System.out.println();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i : arr) {
            if (i == key) {
                System.out.println("Found");
                return;
            }
        }
        System.out.println("Not found");
    }

    private static void testBinarySearch() {
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with linear search? ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        System.out.println();
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int l = 0, r = arr.length;
        int m = arr.length / 2;
        while (l < r) {
            if (arr[m] == key) {
                System.out.println("Found");
                return;
            } else if (arr[m] < key) {
                l = m + 1;
            } else {
                r = m;
            }
            m = (l + r) / 2;
        }
        System.out.println("Not found");
    }

    private static void testBubbleSort() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 200 - 100);
        }
        // do I have to change the name of the algorithm? Will the autotests be able to parse the line?
        System.out.println("Data set before bubble sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // same question
        System.out.println("Data set after bubble sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static int[] merge(int[] arr, int[] brr){
        int[] crr = new int[arr.length + brr.length];
        int i = 0, j = 0, k = 0;
        while (i < arr.length || j < brr.length){
            if (j == brr.length){
                crr[k] = arr[i];
                i++;
            } else if (i == arr.length) {
                crr[k] = brr[j];
                j++;
            } else if (arr[i] < brr[j]){
                crr[k] = arr[i];
                i++;
            } else {
                crr[k] = brr[j];
                j++;
            }
            k++;
        }
        return crr;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int[] a = new int[arr.length / 2];
        int[] b = new int[arr.length - a.length];
        System.arraycopy(arr, 0, a, 0, a.length);
        System.arraycopy(arr, arr.length / 2, b, 0, b.length);

        a = mergeSort(a);
        b = mergeSort(b);
        arr = merge(a, b);
        return arr;

    }

    private static void testMergeSort() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 200 - 100);
        }
        // do I have to change the name of the algorithm? Will the autotests be able to parse the line?
        System.out.println("Data set before mergesort:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        arr = mergeSort(arr);

        System.out.println("Data set after mergesort:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();



    }


    public static void menu() {
        System.out.println("Menu of Searching and Sorting Testbed.");
        System.out.println();
        System.out.println("1) Linear searching");
        System.out.println("2) Binary searching");
        System.out.println("3) O(n^2) type of sorting");
        System.out.println("4) O(n*log(n)) type of sorting");
        System.out.println("5) Sorting performance");
        System.out.println();
        System.out.println("q/Q) Quit");
        System.out.println();
        System.out.print("Your choice: ");
    }

    public static String mainLogic(){
        menu();
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> testLinearSearch();
            case "2" -> testBinarySearch();
            case "3" -> testBubbleSort();
            case "4" -> testMergeSort();
            case "q", "Q" -> System.out.println("Bye!");
            default -> System.out.println("Invalid choice!");
        }
        return choice;
    }


    public static void main(String[] args) {
        while (!Objects.equals(mainLogic(), "q")) {
            System.out.println();
        }

    }
}