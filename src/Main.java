public class Main {
    public static void main(String[] args) {
        MinPQProcessor MPQPtest = new MinPQProcessor();
        MinPriorityQueue<Job> task1Queue = MPQPtest.readIntoPQ("task1-input.txt"); // returns jobQueue
        MPQPtest.printExecutionOrder(task1Queue);

//        // Testing Min -> printed least to greatest
//        MinPriorityQueue<Integer> minTest = new MinPriorityQueue<Integer>(5);
//        minTest.insert(4);
//        minTest.insert(2);
//        minTest.insert(8);
//        minTest.insert(6);
//        minTest.insert(1);
//        for (int i = 0; i < 5; i++) {
//            System.out.print(minTest.delMin() + " ");
//        }
//        System.out.println();
    }
}
