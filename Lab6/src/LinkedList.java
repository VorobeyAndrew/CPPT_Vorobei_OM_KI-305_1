class LinkedList<T extends Comparable<T>> implements myinterface<Integer> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T remove() {
        if (head == null) {
            return null;
        }

        T data = head.data;
        head = head.next;
        return data;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T findMinimum() {
        if (head == null) {
            return null;
        }

        T min = head.data;
        Node<T> current = head.next;

        while (current != null) {
            if (current.data.compareTo(min) < 0) {
                min = current.data;
            }
            current = current.next;
        }

        return min;
    }
    @Override
    public void add_and_print_t(Integer t) {
        // Додавання одиниці до параметру
        int result = t + 1;

        // Виведення результату на екран
        System.out.println(result);
    }
}

