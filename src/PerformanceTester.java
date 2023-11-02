import sorters.BubbleSorter;
import sorters.InsertionSorter;
import sorters.MergeSorter;
import sorters.QSorter;
import sorters.Sorter;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class PerformanceTester {

    private final Map<String, ArrayList<Integer>> measurements;
    private final int base = 1000;
    private String longestName = "";
    private int biggestValue = 0;

    public void measureSorter(Sorter s){
        long startTime = System.currentTimeMillis();
        s.sort();
        long endTime = System.currentTimeMillis();
        // set empty if null
        measurements.computeIfAbsent(s.getName() + ",random,comparisons", k -> new ArrayList<Integer>());
        measurements.computeIfAbsent(s.getName() + ",random,ms", k -> new ArrayList<Integer>());

        measurements.get(s.getName() + ",random,comparisons").add(s.getComparisons());
        measurements.get(s.getName() + ",random,ms").add((int)(endTime - startTime));
        if (s.getName().length() > longestName.length()){
            longestName = s.getName();
        }
        if (s.getComparisons() > biggestValue){
            biggestValue = s.getComparisons();
        }
    }

    public PerformanceTester() {
        // why cant I just do [BubbleSorter, InsertionSorter, MergeSorter, QSorter] in java like in python...
        // I had an option to do that with chatgpt and google or to go with an ugly way...
        // Sorter[] srs = {BubbleSorter, InsertionSorter, MergeSorter, QSorter};
        measurements = new HashMap<>();
        for (int n = 1; n <= 10; n++) {
            measureSorter(new BubbleSorter(base * n));
            measureSorter(new InsertionSorter(base * n));
            measureSorter(new MergeSorter(base * n));
            measureSorter(new QSorter(base * n));
        }
    }

    private String padWithSpaces(int n){
        // it's possible to do that mathematically somehow, but I couldn't get the formula quickly and don't want to waste more time on it anymore
        return n + " ".repeat(Math.max(0, String.valueOf(biggestValue).length() - String.valueOf(n).length() + 2));
    }

    private String padWithSpaces(String key){
        return key + " ".repeat(Math.max(0, (longestName + ",random,comparisons").length() - key.length() + 3));
    }

    public void printResults(){
        // header
        System.out.print(padWithSpaces(""));
        for (int i = 1; i <= 10; i++){
            System.out.print(padWithSpaces(i * base));
        }
        System.out.println();

        // data
        String[] keys = measurements.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        for (String key : keys){
            ArrayList<Integer> mes = measurements.get(key);
            System.out.print(padWithSpaces(key));
            for (Integer m : mes) {
                System.out.print(padWithSpaces(m));
            }
            System.out.println();
        }


    }
}
