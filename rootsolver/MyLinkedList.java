public class MyLinkedList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        // Ban đầu danh sách rỗng
        this.top = null;
    }

    /**
     * Lấy kích thước danh sách
     * @return
     */
    public int size() {
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Lấy giá trị của node ở vị trí index
     * @return
     */
    public double get(int index) {
        MyNode node = getNodeByIndex(index);
        return node.data;
    }

    /**
     * Thay đổi giá trị của node ở vị trí index
     */
    public void set(double data, int index) {
        MyNode node = getNodeByIndex(index);
        node.data = data;
    }

    /**
     * Thêm node có giá trị data tại vị trí cuối danh sách
     * @param data
     */
    public void add(double data) {
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Thêm node có giá trị data tại vị trí index
     * @param data
     * @param index
     */
    public void insert(double data, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        MyNode newNode = new MyNode(data);
        if (index == 0) {
            newNode.next = top;
            top = newNode;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    /**
     * Xóa node tại vị trí index
     * @param index
     */
    public void remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            top = top.next;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        MyNode current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Lớp node cho danh sách liên kết.
     */
    private static class MyNode {
        double data;
        MyNode next;

        MyNode(double data) {
            this.data = data;
            this.next = null;
        }
    }
}