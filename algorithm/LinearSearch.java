
public class LinearSearch implements Searcher {
    @Override
    public int search(double value, double[] data) {
        /* TODO */
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }
}