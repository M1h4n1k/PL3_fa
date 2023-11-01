package sorters;

abstract public class Sorter {
    protected int[] arr;
    protected String name = "sorter name";

    public Sorter(){
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 200 - 100);
        }
    }

    abstract public void sort();

    public void printArray(){
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void testSorter() {
        System.out.println();
        System.out.println("Data set before " + name + " :");
        printArray();
        System.out.println();
        sort();
        System.out.println("Data set after " + name + " :");
        printArray();
    }

}


