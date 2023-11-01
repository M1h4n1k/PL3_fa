import searchers.BinarySearcher;
import searchers.LinearSearcher;
import sorters.BubbleSorter;
import sorters.MergeSorter;

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

    public static String mainLogic(){
        menu();
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        switch (choice) {
            case "1" -> new LinearSearcher().testSearcher();
            case "2" -> new BinarySearcher().testSearcher();
            case "3" -> new BubbleSorter().testSorter();
            case "4" -> new MergeSorter().testSorter();
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