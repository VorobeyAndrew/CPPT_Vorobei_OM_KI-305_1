public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> integerList = new LinkedList<>();
        integerList.add(5);
        integerList.add(3);
        integerList.add(8);

        System.out.println("Integer List:");
        integerList.display();
        System.out.println("Minimum: " + integerList.findMinimum());

        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");

        System.out.println("\nString List:");
        stringList.display();
        System.out.println("Minimum: " + stringList.findMinimum());
    }
}