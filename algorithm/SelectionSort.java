public class SelectionSort implements Sorter {
    /**
     * Sắp xếp mảng dữ liệu, sử dụng thuật toán Selection sort.
     * @param data
     * @param order: true sắp xếp theo thứ tự tăng dần, false sắp xếp theo thứ tự giảm dần.
     */
    @Override
    public void sort(double[] data, boolean order) {
        /* TODO */
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự tăng dần, sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] < data[minIdx]) {
                    minIdx = j;
                }
            }
            double temp = data[i];
            data[i] = data[minIdx];
            data[minIdx] = temp;
        }
    }

    /**
     * Sắp xếp mảng dữ liệu theo thứ tự giảm dần, sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (data[j] > data[maxIdx]) {
                    maxIdx = j;
                }
            }
            double temp = data[i];
            data[i] = data[maxIdx];
            data[maxIdx] = temp;
        }
    }
}