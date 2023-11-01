abstract public class Sorter {
    protected int[] arr;

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

}


