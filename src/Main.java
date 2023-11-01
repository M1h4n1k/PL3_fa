import java.util.Objects;
import java.util.Scanner;

public class Main {
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

    public static void testBinarySearch() {
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


    public static String mainLogic(){
        menu();
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> testLinearSearch();
            case "2" -> testBinarySearch();
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