public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MinPQProcessor task1Processor = new MinPQProcessor();
        MinPriorityQueue<Job> task1Queue = task1Processor.readTask1IntoPQ("task1-input.txt"); // returns jobQueue
        System.out.println("\nTask 1:");
        task1Processor.printTask1ExecutionOrder(task1Queue);
        long end = System.currentTimeMillis();
        long runTime = end - start;
        System.out.println("Time to process task1: " + runTime);


        MinPQProcessor task2Processor = new MinPQProcessor();
        // issue with compareTo bc I can't implement it in >1 class
        MinPriorityQueue<PriorityJob> task2Queue = task2Processor.readTask2IntoPQ("task2-input.txt");
        System.out.println("\nTask 2:");
        task2Processor.printTask2ExecutionOrder(task2Queue);

        MinPQProcessor task3Processor = new MinPQProcessor();
        MinPriorityQueue<ArrivalJob> task3Queue = task3Processor.readTask3IntoPQ("task3-input.txt");
    }
}
