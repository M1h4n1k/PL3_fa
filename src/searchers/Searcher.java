package searchers;

import java.util.Scanner;

abstract public class Searcher {
    protected int[] arr;
    protected String name = "searcher";

    public Searcher() {
        arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    abstract public boolean find(int key);

    public void testSearcher(){
        System.out.print("In the list are values 0, ..., 9; which value would you like to search with " + name + " search? ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        System.out.println();
        if (find(key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    }
}
