package searchers;

public class LinearSearcher extends Searcher {
    public LinearSearcher() {
        name = "linear";
    }

    public boolean find(int key) {
        for (int i : arr) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
}
